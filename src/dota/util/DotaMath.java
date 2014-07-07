package dota.util;

import java.util.concurrent.ThreadLocalRandom;

public class DotaMath {
	public static int RandomInRange(int start, int end) {
		if (start > end) {
			return 0;
		}
		
		if (start == end) {
			return start;
		}
		
		if (end <=0 ) {
			return 0;
		}
		
		return ThreadLocalRandom.current().nextInt(end - start + 1) + start;
	}
	
	public static boolean doesRandomSuccess(float random) {
		float sysRandom = ThreadLocalRandom.current().nextFloat(); // 返回0到1之间的数值
		if (sysRandom < random) {
			return true;
		}
		return false;
	}
	
	public static int compareFloats(float a, float b, float precision) {
		if (a - b > precision) {
			return 1;
		} else if (a - b < -precision) {
			return -1;
		} else {
			return 0;
		}
	}
}
