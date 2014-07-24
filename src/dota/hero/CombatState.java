package dota.hero;

import dota.config.ParamConfig;

public class CombatState {
	
	private int stun = 0;
	private boolean emitting = false;
	private int beEmitting_counts = 0;
	
	public void update() {
		decreaseStun();
	}
	
	public void beStun(int count) {
		stun = Math.max(count, stun);
	}
	
	public void clearStun() {
		stun = 0;
	}
	
	public int getStun() {
		return stun;
	}
	
	private void decreaseStun() {
		if (stun == 0) {
			return;
		}
		stun -= ParamConfig.BattleInterval;
	}
	
	public void setEmitting(boolean flag) {
		emitting = flag;
	}
	
	public boolean getEmitting() {
		return emitting;
	}
	
	public void increaseBeEmittingCounts() {
		beEmitting_counts ++;
	}
	
	public void decreaseBeEmittingCounts() {
		if (beEmitting_counts == 0) {
			return;
		}
		beEmitting_counts--;
	}
	
	public int getBeEmittingCounts() {
		return beEmitting_counts;
	}

}