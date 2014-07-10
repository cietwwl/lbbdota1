package dota.buff.detail;

import java.util.ArrayList;
import java.util.List;

import dota.buff.Buff;
import dota.config.generated.BuffCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.team.CombatTeam;
import dota.util.HeroHelper;
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
	public void onEmitAnyActiveSkill(Combater emiter, CombatTeam defenser) {
		List<Combater> targets = selectTargets(emiter, defenser);
		for (Combater e: targets) {
			int damage = e.beAttack(config.getEffectValue(), Enums.AttackType.MAGICAL_VALUE, emiter);
			e.beStun(config.getEffectValue0());
			System.out.println("触发余震，对 " + e.getName() + " 造成 " + damage + " 的伤害和 " + config.getEffectValue0() + " 的眩晕");
		}
	}
	
	private List<Combater> selectTargets(Combater emiter, CombatTeam defenser) {
		List<Combater> targets = new ArrayList<>();
		for (Combater e: defenser) {
			if (e.isLive() && HeroHelper.getDistanceBetweenCombaters(emiter, e) <= config.getEffectScope()) {
				targets.add(e);
			}
		}
		return targets;
	}

}
