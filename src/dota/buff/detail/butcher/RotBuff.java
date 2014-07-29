package dota.buff.detail.butcher;

import dota.buff.Buff;
import dota.config.ParamConfig;
import dota.config.generated.BuffCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.print.PrintHelper;
import dota.util.CombaterHelper;
import dota.util.OP;

@OP(CODE = Enums.BuffType.ROT_BUFF_VALUE, TYPE = OP.BUFF)
public class RotBuff extends Buff {
	
	private int timeUnit = 0;
	private boolean openFlag = false;
	private int timeSum = 0;
	
	public RotBuff(BuffCfg config) {
		super(config);
	}

	@Override
	protected void start() {	
	}

	@Override
	public void stop() {
	}
	
	@Override
	protected void update0() {
		if (!openFlag) {
			return;
		}
		timeUnit += ParamConfig.BattleInterval;
		timeSum += ParamConfig.BattleInterval;
		if (timeUnit >= 1000) {
			for (Combater e: owner.getTeam().getOppentTeam()) {
				if (e.isLive() && CombaterHelper.isInRange(owner, e, config.getEffectScope())) {
					int damage = e.beAttack(config.getEffectValue(), Enums.AttackType.MAGICAL_VALUE);
					// TODO 减速
					PrintHelper.BuffPrintWithTime(owner, e, config.getName(), damage);
				}
			}
			int damage0 = owner.beAttack(config.getEffectValue(),  Enums.AttackType.MAGICAL_VALUE);
			PrintHelper.BuffPrintWithTime(owner, owner, config.getName(), damage0);
			timeUnit -= 1000;
		}
	}
	
	public void setOpenFlag(boolean flag) {
		this.openFlag = flag;
		if (!flag && timeUnit == 0) {
			timeUnit = 0;
			timeSum = 0;
		}
	}
	
	public int getTimeSum() {
		return this.timeSum;
	}

}
