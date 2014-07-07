package dota.skill;

import java.util.ArrayList;
import java.util.List;

import dota.config.ParamConfig;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.team.CombatTeam;

public abstract class Skill {
	protected SkillCfg config;
	private int CD = 0; // MS
	
	public int getCD() {
		return CD;
	}
	
	public Skill(SkillCfg config) {
		this.config = config;
	}
	
	public SkillCfg getConfig() {
		return config;
	}
	
	public void update() {
		decreaseCD();
	}
	
	private void decreaseCD() {
		if (CD == 0) {
			return;
		}
		CD -= ParamConfig.BattleInterval;
	}
	
	public void emit(Combater attacker, CombatTeam defenserTeam, CombatTeam attackerTeam) {
		if (!canEmit()) {
			return;
		}
		
		if (config.getEmitType() == Enums.SkillEmitType.PASSIVE_VALUE) {
			CD = 999999;
		} else if (config.getSkillType() == Enums.SkillType.COMMON_VALUE){
			CD = attacker.getAttackSpeed();
		} else {
			CD = config.getCd();
		}
		
		
		List<Combater> targets = selectTargets(attacker, defenserTeam, attackerTeam);
		
		if (targets.size() == 0) {
			return;
		}
		
		if (config.getSkillType() != Enums.SkillType.COMMON_VALUE) {
			System.out.println(attacker.getName() + " 释放 技能 " + config.getName());
		}
		
		int damage = 0;
		for (Combater e: targets) {
			damage = emit1(attacker, e);
		}
		
		if (config.getSkillType() == Enums.SkillType.COMMON_VALUE) {
			attacker.onCommonAttack(attacker, defenserTeam, damage);
		} else if (config.getEmitType() == Enums.SkillEmitType.ACTIEVE_VALUE) {
			attacker.onEmitAnyActiveSkill(defenserTeam);
		}
	}
	
	private int emit1(Combater attacker,Combater target) {
		if (attacker == null || target == null) {
			return 0;
		}
		return emit0(attacker, target);
	}
	
	protected abstract int emit0(Combater attacker, Combater target);

	public boolean canEmit() {
		if (CD > 0) {
			// System.out.println("技能正处于CD中");
			return false;
		}
		return true;
	}
	
	private List<Combater> selectTargets(Combater attacker, CombatTeam defenserTeam, CombatTeam attackerTeam) {
		List<Combater> targets = new ArrayList<>();
		selectTargets0(targets, attacker, defenserTeam, attackerTeam);
		return targets;
	}
	
	protected abstract void selectTargets0(List<Combater> targets, Combater attacker,
			CombatTeam defenserTeam, CombatTeam attackerTeam);
	
	public static boolean canAttack(Combater attacker, Combater defenser, int distance) {
		int disX = attacker.positionX - defenser.positionX;
		int disY = attacker.positionY - defenser.positionY;
		int dis = (int) Math.sqrt(disX * disX + disY * disY);
		if (dis <= distance) {
			return true;
		}
		return false;
	}
	
	public static boolean isLine(int x1, int y1, int x2, int y2, int x3, int y3) {
		return (y2 - y1) * (x3 - x1) == (x2 - x1) * (y3 - y1);
	}
	
	protected void emitBuff(Combater target) {
		String[] buffs = config.getBuffs().split(",");
		for (int i = 0; i< buffs.length; i++) {
			target.addBuff(Integer.parseInt(buffs[i]));
			
		}
	}
}
