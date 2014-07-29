package dota.skill;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dota.config.ParamConfig;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.print.PrintHelper;

public abstract class Skill {
	
	private static final int SKILL_PASSIVE_CD = -9999; // 被动技能CD
	
	protected SkillCfg config;   // 配置表	
	private int CD = 0;			// MS
	
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
		if (CD <= 0) {
			return;
		}
		CD -= ParamConfig.BattleInterval;
	}
	
	public void emit(Combater emiter) {
		if (!canEmit()) {
			return;
		}
		
		List<Combater> targets = selectTargets(emiter);
		if (targets.size() == 0) {
			return;
		}
		
		setCD(emiter);
		printEmit(emiter);
		
		int damage = 0;
		for (Combater e: targets) {
			damage = emit1(emiter, e);	
		}
		
		if (config.getSkillType() == Enums.SkillType.COMMON_VALUE) {
			emiter.onCommonAttack(damage);
		} else if (config.getEmitType() != Enums.SkillEmitType.PASSIVE_VALUE) {
			emiter.onEmitAnyActiveSkill();
		}
	}
	
	public boolean canEmit() {
		if (CD > 0) {
			return false;
		}
		
		return true;
	}
	
	private List<Combater> selectTargets(Combater attacker) {
		List<Combater> targets = new ArrayList<>();
		selectTargets0(targets, attacker);
		Iterator<Combater> it = targets.iterator();
		while (it.hasNext()) {
			if (it.next() == null) {
				it.remove();
			}
		}
		return targets;
	}
	
	protected abstract void selectTargets0(List<Combater> targets, Combater attacker);
	
	private void setCD(Combater attacker) {
		if (config.getEmitType() == Enums.SkillEmitType.PASSIVE_VALUE) {
			CD = SKILL_PASSIVE_CD;
		} else {
			if (config.getSkillType() == Enums.SkillType.COMMON_VALUE) {
				CD = attacker.getAttackSpeed();
			} else {
				CD = config.getCd();
			}
		}
	}
	
	private void printEmit(Combater attacker) {
		
		if (config.getEmitType() == Enums.SkillEmitType.PASSIVE_VALUE) {
			return;
		}
		
		PrintHelper.SkillEmitPrint(attacker, config.getName());
	}
	
	private int emit1(Combater attacker,Combater target) {
		if (attacker == null || target == null) {
			return 0;
		}
		
		if (!target.isLive()) {
			return 0;
		}
		
		int damage = emit0(attacker, target);
		
		if (!target.isLive()) {
			PrintHelper.KillPrint(attacker, target);
			attacker.onKillAnyCombater(target);
			target.onDeath();
		}
		
		return damage;
	}
	
	protected abstract int emit0(Combater attacker, Combater target);
	
	protected static void emitBuff(Combater target, String buffs) {
		String[] buffs0 = buffs.split(",");
		for (int i = 0; i< buffs0.length; i++) {
			target.addBuff(Integer.parseInt(buffs0[i]));	
		}
	}
}
