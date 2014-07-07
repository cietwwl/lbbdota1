package dota.buff.detail;

import java.util.ArrayList;
import java.util.List;

import dota.buff.Buff;
import dota.config.generated.BuffCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.team.CombatTeam;
import dota.util.HeroHelper;

// 流浪的巨力挥舞
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
	public void onCommonAttack(Combater attacker, CombatTeam defenser, int damage) {
		int cleaveDamage = (int) (damage * config.getEmitValue() / 100f);
		List<Combater> targets = selectTargets(attacker, defenser);
		for (Combater e: targets) {
			e.beAttack(cleaveDamage, Enums.AttackType.PHYSICAL_VALUE);
			System.out.println( attacker.getName() + " 的 " + config.getName() + 
					" 对 " + e.getName() + " 造成 " + cleaveDamage + "的溅射伤害");
		}
	}
	
	private List<Combater> selectTargets(Combater emiter, CombatTeam defenser) {
		List<Combater> targets = new ArrayList<>();
		for (Combater e: defenser) {
			if (e.isLive() && HeroHelper.isInRange(emiter, e, config.getEffectScope())) {
				targets.add(e);
			}
		}
		return targets;
	}

}
