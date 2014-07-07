package dota.util;

import dota.hero.Combater;
import static java.lang.Math.*;

public class HeroHelper {
	
	// 向上取整
	public static int getDistanceBetweenCombaters(Combater attacker, Combater defenser) {
		int disX = attacker.positionX - defenser.positionX;
		int disY = attacker.positionY - defenser.positionY;
		return (int) ceil(sqrt(disX * disX + disY * disY));
	}
	
	public static boolean isInRange(Combater A, Combater B, float distance) {
		int disX = A.positionX - B.positionX;
		int disY = A.positionY - B.positionY;
		float dis = (int) Math.sqrt(disX * disX + disY * disY);
		if (DotaMath.compareFloats(distance, dis, 0.01f) > 0) {
			return true;
		}
		return false;
	}
}
