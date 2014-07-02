package dota.buff;

import dota.buff.detail.AftershockBuff;
import dota.config.BuffConfig;
import dota.hero.Combater;

public class BuffFactory {
	private static BuffFactory instance = null;
	
	public static BuffFactory Instance() {
		if(instance == null) {
			instance = new BuffFactory();
		}
		return instance;
	}
	
	public static Buff creatBuff(BuffConfig config, Combater owner) {
		Buff Buff = null;
		switch(config.buffType) {
//		case 0: 
//			Buff = new EnchantTotemBuff(config);
//			break;
		case 1:
			Buff = new AftershockBuff(config);
			break;
		}
		Buff.initOwner(owner);
		return Buff;
	}
}
