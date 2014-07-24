package dota.skill.detail.shadowfiend;

import java.util.List;

import dota.ai.SelectTarget;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.skill.Skill;
import dota.team.CombatTeam;
import dota.util.CombaterHelper;
import dota.util.OP;
import dota.util.Point;

@OP(CODE = Enums.SkillType.REAL_SHADOW_RAZE_VALUE, TYPE = OP.SKILL)
public class RealShadowRaze extends Skill {

	public RealShadowRaze(SkillCfg config) {
		super(config);
	}

	@Override
	protected int emit0(Combater attacker, Combater target, CombatTeam attackTeam, CombatTeam defenseTeam) {
		int damage = target.beAttack(config.getDamage(), Enums.AttackType.PHYSICAL_VALUE, attacker);
		System.out.println(attacker.getName() + " 的 " + config.getName() + " 对 " + target.getName() + " 造成 " + damage + " 的伤害");
		return damage;
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker,
			CombatTeam defenserTeam, CombatTeam attackerTeam) {
		// SF影压，暂时用这个函数来选择方向 TODO
		Combater target = SelectTarget.getOneOppentByRandom(attacker, defenserTeam, 100000);
		Point p = CombaterHelper.getPointInSegment(attacker, target, config.getEmitDistance());
		targets.addAll(SelectTarget.getAllTargetsOfScope(p.x, p.y, config.getEffectScope(), defenserTeam));
	}

}
