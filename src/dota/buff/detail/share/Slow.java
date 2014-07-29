package dota.buff.detail.share;

import dota.buff.Buff;
import dota.config.generated.BuffCfg;
import dota.enums.Enums;
import dota.util.OP;

@OP(CODE = Enums.BuffType.SLOW_BUFF_VALUE, TYPE = OP.BUFF)
public class Slow extends Buff {

	public Slow(BuffCfg config) {
		super(config);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub	
	}

}
