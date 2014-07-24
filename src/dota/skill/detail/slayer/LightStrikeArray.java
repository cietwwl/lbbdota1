package dota.skill.detail.slayer;

import java.util.List;

import dota.ai.SelectTarget;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.print.PrintHelper;
import dota.skill.Skill;
import dota.team.CombatTeam;
import dota.util.OP;

@OP(CODE = Enums.SkillType.LIGHT_STRIKE_ARRAY_VALUE, TYPE = OP.SKILL)
public class LightStrikeArray extends Skill {

	public LightStrikeArray(SkillCfg config) {
		super(config);
	}

	@Override
	protected int emit0(Combater attacker, Combater target,
			CombatTeam attackTeam, CombatTeam defenseTeam) {
		int damage = target.beAttack(config.getDamage(), Enums.AttackType.MAGICAL_VALUE, attacker);
		target.getCombatState().beStun(config.getEffectTime());
		PrintHelper.SkillPrint(attacker, target, config.getName(), damage);
		return damage;
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker,
			CombatTeam defenserTeam, CombatTeam attackerTeam) {
		Combater target = SelectTarget.getOneOppentByRandom(attacker, defenserTeam, config.getEmitDistance());
		targets.addAll(SelectTarget.getAllTargetsOfScope(target, config.getEmitDistance(), defenserTeam));
	}

}
