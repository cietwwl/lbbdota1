package dota.battle;

import dota.config.ParamConfig;
import dota.hero.Combater;
import dota.map.CombatMap;
import dota.team.CombatTeam;

public class Battle {
	
	private CombatTeam attackTeam;
	private CombatTeam defenseTeam;
	// private CombatMap combatMap;
	
	public Battle() {
	}
	
	public void init(CombatTeam attackTeam, CombatTeam defenseTeam, CombatMap combatMap) {
		this.attackTeam = attackTeam;
		this.defenseTeam = defenseTeam;
		//this.combatMap = combatMap;
	}
	
	public void start() {		
		init();
		run();
	}
	
	private void init() {
		attackTeam.battleInit(defenseTeam);
		defenseTeam.battleInit(attackTeam);
	}
	
	private void run() {
		while(true) {
			if(processOneRound()) {
				stop();
				return;
			}
			else {
				try {
					Thread.sleep(ParamConfig.BattleInterval);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
		}
	}
	
	private void stop() {
		
	}
	
	private boolean processOneRound() {
		
		for (Combater e: attackTeam) {
			if (doAttack(e, defenseTeam, attackTeam)) {
				System.out.println("VICTORY");
				return true;
			}
		}
		
		for (Combater e: defenseTeam) {
			if (doAttack(e, attackTeam, defenseTeam)) {
				System.out.println("LOSE");
				return true;
			}
		}
		
		update();
		return false;
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
		attackTeam.update();
		defenseTeam.update();
	}
	
}
