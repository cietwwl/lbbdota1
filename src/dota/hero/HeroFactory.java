package dota.hero;

import dota.config.generated.GameConfig;
import dota.config.generated.HeroCfg;

public class HeroFactory {
	public static Hero create(int id) {
		Hero hero = new Hero();
		HeroCfg config = GameConfig.getInstance().getHeroCfg(id);
		hero.init(config);
		return hero;
	}
}
