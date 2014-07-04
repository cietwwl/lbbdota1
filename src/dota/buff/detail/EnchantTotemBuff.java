package dota.buff.detail;

import dota.buff.Buff;
import dota.config.generated.BuffCfg;

// arg0: 增加的攻击力倍数

public class EnchantTotemBuff extends Buff {

	int addAttack = 0;
	
	public EnchantTotemBuff(BuffCfg config) {
		super(config);
	}

	@Override
	public void start() {
		addAttack =  owner.getBaseAttack() * config.getEmitValue()/100;
		owner.addAttack(addAttack);
	}

	@Override
	public void stop() {
		owner.removeAttack(addAttack);
	}
	
	@Override
	public void onCommonAttack() {
		time = 0;
	}

}
