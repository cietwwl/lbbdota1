package dota.buff;

import dota.buff.detail.AftershockBuff;
import dota.buff.detail.EnchantTotemBuff;
import dota.config.generated.BuffCfg;
import dota.enums.Enums;
import dota.hero.Combater;

public class BuffFactory {
	
	public static Buff creatBuff(BuffCfg config, Combater owner) {
		switch (config.getBuffType()) {
		case Enums.BuffType.ENCHANTTOTEMBUFF_VALUE: 
			return new EnchantTotemBuff(config);
		case Enums.BuffType.AFTERSHOCKBUFF_VALUE:
			return new AftershockBuff(config);
		}
		return null;
	}
}
