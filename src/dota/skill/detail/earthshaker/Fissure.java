package dota.skill.detail.earthshaker;

import java.util.List;

import dota.ai.SelectTarget;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.print.PrintHelper;
import dota.skill.Skill;
import dota.util.CombaterHelper;
import dota.util.OP;

/*
 * 老牛F
 */
@OP(CODE = Enums.SkillType.FISSURE_VALUE, TYPE = OP.SKILL)
public class Fissure extends Skill{
	
	public Fissure(SkillCfg config) {
		super(config);
	}

	@Override
	protected int emit0(Combater attacker, Combater defenser) {
		int damage = defenser.beAttack(config.getDamage(), Enums.AttackType.MAGICAL_VALUE);
		defenser.getCombatState().beStun(config.getEffectTime());
		PrintHelper.SkillPrint(attacker, defenser, config.getName(), damage, config.getEffectTime());
		return damage;
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker) {
		Combater target = SelectTarget.getOneOppentByRandom(attacker, config.getEmitDistance());
		
		// 选择该条直线上的所有英雄
		for (Combater e : attacker.getTeam().getOppentTeam()) {
			if (e.isLive() && CombaterHelper.isInSegment(attacker, target, e, config.getEmitDistance())) {
				targets.add(e);
			}
		}
	}
	
}
