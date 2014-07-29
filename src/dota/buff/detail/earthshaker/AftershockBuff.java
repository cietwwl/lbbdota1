package dota.buff.detail.earthshaker;

import java.util.ArrayList;
import java.util.List;

import dota.buff.Buff;
import dota.config.generated.BuffCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.print.PrintHelper;
import dota.util.CombaterHelper;
import dota.util.OP;

// 余震
// value: 伤害
// value0:晕的时间
@OP(CODE = Enums.BuffType.AFTER_SHOCK_BUFF_VALUE, TYPE = OP.BUFF)
public class AftershockBuff extends Buff{
	
	public AftershockBuff(BuffCfg config) {
		super(config);
	}

	@Override
	public void start() {
	}

	@Override
	public void stop() {
	}
	
	@Override
	public void onEmitAnyActiveSkill() {
		List<Combater> targets = selectTargets();
		for (Combater e: targets) {
			int damage = e.beAttack(config.getEffectValue(), Enums.AttackType.MAGICAL_VALUE);
			e.getCombatState().beStun(config.getEffectValue0());
			PrintHelper.BuffPrint(owner, e, config.getName(), damage, config.getEffectValue0());
		}
	}
	
	private List<Combater> selectTargets() {
		List<Combater> targets = new ArrayList<>();
		for (Combater e: owner.getTeam().getOppentTeam()) {
			if (e.isLive() && CombaterHelper.getDistanceBetweenCombaters(owner, e) <= config.getEffectScope()) {
				targets.add(e);
			}
		}
		return targets;
	}

}
