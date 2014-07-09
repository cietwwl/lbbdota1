package dota.ai;

import java.util.ArrayList;
import java.util.List;

import dota.hero.Combater;
import dota.team.CombatTeam;
import dota.util.DotaMath;
import dota.util.HeroHelper;

public class SelectTarget {
	
	/**
	 * 随机一个合法的命中目标(敌方)
	 * @return
	 */
	public static Combater getOneOppentByRandom(Combater attacker, CombatTeam defenserTeam, float distance) {
		List<Combater> candidate = new ArrayList<>();
		for (Combater e : defenserTeam) {
			if (e.isLive() && HeroHelper.isInRange(attacker, e, distance)) {
				candidate.add(e);
			}
		}
		
		if (candidate.size() == 0) {
			return null;
		}
		
		// 随机一个施法目标
		int random = DotaMath.RandomInRange(0, candidate.size() - 1);
		return candidate.get(random);
	}
	
	/**
	 * 获取指定范围内的目标, 包括目标
	 * @return
	 */
	public static List<Combater> getAllTargetsOfScope(Combater target, float distance, CombatTeam targetTeam) {
		return getAllTargetsOfScope(target.positionX, target.positionY, distance, targetTeam);
	}
	
	/**
	 * 获取指定范围内的目标, 包括目标
	 * @return
	 */
	public static List<Combater> getAllTargetsOfScope(int x, int y, float distance, CombatTeam targetTeam) {
		List<Combater> result = new ArrayList<>();
		for (Combater e: targetTeam) {
			if (e.isLive() && HeroHelper.isInRange(x, y, e, distance)) {
				result.add(e);
			}
		}
		return result;
	}
}
