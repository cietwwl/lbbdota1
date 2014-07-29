package dota.battle;

import dota.config.ParamConfig;
import dota.hero.Combater;
import dota.map.CombatMap;
import dota.team.CombatTeam;

public class Combat {
	
	private CombatTeam sentinelHeros;
	private CombatTeam scourgeHeros;
	// private CombatMap combatMap;
	public static long time = 0;
	
	public Combat() {
	}
	
	public void init(CombatTeam sentinelHeros, CombatTeam scourgeHeros, CombatMap combatMap) {
		this.sentinelHeros = sentinelHeros;
		this.scourgeHeros = scourgeHeros;
		sentinelHeros.init(this);
		scourgeHeros.init(this);
	}
	
	public CombatTeam getSentinelHeros() {
		return sentinelHeros;
	}
	
	public CombatTeam getSourgeHeros() {
		return scourgeHeros;
	}

	public void start() {		
		// for test
		for (Combater e: sentinelHeros) {
			e.learnSkills();
		}
		for (Combater e: scourgeHeros) {
			e.learnSkills();
		}
		
		countDown();
		run();
	}
	
	private void countDown() {
		int ncount = 3;
		while (true) {
			System.out.println(ncount);
			ncount --;
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			if (ncount == 0) {
				return;
			}
		}
	}
	
	private void run() {
		while(true) {
			if(heartBeat()) {
				stop();
				return;
			}
			else {
				try {
					Thread.sleep(ParamConfig.BattleInterval);
					time += ParamConfig.BattleInterval;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
		}
	}
	
	private boolean heartBeat() {
		
		for (Combater e: sentinelHeros) {
			if (doAttack(e, scourgeHeros, sentinelHeros)) {
				System.out.println("VICTORY");
				printResult();
				return true;
			}
		}
		
		for (Combater e: scourgeHeros) {
			if (doAttack(e, sentinelHeros, scourgeHeros)) {
				System.out.println("LOSE");
				printResult();
				return true;
			}
		}
		
		update();
		return false;
	}
	
	private void stop() {
		
	}
	
	
	private boolean doAttack(Combater attacker, CombatTeam defensers, CombatTeam attackerTeam) {
		if (attacker.canAct()) {
			attacker.attack(defensers, attackerTeam);
		}
		
		if (!defensers.isLive()) {
			return true;
		}
		
		return false;
	}
	
	private void update() {
		sentinelHeros.update();
		scourgeHeros.update();
	}
	
	private void printResult() {
		for (Combater e: sentinelHeros) {
			if (e.isLive()) {
				System.out.println(e.getName() + " : " + e.getCurrentHp());
			}
		}
		
		for (Combater e: scourgeHeros) {
			if (e.isLive()) {
				System.out.println(e.getName() + " : " + e.getCurrentHp());
			}
		}
		
	}
	
}
