package dota.skill;

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
	
	public void emit(Combater attacker, CombatTeam defenserTeam) {
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
		
		List<Combater> targets = selectTargets(attacker, defenserTeam);
		
		for (Combater e: targets) {
			emit1(attacker, e);
		}

	}
	
	private void emit1(Combater attacker,Combater defenser) {
		if (attacker == null || defenser == null) {
			return;
		}
		emit0(attacker, defenser);
	}
	
	protected abstract void emit0(Combater attacker,Combater defenser);

	public boolean canEmit() {
		if (CD > 0) {
			// System.out.println("技能正处于CD中");
			return false;
		}
		return true;
	}
	
	protected abstract List<Combater> selectTargets(Combater attacker, CombatTeam defenserTeam);
	
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
}
