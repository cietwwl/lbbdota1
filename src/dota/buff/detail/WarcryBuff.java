package dota.buff.detail;

import dota.buff.Buff;
import dota.config.generated.BuffCfg;

public class WarcryBuff extends Buff{

	public WarcryBuff(BuffCfg config) {
		super(config);
	}

	@Override
	protected void start() {
		owner.getArmor().add(config.getEmitValue());
	}

	@Override
	public void stop() {
		owner.getArmor().remove(config.getEmitValue());
	}

}
