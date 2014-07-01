package dota.hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dota.buff.Buff;
import dota.buff.BuffFactory;
import dota.buff.BuffManager;
import dota.config.BuffConfig;
import dota.config.SkillConfig;
import dota.enums.Enums;
import dota.skill.Skill;
import dota.skill.SkillFactory;
import dota.skill.SkillManager;

public abstract class Combater extends Character{
	
	public int position = 0;						// 位置
	
	protected SkillManager skillManager = null;		// 技能
	
	protected BuffManager buffManager = null;		// BUFF
	
	private CombatStateManager combatStateManager = null; // state
	
	private int controlType = 0;	// 控制类型，0AI,1手动
	
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
		if(combatStateManager.getLeftStunCounts() > 0) {
			System.out.println("处于眩晕状态");
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
		int armor = getRealArmor();
		int realDamage = (int)((1 - 0.06 * armor)/(1 + 0.06 * armor) * damage);
		return realDamage;
	}
	
	public boolean isLive() {
		return hp.current > 0;
	}
	
	protected int isCrit() {
		if(Math.random() < crite.key/100.0) {
			//TODO
			return crite.value;
		}
		return 0;
	}
	
	public void attack(Combater defenser) {
		Skill skill = selectSkill();
		skill.emit(defenser);

		if(skill.getType() == 0) {
			onCommonAttack();
		} else {
			onEmitAnySkill(defenser);
		}
	}
	
	public void onCommonAttack() {
		buffManager.onCommonAttack();
	}
	
	public void onEmitAnySkill(Combater defenser) {
		buffManager.onEmitAnySkill(defenser);
	}
	
	/*
	 * 0,默认技能
	 * 1,玩家选择技能
	 * 2,AI
	 */
	private Skill selectSkill() {
		if(controlType == 1) {
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
			return skillManager.getDefaultSkill();
		}
	}
	
	public void addSkill(SkillConfig config) {
		Skill skill = SkillFactory.creatSkill(config, this);
		skillManager.add(skill);
	}
	
	public void addBuff(BuffConfig config) {
		Buff buff = BuffFactory.creatBuff(config, this);
		buff.init();
		buff.start();
		buffManager.add(buff);
	}
	
	
	public void printBuff() {
		buffManager.printAll();
	}
	
	public void battleInit(Combater defenser) {
		skillManager.emitPassiveSkill(defenser);
	}

	public String getCrit() {
		// TODO Auto-generated method stub
		return null;
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


