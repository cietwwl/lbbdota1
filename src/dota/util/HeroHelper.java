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
}
