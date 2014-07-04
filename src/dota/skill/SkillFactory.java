package dota.skill;

import dota.config.generated.GameConfig;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.skill.detail.CommonAttackSkill;
import dota.skill.detail.earthshaker.Fissure;

public class SkillFactory {
	
	public static Skill createSkill(SkillCfg config) {
		switch(config.getSkillType()) {
		case Enums.SkillType.COMMON_VALUE: 
			return new CommonAttackSkill(config);
		case Enums.SkillType.FISSURE_VALUE:
			return new Fissure(config);
		}
		//TODO
		return null;
	}
	
	public static Skill createSkill(int id) {
		SkillCfg config = GameConfig.getInstance().getSkillCfg(id);
		return createSkill(config);
	}
}
