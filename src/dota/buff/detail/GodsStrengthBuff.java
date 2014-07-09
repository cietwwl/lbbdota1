package dota.buff.detail;

import dota.buff.Buff;
import dota.config.generated.BuffCfg;
import dota.enums.Enums;
import dota.util.OP;
@OP(CODE = Enums.BuffType.GODS_STRENGTH_BUFF_VALUE, TYPE = OP.BUFF)
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
