package dota.buff.detail.rogueknight;

import dota.buff.Buff;
import dota.config.generated.BuffCfg;
import dota.enums.Enums;
import dota.util.OP;
// 战吼
@OP(CODE = Enums.BuffType.WAR_CRY_BUFF_VALUE, TYPE = OP.BUFF)
public class WarcryBuff extends Buff{

	public WarcryBuff(BuffCfg config) {
		super(config);
	}

	@Override
	protected void start() {
		owner.addArmor(config.getEffectValue());
	}

	@Override
	public void stop() {
		owner.removeArmor(config.getEffectValue());
	}

}
