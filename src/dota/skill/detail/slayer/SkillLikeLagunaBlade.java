package dota.skill.detail.slayer;

import java.util.List;

import dota.ai.SelectTarget;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.print.PrintHelper;
import dota.skill.Skill;
import dota.util.OP;

@OP(CODE = Enums.SkillType.SKILL_LIKE_LAGUNA_BLADE_VALUE, TYPE = OP.SKILL)
public class SkillLikeLagunaBlade extends Skill {

	public SkillLikeLagunaBlade(SkillCfg config) {
		super(config);
	}

	@Override
	protected int emit0(Combater attacker, Combater target) {
		int damage = target.beAttack(config.getDamage(), Enums.AttackType.MAGICAL_VALUE);
		PrintHelper.SkillPrint(attacker, target, config.getName(), damage);
		return damage;
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker) {
		targets.add(SelectTarget.getOneOppentByRandom(attacker, config.getEmitDistance()));
	}

}
