package dota.buff;

import dota.config.generated.BuffCfg;
import dota.util.Factory;
import dota.util.FactoryHelper;

public class BuffFactory {
	
	public static Buff creatBuff(BuffCfg config) {
		Factory factory = (Factory) FactoryHelper.objectMap.get("dota.util.FactoryBuff");
		if (factory == null) {
			FactoryHelper.load(Factory.class, "Buff");
			factory = (Factory) FactoryHelper.objectMap.get("dota.util.FactoryBuff");
		}
		return factory.create(config);
	}
}
