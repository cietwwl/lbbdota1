package dota.skill.detail;

import dota.config.SkillConfig;
import dota.hero.Combater;
import dota.skill.Skill;

public class CommonAttackSkill extends Skill{

	public CommonAttackSkill(SkillConfig config) {
		super(config);
	}

	@Override
	public void emit0(Combater defenser) {
		int damage = defenser.beAttack(getOwner().getRealAttack());
		System.out.println(getOwner().getName() + " 对 " + defenser.getName() + "释放 " + this.getName() + ", 造成" + damage + "的伤害");
	}
	
}
