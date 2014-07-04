package dota.skill.detail.earthshaker;

import java.util.List;

import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.skill.Skill;
import dota.team.CombatTeam;
import dota.util.HeroHelper;

// 回音击
public class EchoSlam extends Skill {
	
	private int damage = 0;
	
	public EchoSlam(SkillCfg config) {
		super(config);
	}

	@Override
	protected void emit0(Combater attacker, Combater target) {
		target.beAttack(damage, Enums.AttackType.MAGICAL_VALUE);
		System.out.println(attacker.getName() + " 的回音击对 " + target.getName() + " 造成 " + damage + " 的伤害");
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker,
			CombatTeam defenserTeam) {
		for (Combater e: defenserTeam) {
			if (e.isLive() && HeroHelper.getDistanceBetweenCombaters(attacker, e) <= config.getEffectScope()) {
				targets.add(e);
			}
		}
		damage = config.getDamage() + config.getDamagePara1() * targets.size();
	}

}
