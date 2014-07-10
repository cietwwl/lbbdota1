package dota.buff.detail;

import dota.buff.Buff;
import dota.config.generated.BuffCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.hero.Hero;
import dota.util.OP;

@OP(CODE = Enums.BuffType.NECRO_MASTERY_BUFF_VALUE, TYPE = OP.BUFF)
public class NecroMastery extends Buff {
	
	public int addAttack = 0;
	
	public NecroMastery(BuffCfg config) {
		super(config);
	}

	@Override
	protected void start() {
		
	}

	@Override
	public void stop() {
		owner.removeAttack(addAttack);
	}
	
	@Override
	public void onKillAnyCombater(Combater soul) {
		
		if (addAttack >= config.getEffectValue1()) {
			return;
		}
		
		if (soul instanceof Hero) {
			addAttack += config.getEffectValue0();
			owner.addAttack(config.getEffectValue0());
			System.out.println(owner.getName() + " 增加攻击力  " + config.getEffectValue0());
		} else {
			addAttack += config.getEffectValue();
			owner.addAttack(config.getEffectValue());
			System.out.println(owner.getName() + " 增加攻击力 " + config.getEffectValue());
		}
	}
	
	public int getSouls() {
		return this.addAttack;
	}
	
}
