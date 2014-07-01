package dota.config;

import dota.util.DotaMath;

public class SkillConfigFactory extends AbstractConfigFactory<SkillConfig>{
	private static SkillConfigFactory instance = null;
	
	public static SkillConfigFactory getInstance() {
		if(instance == null) {
			instance = new SkillConfigFactory();
			instance.init();
		}
		return instance;
	}

	@Override
	public void init() {
		array = new SkillConfig[4];
		
		int i = 0;
		
		SkillConfig e = new SkillConfig();
		e.name = "普通攻击";
		e.skillType = 0;
		e.arg1 = 0;
		e.CD = 0;
		array[i++] = e;
		
		SkillConfig e1 = new SkillConfig();
		e1.name = "沟壑";
		e1.skillType = 1;
		e1.arg0 = 2;
		e1.arg1 = 100;
		e1.CD = 5;
		array[i++] = e1;
		
		SkillConfig e2 = new SkillConfig();
		e2.name = "强化图腾";
		e2.skillType = 2;
		e2.CD = 4;
		e2.buff0 = BuffConfigFactory.getInstance().getConfig(0);
		array[i++] = e2;
		
		SkillConfig e3 = new SkillConfig();
		e3.name = "余震";
		e3.skillType = 3;
		e3.CD = 0;
		e3.buff0 = BuffConfigFactory.getInstance().getConfig(1);
		e3.emitType = 1;
		array[i++] = e3;
	}
	
}
