package dota.skill.detail;

import java.util.List;

import dota.ai.SelectTarget;
import dota.config.ParamConfig;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.print.PrintHelper;
import dota.skill.Skill;
import dota.util.DotaMath;
import dota.util.OP;

@OP(CODE = Enums.SkillType.COMMON_VALUE, TYPE = OP.SKILL)
public class CommonAttackSkill extends Skill {

	public CommonAttackSkill(SkillCfg config) {
		super(config);
	}

	@Override
	public int emit0(Combater attacker, Combater target) {
		if (!target.isLive()) {
			return 0 ;
		}
		int damage = getAttackDamage(attacker);
		int realDamage = target.beAttack(damage, Enums.AttackType.PHYSICAL_VALUE);
		PrintHelper.SkillPrint(attacker, target, config.getName(), realDamage);
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
	protected void selectTargets0(List<Combater> targets, Combater attacker) {
		targets.add(SelectTarget.getOneOppentByRandom(attacker, attacker.getAttackDistance()));
	}
}
