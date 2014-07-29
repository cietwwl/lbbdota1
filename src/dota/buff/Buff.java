package dota.buff;

import dota.config.ParamConfig;
import dota.config.generated.BuffCfg;
import dota.hero.Combater;

public abstract class Buff {
	
	private static final int BUFF_FOREVER = -9999;
	
	protected int time;			// BUFF持续时间，如果是-9999, 说明是永久性BUFF
	protected BuffCfg config;
	protected Combater owner;
	
	public Buff(BuffCfg config) {
		this.config = config;
	}
	
	public void init() {
		time = config.getEffectTime();
	}
	
	public int getTime() {
		return time;
	}
	
	public BuffCfg getConfig() {
		return this.config;
	}
	
	public Combater getOwner() {
		return owner;
	}
	
	public void start(Combater owner) {
		this.owner = owner;
		start();
	}
	
	protected abstract void start();
	
	public abstract void stop();
	
	public void update() {
		decreaseTime();
		update0();
	}
	
	protected void update0() {
		
	}
	
	private void decreaseTime() {
		if (time <= 0) {
			if (time != ParamConfig.BUFF_OVER_LEFTCOUNT && time != ParamConfig.BUFF_OVER_CLEAR) {
				time = ParamConfig.BUFF_OVER_TIMEOUT;
			}
			return;
		}
		time -= ParamConfig.BattleInterval;
	}
	
	public boolean isTimeOut() {
		if (isOver() && time != ParamConfig.BUFF_OVER_LEFTCOUNT && time != ParamConfig.BUFF_OVER_CLEAR) {
			return true;
		}
		return false;
	}
	
	public boolean isOver() {
		if (time <= 0 && time != BUFF_FOREVER) {
			return true;
		}
		return false;
	}
	
	// 直接清除该BUFF
	public void clear() {
		time = ParamConfig.BUFF_OVER_CLEAR;
	}
	
	// 普通攻击
	public void onCommonAttack(int damage) {
		
	}
	
	// 释放任意主动技能
	public void onEmitAnyActiveSkill() {
		
	}
	
	// 杀死任意单位
	public void onKillAnyCombater(Combater soul) {
		
	}
	
	// BUFF持有者死掉
	public void onOwnerDeath() {
		
	}
	
	// 有敌方单位死掉
	public void onAnyOppentDeath(Combater killer, Combater death) {
		
	}
	
	// 被晕
	public void onOwnerBeStun() {
		
	}
	
}
