package dota.buff.detail;

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
		owner.getArmor().add(config.getEmitValue());
	}

	@Override
	public void stop() {
		owner.getArmor().remove(config.getEmitValue());
	}

}
