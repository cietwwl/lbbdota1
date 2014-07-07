package dota.buff.detail;

import dota.buff.Buff;
import dota.config.generated.BuffCfg;

public class GodsStrengthBuff extends Buff {

	int addAttack = 0;
	
	public GodsStrengthBuff(BuffCfg config) {
		super(config);
	}

	@Override
	protected void start() {
		addAttack =  (int) (owner.getMinBaseAttack() * config.getEmitValue()/100);
		owner.addAttack(addAttack);
	}

	@Override
	public void stop() {
		owner.removeAttack(addAttack);
	}

}
