package dota.skill.detail;

import dota.config.ParamConfig;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.skill.Skill;
import dota.util.DotaMath;

public class CommonAttackSkill extends Skill{

	public CommonAttackSkill(SkillCfg config) {
		super(config);
	}

	@Override
	public void emit0(Combater attacker, Combater defenser) {
		int damage = getAttackDamage(attacker);
		int realDamage = defenser.beAttack(damage, Enums.AttackType.PHYSICAL_VALUE);
		System.out.println(attacker.getName() + " 对 " + defenser.getName() + "释放 " + this.config.getName() + ", 造成" + realDamage + "的伤害");
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
}
