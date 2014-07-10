package dota.buff;

import dota.config.ParamConfig;
import dota.config.generated.BuffCfg;
import dota.hero.Combater;
import dota.team.CombatTeam;

public abstract class Buff {
	protected int time;
	protected BuffCfg config;
	protected Combater owner;
	protected CombatTeam attackTeam;
	protected CombatTeam defenseTeam;
	
	public Buff(BuffCfg config) {
		this.config = config;
	}
	
	public int getTime() {
		return time;
	}
	
	public void init() {
		time = config.getEffectTime();
	}
	
	public void start(Combater owner, CombatTeam attackTeam, CombatTeam defenseTeam) {
		this.owner = owner;
		this.attackTeam = attackTeam;
		this.defenseTeam = defenseTeam;
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
		update0();
	}
	
	public boolean isOver() {
		if(time == 0) {
			return true;
		}
		return false;
	}
	
	// 普通攻击
	public void onCommonAttack(Combater attacker, CombatTeam defenser, int damage) {
		
	}
	
	// 释放任意主动技能
	public void onEmitAnyActiveSkill(Combater emiter, CombatTeam defenser) {
		
	}
	
	// 杀死任意单位
	public void onKillAnyCombater(Combater soul) {
		
	}
	
	// 
	protected void update0() {
		
	}
	
	// 直接清除该BUFF
	public void clearBuff() {
		time = 0;
	}
	
	public BuffCfg getConfig() {
		return this.config;
	}
	
}
