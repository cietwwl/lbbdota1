package dota.skill.detail;

import java.util.ArrayList;
import java.util.List;

import dota.config.ParamConfig;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.skill.Skill;
import dota.team.CombatTeam;
import dota.util.DotaMath;
import dota.util.OPHandler;

@OPHandler(CODE = Enums.SkillType.COMMON_VALUE)
public class CommonAttackSkill extends Skill {

	public CommonAttackSkill(SkillCfg config) {
		super(config);
	}

	@Override
	public int emit0(Combater attacker, Combater defenser) {
		if (!defenser.isLive()) {
			return 0 ;
		}
		int damage = getAttackDamage(attacker);
		int realDamage = defenser.beAttack(damage, Enums.AttackType.PHYSICAL_VALUE);
		System.out.println(attacker.getName() + " 对 " + defenser.getName() + "释放 " + this.config.getName() + ", 造成" + realDamage + "的伤害");
		if (defenser.isLive()) {
			System.out.println(defenser.getName() + "剩余生命值: " + defenser.getCurrentHp());
		} else {
			System.out.println(defenser.getName() + " Die");
		}
		return damage;
	}
	
	private int getAttackDamage(Combater attacker) {
		int damage = getRandomAttack(attacker.getRealAttack());
		if(DotaMath.doesRandomSuccess(attacker.getCriteProbility())) {
			System.out.print("触发暴击,");
			return damage * (1 + attacker.getCriteValue());
		}
		return damage;
	}
	
	private int getRandomAttack(int attack) {
		int randomChange = (int) (attack * ParamConfig.AttackRange);
		return DotaMath.RandomInRange(attack - randomChange, attack + randomChange);
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker,
			CombatTeam defenserTeam, CombatTeam attackerTeam) {
		List<Combater> candidate = new ArrayList<>(); // 候选目标

		for (Combater e: defenserTeam) {
			if (e.isLive() && canAttack(attacker, e, attacker.getAttackDistance())) {
				candidate.add(e);
			}
		}
		
		if (candidate.size() == 0) {
			return;
		}
		
		int random = DotaMath.RandomInRange(0, candidate.size() - 1);
		targets.add(candidate.get(random));
	}
}
