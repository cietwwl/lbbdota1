package dota.buff.detail;

import dota.buff.Buff;
import dota.config.ParamConfig;
import dota.config.generated.BuffCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.util.HeroHelper;
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
			for (Combater e: defenseTeam) {
				if (e.isLive() && HeroHelper.isInRange(owner, e, config.getEffectScope())) {
					int damage = e.beAttack(config.getEffectValue(), Enums.AttackType.MAGICAL_VALUE, owner);
					// TODO 减速
					System.out.println(owner.getName() + " 的 " + config.getName() + 
							" 对 " + e.getName() + " 造成了  " + damage + " 的伤害 ");
				}
			}
			owner.beAttack(config.getEffectValue(),  Enums.AttackType.MAGICAL_VALUE, owner);
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
