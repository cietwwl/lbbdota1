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

public class CommonAttackSkill extends Skill{

	public CommonAttackSkill(SkillCfg config) {
		super(config);
	}

	@Override
	public void emit0(Combater attacker, Combater defenser) {
		if (!defenser.isLive()) {
			return;
		}
		int damage = getAttackDamage(attacker);
		int realDamage = defenser.beAttack(damage, Enums.AttackType.PHYSICAL_VALUE);
		System.out.println(attacker.getName() + " 对 " + defenser.getName() + "释放 " + this.config.getName() + ", 造成" + realDamage + "的伤害");
		if (defenser.isLive()) {
			System.out.println(defenser.getName() + "剩余生命值: " + defenser.getCurrentHp());
		} else {
			System.out.println(defenser.getName() + " Die");
		}
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
	protected List<Combater> selectTargets(Combater attacker,
			CombatTeam defenserTeam) {
		List<Combater> result = new ArrayList<>();
		List<Combater> candidate = new ArrayList<>(); // 候选目标

		for (Combater e: defenserTeam) {
			if (e.isLive() && canAttack(attacker, e, attacker.getAttackDistance())) {
				candidate.add(e);
			}
		}
		
		if (candidate.size() == 0) {
			return result;
		}
		
		int random = DotaMath.RandomInRange(0, candidate.size() - 1);
		result.add(candidate.get(random));
		
		return result;
	}
}
