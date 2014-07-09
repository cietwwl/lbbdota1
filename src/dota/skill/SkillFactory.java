package dota.skill;

import dota.config.generated.GameConfig;
import dota.config.generated.SkillCfg;
import dota.util.Factory;
import dota.util.FactoryHelper;

// TODO 使用动态字节码生成该函数
public class SkillFactory {
	
	public static Skill createSkill(SkillCfg config) {
		return create(config);
	}
	
	public static Skill createSkill(int id) {
		SkillCfg config = GameConfig.getInstance().getSkillCfg(id);
		return createSkill(config);
	}

	public static Skill create(SkillCfg config) {
		Factory factory = (Factory) FactoryHelper.objectMap.get("dota.util.FactorySkill");
		if (factory == null) {
			FactoryHelper.load(Factory.class, "Skill");
			factory = (Factory) FactoryHelper.objectMap.get("dota.util.FactorySkill");
		}
		return factory.create(config);
	}
}


