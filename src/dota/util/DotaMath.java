package dota.util;

import java.util.concurrent.ThreadLocalRandom;

public class DotaMath {
	public static int RandomInRange(int start, int end) {	
		return ThreadLocalRandom.current().nextInt(end) + start;
	}
	
	public static boolean doesRandomSuccess(float random) {
		float sysRandom = ThreadLocalRandom.current().nextFloat(); // 返回0到1之间的数值
		if (sysRandom < random) {
			return true;
		}
		return false;
	}
}
