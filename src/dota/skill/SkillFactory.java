package dota.skill;

import dota.config.generated.GameConfig;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.skill.detail.CommonAttackSkill;
import dota.skill.detail.earthshaker.Aftershock;
import dota.skill.detail.earthshaker.EchoSlam;
import dota.skill.detail.earthshaker.EnchantTotem;
import dota.skill.detail.earthshaker.Fissure;
import dota.skill.detail.rogueknight.GodsStrength;
import dota.skill.detail.rogueknight.GreatCleave;
import dota.skill.detail.rogueknight.StormBolt;
import dota.skill.detail.rogueknight.Warcry;

// TODO 使用动态字节码生成该函数
public class SkillFactory {
	
	public static Skill createSkill(SkillCfg config) {
		switch(config.getSkillType()) {
		case Enums.SkillType.COMMON_VALUE: 
			return new CommonAttackSkill(config);
		case Enums.SkillType.FISSURE_VALUE:
			return new Fissure(config);
		case Enums.SkillType.ENCHANTTOTEM_VALUE:
			return new EnchantTotem(config);
		case Enums.SkillType.AFTERSHOCK_VALUE:
			return new Aftershock(config);
		case Enums.SkillType.ECHOSLAM_VALUE:
			return new EchoSlam(config);
		case Enums.SkillType.STORMBOLT_VALUE:
			return new StormBolt(config);
		case Enums.SkillType.GREATCLEAVE_VALUE:
			return new GreatCleave(config);
		case Enums.SkillType.WARCRY_VALUE:
			return new Warcry(config);
		case Enums.SkillType.GODSSTRENGTH_VALUE:
			return new GodsStrength(config);
		}
		//TODO
		return null;
	}
	
	public static Skill createSkill(int id) {
		SkillCfg config = GameConfig.getInstance().getSkillCfg(id);
		return createSkill(config);
	}
}
