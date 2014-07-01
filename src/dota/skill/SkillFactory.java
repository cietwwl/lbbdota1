package dota.skill;

import dota.config.SkillConfig;
import dota.hero.Combater;
import dota.skill.detail.CommonAttackSkill;
import dota.skill.detail.earthshaker.Aftershock;
import dota.skill.detail.earthshaker.EnchantTotem;
import dota.skill.detail.earthshaker.Fissure;

public class SkillFactory {
	private static SkillFactory instance = null;
	
	public static SkillFactory Instance() {
		if(instance == null) {
			instance = new SkillFactory();
		}
		return instance;
	}
	
	public static Skill creatSkill(SkillConfig config, Combater owner) {
		Skill skill = null;
		switch(config.skillType) {
		case 0: 
			skill = new CommonAttackSkill(config);
			break;
		case 1:
			skill = new Fissure(config);
			break;
		case 2:
			skill = new EnchantTotem(config);
			break;
		case 3:
			skill = new Aftershock(config);
			break;
		}
		skill.initOwner(owner);
		return skill;
	}
}
