package dota.buff.detail;

import dota.buff.Buff;
import dota.config.generated.BuffCfg;
import dota.enums.Enums;
import dota.util.OP;

@OP(CODE = Enums.BuffType.PRESENSE_DARK_LORD_BUFF_VALUE, TYPE = OP.BUFF)
public class PresenseDarkLordBuff extends Buff {

	public PresenseDarkLordBuff(BuffCfg config) {
		super(config);
	}

	@Override
	protected void start() {
		owner.removeArmor(config.getEffectValue());
	}

	@Override
	public void stop() {	
		owner.addArmor(config.getEffectValue());
	}

}
