package dota.config;

import dota.util.DotaMath;

public class HeroConfigFactory extends AbstractConfigFactory<HeroConfig>{
	
	private static HeroConfigFactory instance = null;
	
	@Override
	public void init() {
		array = new HeroConfig[2];
		for(int i = 0; i < 2; i++) {
			HeroConfig e = new HeroConfig();
			e.heroType = DotaMath.RandomInRange(1, 3);
			e.initHp = DotaMath.RandomInRange(500, 1000);
			e.initAttack = DotaMath.RandomInRange(50, 100);
			e.heroStruct.strength = DotaMath.RandomInRange(10, 20);
			e.heroStruct.agility = DotaMath.RandomInRange(10, 30);
			e.heroStruct.intelligence = DotaMath.RandomInRange(10, 40);
			e.crit = DotaMath.RandomInRange(0, 50);
			e.name = "monster";
			e.commonAttackSkill = SkillConfigFactory.getInstance().getConfig(0);
			array[i] = e;
		}
		array[1].initHp = DotaMath.RandomInRange(1000, 2000);
	}

	public static HeroConfigFactory getInstance() {
		if(instance == null) {
			instance = new HeroConfigFactory();
			instance.init();
		}
		return instance;
	}
	
	
}
