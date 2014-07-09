package dota.skill.detail.earthshaker;

import java.util.List;

import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.skill.Skill;
import dota.team.CombatTeam;
import dota.util.OPHandler;

// 老牛的强化图腾
@OPHandler(CODE = Enums.SkillType.ENCHANTTOTEM_VALUE)
public class EnchantTotem extends Skill {
	
	public EnchantTotem(SkillCfg config) {
		super(config);
	}

	@Override
	protected int emit0(Combater attacker, Combater target) {
		emitBuff(target);
		return 0;
	}

	@Override
	protected void selectTargets0( List<Combater> targets, Combater attacker,
			CombatTeam defenserTeam, CombatTeam attackerTeam) {
		targets.add(attacker);
	}

}
