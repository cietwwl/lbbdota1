package dota.hero;

import dota.util.DotaMath;

public class PropertyLikeAttack {
	public float base_min = 0;
	public float base_max = 0;
	public float extra = 0;
	
	public int getReal() {
		return (int) (DotaMath.RandomInRange((int)base_min, (int)base_max) + extra);
	}
	
	public void addBase(float add) {
		base_min += add;
		base_max += add;
	}
}