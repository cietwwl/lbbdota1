package dota.buff.detail.rogueknight;

import java.util.ArrayList;
import java.util.List;

import dota.buff.Buff;
import dota.config.generated.BuffCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.print.PrintHelper;
import dota.util.CombaterHelper;
import dota.util.OP;

// 流浪的巨力挥舞
@OP(CODE = Enums.BuffType.GREAT_CLEAVE_BUFF_VALUE, TYPE = OP.BUFF)
public class GreatCleaveBuff extends Buff {

	public GreatCleaveBuff(BuffCfg config) {
		super(config);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void start() {	
	}

	@Override
	public void stop() {
	}
	
	@Override
	public void onCommonAttack(int damage) {
		int cleaveDamage = (int) (damage * config.getEffectValue() / 100f);
		List<Combater> targets = selectTargets(owner);
		for (Combater e: targets) {
			e.beAttack(cleaveDamage, Enums.AttackType.PHYSICAL_VALUE);
			PrintHelper.BuffPrint(owner, e, config.getName(), cleaveDamage);
		}
	}
	
	private List<Combater> selectTargets(Combater emiter) {
		List<Combater> targets = new ArrayList<>();
		for (Combater e: emiter.getTeam().getOppentTeam()) {
			if (e.isLive() && CombaterHelper.isInRange(emiter, e, config.getEffectScope())) {
				targets.add(e);
			}
		}
		return targets;
	}

}
