package dota.buff.detail.butcher;

import dota.ai.SelectTarget;
import dota.buff.Buff;
import dota.config.ParamConfig;
import dota.config.generated.BuffCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.hero.Hero;
import dota.print.PrintHelper;
import dota.util.OP;

@OP(CODE = Enums.BuffType.DISMEMBER_BUFF_VALUE, TYPE = OP.BUFF)
public class Dismember extends Buff {
	
	private int timeUnit = 0;
	private Combater target = null;

	public Dismember(BuffCfg config) {
		super(config);
	}

	@Override
	protected void start() {
		selectTarget();
		if (target == null) {
			return;
		}
		owner.getCombatState().setEmitting(true);
		target.getCombatState().increaseBeEmittingCounts();
	}

	@Override
	public void stop() {
		owner.getCombatState().setEmitting(false);
		target.getCombatState().decreaseBeEmittingCounts();
	}
	
	@Override
	public void onOwnerDeath() {
		time = 0;
	}
	
	@Override
	public void onOwnerBeStun() {
		time = 0;
	}
	
	private void selectTarget() {
		target = SelectTarget.getOneOppentByRandom(owner, config.getEffectScope());
	}
	
	@Override
	protected void update0() {
		timeUnit += ParamConfig.BattleInterval;
		if (timeUnit >= 1000) {
			timeUnit -= 1000;
			int damage = target.beAttack(config.getEffectValue() + ((Hero)owner).getStrength(), Enums.AttackType.MAGICAL_VALUE);
			PrintHelper.BuffPrintWithTime(owner, target, config.getName(), damage);
		}
	}
	

}
