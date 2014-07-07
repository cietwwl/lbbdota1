package dota.skill.detail.rogueknight;

import java.util.List;

import dota.config.generated.SkillCfg;
import dota.hero.Combater;
import dota.skill.Skill;
import dota.team.CombatTeam;

public class GreatCleave extends Skill{

	public GreatCleave(SkillCfg config) {
		super(config);
	}

	@Override
	protected int emit0(Combater attacker, Combater target) {
		String[] buffs = config.getBuffs().split(",");
		for (int i = 0; i< buffs.length; i++) {
			target.addBuff(Integer.parseInt(buffs[i]));
		}
		return 0;
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker,
			CombatTeam defenserTeam, CombatTeam attackerTeam) {
		targets.add(attacker);
	}

}
