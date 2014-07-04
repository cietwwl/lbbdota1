package dota.skill.detail.earthshaker;

import java.util.ArrayList;
import java.util.List;

import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.skill.Skill;
import dota.team.CombatTeam;
import dota.util.DotaMath;

/*
 * 老牛F
 */
public class Fissure extends Skill{
	
	public Fissure(SkillCfg config) {
		super(config);
	}

	@Override
	protected void emit0(Combater attacker, Combater defenser) {
		int damage = defenser.beAttack(config.getDamage(), Enums.AttackType.MAGICAL_VALUE);
		defenser.beStun(config.getEffectTime());
		System.out.println(attacker.getName() + " 对 " + defenser.getName() + "释放 " + this.getConfig().getName() + ", 造成" + damage + "的伤害和" + config.getEffectTime() + "的眩晕");
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker,
			CombatTeam defenserTeam) {
		List<Combater> candidate = new ArrayList<>();
		for (Combater e : defenserTeam) {
			if (e.isLive() && canAttack(attacker, e, config.getEmitDistance())) {
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
			if (e.isLive() && isLine(attacker.positionX, attacker.positionY,
					target.positionX, target.positionY, 
					e.positionX, e.positionY)) {
				targets.add(e);
			}
		}
	}
	
}
