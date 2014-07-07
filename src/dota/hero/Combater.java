package dota.hero;

import java.util.List;
import java.util.Scanner;

import dota.buff.Buff;
import dota.buff.BuffFactory;
import dota.buff.BuffManager;
import dota.config.generated.BuffCfg;
import dota.config.generated.GameConfig;
import dota.config.generated.SkillCfg;
import dota.skill.Skill;
import dota.skill.SkillFactory;
import dota.skill.SkillManager;
import dota.team.CombatTeam;
import dota.util.DotaMath;

public abstract class Combater extends Character{
	
	public int positionX = 0;						// 位置
	public int positionY = 0;
	
	protected int attackDistance = 0; 
	
	protected SkillManager skillManager = null;		// 技能
	
	protected BuffManager buffManager = null;		// BUFF
	
	protected CombatStateManager combatStateManager = new CombatStateManager(); // state
	
	private int controlType = 0;	// 控制类型，0AI,1手动
	
	protected float ias = 1f; // 攻击速度提升
	protected int base_attack_speed = 10;
	
	public void setControlType(int type) {
		this.controlType = type;
	}
	
	// 被击晕
	public void beStun(int count) {
		combatStateManager.beStun(count);
	}
	
	public void decreaseStun() {
		combatStateManager.decreaseStun();
	}
	
	public void clearStun() {
		combatStateManager.clearStun();
	}
	
	// 每回合更新
	public void update() {
		decreaseStun();
		skillManager.update();
		buffManager.update();
	}
	
	// 是否可以行动
	public boolean canAct() {
		
		if (!isLive()) {
			return false;
		}
		
		if(combatStateManager.getLeftStunCounts() > 0) {
			// System.out.println(getName() + " 处于眩晕状态");
			return false;
		}
		return true;
	}
	
	// 受到指定伤害
	public int beAttack(int damage, int type) {
		int realDamage = damageToHp(damage, type);
		hp.current -= realDamage;
		return realDamage;
	}
	
	// 伤害实际扣掉的血
	private int damageToHp(int damage, int type) {
		float armor = getRealArmor();
		int realDamage = (int)((1 - 0.06 * armor)/(1 + 0.06 * armor) * damage);
		return realDamage;
	}
	
	public boolean isLive() {
		return hp.current > 0;
	}
	
	
	public void attack(CombatTeam defensers, CombatTeam attackerTeam) {
		Skill skill = selectSkill();
		
		if (skill == null) {
			return ;
		}
		
		skill.emit(this, defensers, attackerTeam);
	}
	
	public void onCommonAttack(Combater attacker, CombatTeam defenser, int damage) {
		buffManager.onCommonAttack(attacker, defenser, damage);
	}
	
	public void onEmitAnyActiveSkill(CombatTeam defenseTeam) {
		buffManager.onEmitAnyActiveSkill(this, defenseTeam);
	}
	
	/*
	 * 0,默认技能
	 * 1,玩家选择技能
	 * 2,AI
	 */
	private Skill selectSkill() {
		if(controlType == 1) {
			@SuppressWarnings("resource")
			Scanner sin = new Scanner(System.in);
			skillManager.printAll();
			System.out.print("选择技能:");
			int n = sin.nextInt();
			while(!skillManager.canEmit(n)) {
				System.out.print("重新选择技能:");
				n = sin.nextInt();
			}
			
			return skillManager.getSkill(n, 0);
		}
		else {
			return randomSkill();
		}
	}
	
	//
	private Skill randomSkill() {
		List<Skill> candidate = skillManager.getCanEmitSkills();
		if (candidate.size() == 0) {
			return null;
		}
		return candidate.get(DotaMath.RandomInRange(0, candidate.size() - 1));
	}
	
	public void addSkill(SkillCfg config) {
		Skill skill = SkillFactory.createSkill(config);
		skillManager.add(skill);
	}
	
	public void addBuff(int cfgId) {
		BuffCfg config = GameConfig.getInstance().getBuffCfg(cfgId);
		addBuff(config);
		System.out.println(this.getName() + " 获得了BUFF " + config.getName());
	}
	
	private void addBuff(BuffCfg config) {
		Buff buff = BuffFactory.creatBuff(config, this);
		buff.init();
		buff.start(this);
		buffManager.add(buff);
	}
	
	public void printBuff() {
		buffManager.printAll();
	}
	
	public void battleInit(CombatTeam targets, CombatTeam attackerTeam) {
		skillManager.emitPassiveSkill(this, targets, attackerTeam);
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
	
	
}

class CombatState {
	public int type;
	public int value;
	
	public CombatState(int type, int value) {
		this.type = type;
		this.value = value;
	}
}


