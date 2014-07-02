package dota.skill;

import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.team.CombatTeam;

public abstract class Skill {
	protected SkillCfg config;
	private int CD = 0;
	
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
		CD--;
	}
	
	public void emit(Combater attacker, CombatTeam targets) {
		if (!canEmit()) {
			return;
		}
		
		if (config.getEmitType() == Enums.SkillEmitType.PASSIVE_VALUE) {
			CD = 999999;
		} else {
			CD = config.getCd();
		}
		
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
			System.out.println("技能正处于CD中");
			return false;
		}
		return true;
	}
}
