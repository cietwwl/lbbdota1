package dota.skill.detail.shadowfiend;

import java.util.List;

import dota.ai.SelectTarget;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.print.PrintHelper;
import dota.skill.Skill;
import dota.util.CombaterHelper;
import dota.util.OP;
import dota.util.Point;

// 影压
@OP(CODE = Enums.SkillType.REAL_SHADOW_RAZE_VALUE, TYPE = OP.SKILL)
public class RealShadowRaze extends Skill {

	public RealShadowRaze(SkillCfg config) {
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
		// SF影压，暂时用这个函数来选择方向 TODO
		Combater target = SelectTarget.getOneOppentByRandom(attacker, 100000);
		Point p = CombaterHelper.getPointInSegment(attacker, target, config.getEmitDistance());
		targets.addAll(SelectTarget.getAllTargetsOfScope(p.x, p.y, config.getEffectScope(), attacker.getTeam().getOppentTeam()));
	}

}
