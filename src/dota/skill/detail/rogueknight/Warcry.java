package dota.skill.detail.rogueknight;

import java.util.List;

import dota.ai.SelectTarget;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.skill.Skill;
import dota.team.CombatTeam;
import dota.util.OPHandler;

@OPHandler(CODE = Enums.SkillType.WARCRY_VALUE)
public class Warcry extends Skill {

	public Warcry(SkillCfg config) {
		super(config);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int emit0(Combater attacker, Combater target) {
		emitBuff(target);
		return 0;
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker,
			CombatTeam defenserTeam, CombatTeam attackerTeam) {
		targets.addAll(SelectTarget.getAllTargetsOfScope(attacker, config.getEffectScope(), attackerTeam));
	}

}
