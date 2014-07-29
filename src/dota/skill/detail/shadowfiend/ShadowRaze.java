package dota.skill.detail.shadowfiend;

import java.util.List;

import dota.config.generated.GameConfig;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.skill.Skill;
import dota.util.OP;

@OP(CODE = Enums.SkillType.SHADOW_RAZE_VALUE, TYPE = OP.SKILL)
public class ShadowRaze extends Skill {

	public ShadowRaze(SkillCfg config) {
		super(config);
	}

	@Override
	protected int emit0(Combater attacker, Combater target) {
		String[] skills = config.getSkills().split(",");
		for (int i = 0; i < skills.length; i++) {
			attacker.learnSkill(GameConfig.getInstance().getSkillCfg(Integer.parseInt(skills[i])));
		}
		return 0;
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker) {	
		targets.add(attacker);
	}

}
