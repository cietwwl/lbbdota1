package dota.skill.detail.butcher;

import java.util.List;

import dota.ai.SelectTarget;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.print.PrintHelper;
import dota.skill.Skill;
import dota.team.CombatTeam;
import dota.util.CombaterHelper;
import dota.util.OP;

@OP(CODE = Enums.SkillType.MEAT_HOOK_VALUE, TYPE = OP.SKILL)
public class MeatHook extends Skill {

	public MeatHook(SkillCfg config) {
		super(config);
	}

	@Override
	protected int emit0(Combater attacker, Combater target) {
		target.positionX = attacker.positionX;
		target.positionY = attacker.positionY;
		int damage = target.beAttack(config.getDamage(), Enums.AttackType.MAGICAL_VALUE);
		PrintHelper.SkillPrint(attacker, target, config.getName(), damage);
		return damage;
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker) {	
		Combater target = SelectTarget.getOneOppentByRandom(attacker, config.getEmitDistance());
		int distance = CombaterHelper.getDistanceBetweenCombaters(attacker, target);
		// 选择该条直线上的所有英雄
		for (Combater e : attacker.getTeam().getOppentTeam()) {
			if (e.isLive() && CombaterHelper.isInSegment(attacker, target, e, distance)) {
				targets.add(e);
				return;
			}
		}
		targets.add(target);
	}
	
}
