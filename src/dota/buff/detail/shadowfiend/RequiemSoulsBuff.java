package dota.buff.detail.shadowfiend;

import dota.buff.Buff;
import dota.config.generated.BuffCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.print.PrintHelper;
import dota.util.CombaterHelper;
import dota.util.OP;

@OP(CODE = Enums.BuffType.REQUIEM_OF_SOULS_BUFF_VALUE, TYPE = OP.BUFF)
public class RequiemSoulsBuff extends Buff {

	public RequiemSoulsBuff(BuffCfg config) {
		super(config);
	}

	@Override
	protected void start() {
		
	}

	@Override
	public void stop() {
		
	}
	
	@Override
	public void onOwnerDeath() {
		Buff soulBuff = owner.getBuffManager().getBuff(6);
		int souls = ((NecroMasteryBuff)soulBuff).getSouls();
		
		for (Combater e: owner.getTeam().getOppentTeam()) {
			if (e.isLive() && CombaterHelper.getDistanceBetweenCombaters(owner, e) <= config.getEffectScope()) {
				float x = CombaterHelper.getDistanceBetweenCombaters(owner, e);
				float y = (1 - souls/2) * x / config.getEffectScope() + souls/2;
				int damage = e.beAttack((int)y, Enums.AttackType.MAGICAL_VALUE);
				PrintHelper.BuffPrint(owner, e, config.getName(), damage);
			}
		}	
	}
}
