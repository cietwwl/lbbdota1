package dota.skill.detail.earthshaker;

import java.util.ArrayList;
import java.util.List;

import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.skill.Skill;
import dota.team.CombatTeam;
import dota.util.DotaMath;
import dota.util.HeroHelper;
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
	protected int emit0(Combater attacker, Combater defenser, CombatTeam attackTeam, CombatTeam defenseTeam) {
		int damage = defenser.beAttack(config.getDamage(), Enums.AttackType.MAGICAL_VALUE, attacker);
		defenser.beStun(config.getEffectTime());
		System.out.println(attacker.getName() + " 对 " + defenser.getName() + "释放 " + this.getConfig().getName() + ", 造成" + damage + "的伤害和" + config.getEffectTime() + "的眩晕");
		return damage;
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker,
			CombatTeam defenserTeam, CombatTeam attackerTeam) {
		List<Combater> candidate = new ArrayList<>();
		for (Combater e : defenserTeam) {
			if (e.isLive() && HeroHelper.isInRange(attacker, e, config.getEmitDistance())) {
				candidate.add(e);
			}
		}
		
		if (candidate.size() == 0) {
			return;
		}
		
		// 随机一个施法目标
		int random = DotaMath.RandomInRange(0, candidate.size() - 1);
		Combater target = candidate.get(random);
		
		// 选择该条直线上的所有英雄
		for (Combater e : defenserTeam) {
			if (e.isLive() && HeroHelper.isInSegment(attacker, target, e, config.getEmitDistance())) {
				targets.add(e);
			}
		}
	}
	
}
