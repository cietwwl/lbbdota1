package dota.skill.detail.earthshaker;

import java.util.List;

import dota.config.generated.SkillCfg;
import dota.hero.Combater;
import dota.skill.Skill;
import dota.team.CombatTeam;

// 老牛的强化图腾

public class EnchantTotem extends Skill {
	
	public EnchantTotem(SkillCfg config) {
		super(config);
	}

	@Override
	protected void emit0(Combater attacker, Combater target) {
		String[] buffs = config.getBuffs().split(",");
		for (int i = 0; i< buffs.length; i++) {
			target.addBuff(Integer.parseInt(buffs[i]));
			System.out.println(attacker.getName() + " 释放 " + getConfig().getName() + ", 攻击力: " + attacker.getRealAttack());
		}
	}

	@Override
	protected void selectTargets0( List<Combater> targets, Combater attacker,
			CombatTeam defenserTeam) {
		targets.add(attacker);
	}

}
