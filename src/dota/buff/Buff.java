package dota.buff;

import dota.config.BuffConfig;
import dota.hero.Combater;

public abstract class Buff {
	protected int time;
	protected BuffConfig config;
	protected Combater owner;
	
	public Buff(BuffConfig config) {
		this.config = config;
	}
	
	public void initOwner(Combater owner) {
		this.owner = owner;
	}
	
	public String getName() {
		return config.name;
	}
	
	public int getTime() {
		return time;
	}
	
	public void init() {
		time = config.time;
	}
	
	public abstract void start();
	
	public abstract void stop();
	
	private void decreaseTime() {
		if(time == 0) {
			return;
		}
		time--;
	}
	
	public void update() {
		decreaseTime();
	}
	
	public boolean isOver() {
		if(time == 0) {
			return true;
		}
		return false;
	}
	
	// 普通攻击
	public void onCommonAttack() {
		
	}
	
	// 释放任意技能
	public void onEmitAnySkill(Combater defenser) {
		
	}
	
	
	
}
