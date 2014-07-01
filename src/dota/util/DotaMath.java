package dota.util;

public class DotaMath {
	public static int RandomInRange(int start, int end) {
		double random = Math.random();
		return start + (int)((end-start)*random);
	}
}
