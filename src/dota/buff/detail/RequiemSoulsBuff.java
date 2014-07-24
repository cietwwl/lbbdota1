package dota.buff.detail;

import dota.buff.Buff;
import dota.config.generated.BuffCfg;
import dota.enums.Enums;
import dota.hero.Combater;
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
		int souls = ((NecroMastery)soulBuff).getSouls();
		
		for (Combater e: oppentTeam) {
			if (e.isLive() && CombaterHelper.getDistanceBetweenCombaters(owner, e) <= config.getEffectScope()) {
				float x = CombaterHelper.getDistanceBetweenCombaters(owner, e);
				float y = (1 - souls/2) * x / config.getEffectScope() + souls/2;
				int damage = e.beAttack((int)y, Enums.AttackType.MAGICAL_VALUE, owner);
				System.out.println(owner.getName() + " 的 " + config.getName() + 
						" 对 " + e.getName() + " 造成了 " + damage + " 的伤害");
			}
		}	
	}
}
