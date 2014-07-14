package dota.buff.detail;

import dota.buff.Buff;
import dota.config.generated.BuffCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.hero.Hero;
import dota.util.HeroHelper;
import dota.util.OP;

@OP(CODE = Enums.BuffType.FLESH_HEAP_VALUE, TYPE = OP.BUFF)
public class FleshHeap extends Buff {

	public FleshHeap(BuffCfg config) {
		super(config);
	}

	@Override
	protected void start() {
		owner.addMagicRes(config.getEffectValue0());
	}

	@Override
	public void stop() {
		owner.removeMagicRes(config.getEffectValue0());
	}
	
	@Override
	public void onAnyOppentDeath(Combater killer, Combater death) {
		if (HeroHelper.isInRange(owner, death, config.getEffectScope()) || killer == owner) {
			((Hero)owner).addStrength(config.getEffectValue()); // 永久性加
			return;
		}
	}

}
