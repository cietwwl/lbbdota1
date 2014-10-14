package dota.hero;

import dota.ai.SelectSkill;
import dota.buff.Buff;
import dota.buff.BuffFactory;
import dota.buff.BuffManager;
import dota.config.generated.BuffCfg;
import dota.config.generated.GameConfig;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.print.PrintHelper;
import dota.skill.Skill;
import dota.skill.SkillFactory;
import dota.skill.SkillManager;
import dota.team.CombatTeam;

public abstract class Combater extends Character{
	
	private int id;
	
	private CombatTeam team = null;
	
	public int positionX = 0;						// 位置
	public int positionY = 0;
	
	protected int attackDistance = 0; 
	
	protected SkillManager skillManager = null;		// 技能
	
	protected BuffManager buffManager = null;		// BUFF
	
	protected CombatState combatState = new CombatState(); // state
	
	private int controlType = 0;	// 控制类型，0AI,1手动
	
	protected float ias = 1f; // 攻击速度提升, 百分比小数
	protected int base_attack_speed = 10;
	
	public void setControlType(int type) {
		this.controlType = type;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setTeam(CombatTeam team) {
		this.team = team;
	}
	
	public CombatTeam getTeam() {
		return team;
	}
	
	public void addIas(float add) {
		ias += add;
	}
	
	public void removeIas(float rm) {
		ias -= rm;
	}
	
	// 每回合更新
	public void update() {
		combatState.update();
		skillManager.update();
		buffManager.update(this);
	}
	
	public CombatState getCombatState() {
		return combatState;
	}
	
	// 是否可以行动
	public boolean canAct() {
		
		if (!isLive()) {
			return false;
		}
		
		if (combatState.getStun() > 0) {
			// System.out.println(getName() + " 处于眩晕状态");
			return false;
		}
		
		if (combatState.getEmitting()) {
			return false;
		}
		
		if (combatState.getBeEmittingCounts() > 0) {
			return false;
		}
		
		return true;
	}
	
	// 受到指定伤害
	public int beAttack(int damage, int type) {
		if (!isLive()) {
			return 0;
		}
		
		int realDamage = damageToHp(damage, type);
		hp.current -= realDamage;
		
		return realDamage;
	}
	
	// 伤害实际扣掉的血
	private int damageToHp(int damage, int type) {
		int realDamage = 0;
		switch (type) {
		case Enums.AttackType.PHYSICAL_VALUE:
			float armor = getRealArmor();
			realDamage = (int)((1 - 0.06 * armor)/(1 + 0.06 * armor) * damage);
		case Enums.AttackType.MAGICAL_VALUE:
			realDamage = damage - damage * magicRes/100; 
		}

		return realDamage;
	}
	
	public boolean isLive() {
		return hp.current > 0;
	}
	
	
	public void attack(CombatTeam defensers, CombatTeam attackerTeam) {
		Skill skill = SelectSkill.selectSkill(skillManager);
		
		if (skill == null) {
			return ;
		}
		
		skill.emit(this);
	}
	
	public void onCommonAttack(int damage) {
		buffManager.triggerBuffEvent(Enums.BuffEvent.COMMON_ATTACK_VALUE, damage, null, null);;
	}
	
	public void onEmitAnyActiveSkill() {
		buffManager.triggerBuffEvent(Enums.BuffEvent.EMIT_ANY_ACTIVE_SKILL_VALUE, 0, null, null);
	}
	
	public void onKillAnyCombater(Combater soul) {
		buffManager.triggerBuffEvent(Enums.BuffEvent.KILL_ANY_COMBATER_VALUE, 0, soul, null);
	}
	
	public void onDeath() {
		buffManager.triggerBuffEvent(Enums.BuffEvent.OWNER_DEATH_VALUE, 0, null, null);
	}
	
	public void learnSkill(SkillCfg config) {
		Skill skill = SkillFactory.createSkill(config);
		skillManager.add(skill);
		if (config.getSkillType() != Enums.SkillType.COMMON_VALUE) {
			PrintHelper.SkillLearnPrint(this, config.getName());
		}
		if (config.getEmitType() == Enums.SkillEmitType.PASSIVE_VALUE) {
			skill.emit(this);
		}
	}
	
	public void addBuff(int cfgId) {
		BuffCfg config = GameConfig.getInstance().getBuffCfg(cfgId);
		PrintHelper.BuffGetPrint(this, config.getName());
		addBuff(config);
	}
	
	private void addBuff(BuffCfg config) {
		Buff buff = BuffFactory.creatBuff(config);
		buff.init();
		buffManager.add(buff);
		buff.start(this);
	}
	
	public void printBuff() {
		// buffManager.printAll();
	}
	
	public int getAttackDistance() {
		return attackDistance;
	}
	
	public void setPosition(int x, int y) {
		positionX = x;
		positionY = y;
	}
	
	public int getAttackSpeed() {
		return (int) (base_attack_speed/ias); // MS/攻击次数
	}
	
	public BuffManager getBuffManager() {
		return this.buffManager;
	}
	
	public void learnSkills() {
		
	}
}



