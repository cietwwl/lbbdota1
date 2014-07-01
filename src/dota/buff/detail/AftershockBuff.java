package dota.buff.detail;

import dota.buff.Buff;
import dota.config.BuffConfig;
import dota.enums.Enums;
import dota.hero.Combater;

// 余震
public class AftershockBuff extends Buff{
	
	// type, 1
	// arg0, 伤害
	// arg1, 眩晕时间
	public AftershockBuff(BuffConfig config) {
		super(config);
	}

	@Override
	public void start() {
	}

	@Override
	public void stop() {
	}
	
	@Override
	public void onEmitAnySkill(Combater defenser) {
		int damage = defenser.beAttack(config.arg0, Enums.AttackType.PHYSICAL_VALUE);
		defenser.beStun(config.arg1);
		System.out.println("触发余震，造成 " + damage + " 的伤害和 " + config.arg1 + " 的眩晕");
	}

}
