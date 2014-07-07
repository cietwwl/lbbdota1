package dota.hero;

public class PropertyLikeArmor {
	public float base;
	public float extra;
	
	public float getReal() {
		return base + extra;
	}
	
	public void add(float add) {
		extra += add;
	}

	public void remove(float rm) {
		extra -= rm;
	}
}
