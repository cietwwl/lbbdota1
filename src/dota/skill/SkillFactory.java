package dota.skill;

import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.skill.detail.CommonAttackSkill;

public class SkillFactory {
	
	public static Skill creatSkill(SkillCfg config) {
		switch(config.getSkillType()) {
		case Enums.SkillType.COMMON_VALUE: 
			return new CommonAttackSkill(config);
		}
		//TODO
		return null;
	}
}
