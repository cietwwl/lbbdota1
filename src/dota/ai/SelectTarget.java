package dota.ai;

import java.util.ArrayList;
import java.util.List;

import dota.hero.Combater;
import dota.team.CombatTeam;
import dota.util.DotaMath;
import dota.util.CombaterHelper;
import dota.util.Point;

public class SelectTarget {
	
	/**
	 * 随机一个合法的命中目标(敌方)
	 * @return
	 */
	public static Combater getOneOppentByRandom(Combater attacker, float distance) {
		List<Combater> candidate = new ArrayList<>();
		for (Combater e : attacker.getTeam().getOppentTeam()) {
			if (e.isLive() && CombaterHelper.isInRange(attacker, e, distance)) {
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
			if (e.isLive() && CombaterHelper.isInRange(x, y, e, distance)) {
				result.add(e);
			}
		}
		return result;
	}
	
	public static List<Combater> getAllTargetOfPolygon(List<Point> polygon, CombatTeam targetTeam) {
		List<Combater> result = new ArrayList<>();
		for (Combater e: targetTeam) {
			if (e.isLive() && CombaterHelper.isCombaterInPolygon(e, polygon)) {
				result.add(e);
			}
		}
		return result;
	}
}
