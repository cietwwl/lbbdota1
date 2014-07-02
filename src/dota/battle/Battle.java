package dota.battle;

import dota.config.ParamConfig;
import dota.hero.Combater;
import dota.skill.Skill;
import dota.team.CombatTeam;

public class Battle {
	
	private CombatTeam attackers;
	private CombatTeam defensers;
	private int counts = 0;	// 回合数
	
	public Battle(CombatTeam attackers, CombatTeam defensers) {
		this.attackers = attackers;
		this.defensers = defensers;
	}
	
	public void start() {		
		init();
		run();
	}
	
	private void init() {
		attackers.battleInit(defensers);
		defensers.battleInit(attackers);
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
		counts++;
		System.out.println("==============第"+counts+"回合==============");
		
		for (int i = 0; i< 5; i++) {
			if (doAttack(attackers.get(i), defensers)) {
				System.out.println("VICTORY");
				return true;
			}
			if (doAttack(defensers.get(i), attackers)){
				System.out.println("LOSE");
				return true;
			}
		}
		
		update();
		// System.out.println("双方剩余生命值，你: " + attacker.getCurrentHp() + " *** 敌人: " + defenser.getCurrentHp());
		// attacker.printBuff();
		return false;
	}
	
	private boolean doAttack(Combater attacker, CombatTeam defensers) {
		if(attacker.canAct()) {
			attacker.attack(defensers);
		}
		else {
			System.out.println(attacker.getName() + "处于眩晕状态");
		}
		
		if(!defensers.isLive()) {
			// System.out.println("挂了");
			return true;
		}
		
		return false;
	}
	
	private void update() {
		attackers.update();
		defensers.update();
	}
	
}
