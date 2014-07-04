package dota.skill.detail.earthshaker;

import java.util.List;

import dota.config.generated.SkillCfg;
import dota.hero.Combater;
import dota.skill.Skill;
import dota.team.CombatTeam;

public class Aftershock extends Skill{

	public Aftershock(SkillCfg config) {
		super(config);
	}

	@Override
	protected void emit0(Combater attacker, Combater target) {
		String[] buffs = config.getBuffs().split(",");
		for (int i = 0; i< buffs.length; i++) {
			target.addBuff(Integer.parseInt(buffs[i]));
		}
	}

	@Override
	protected void selectTargets0( List<Combater> targets, Combater attacker,
			CombatTeam defenserTeam) {
		targets.add(attacker);
	}

}
