package dota.buff;

import dota.config.ParamConfig;
import dota.config.generated.BuffCfg;
import dota.hero.Combater;
import dota.team.CombatTeam;

public abstract class Buff {
	protected int time;
	protected BuffCfg config;
	protected Combater owner;
	
	public Buff(BuffCfg config) {
		this.config = config;
	}
	
	public int getTime() {
		return time;
	}
	
	public void init() {
		time = config.getEmitTime();
	}
	
	public void start(Combater owner) {
		this.owner = owner;
		start();
	}
	
	protected abstract void start();
	
	public abstract void stop();
	
	private void decreaseTime() {
		if(time == 0) {
			return;
		}
		time -= ParamConfig.BattleInterval;
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
	
	// 释放任意主动技能
	public void onEmitAnyActiveSkill(Combater emiter, CombatTeam defenser) {
		
	}
	
	
	
}
