package dota.battle;

import dota.config.ParamConfig;
import dota.hero.Combater;
import dota.skill.Skill;

public class Battle {
	
	private Combater attacker;
	private Combater defenser;
	private int counts = 0;	// 回合数
	
	public Battle(Combater attacker, Combater defenser) {
		this.attacker = attacker;
		this.defenser = defenser;
	}
	
	public void start() {		
		init();
		run();
	}
	
	private void init() {
		attacker.battleInit(defenser);
		defenser.battleInit(attacker);
		
		System.out.println("双方剩余生命值，" + attacker.getName() + ": " + attacker.getCurrentHp() + " *** " + defenser.getName() + ": " + defenser.getCurrentHp());
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
		if(doAttack(attacker, defenser)) {
			System.out.println("VICTORY");
		}
		if(doAttack(defenser, attacker)){
			System.out.println("LOSE");
		}
		update();
		System.out.println("双方剩余生命值，你: " + attacker.getCurrentHp() + " *** 敌人: " + defenser.getCurrentHp());
		attacker.printBuff();
		return false;
	}
	
	private boolean doAttack(Combater attacker, Combater defenser) {
		if(attacker.canAct()) {
			attacker.attack(defenser);
		}
		else {
			System.out.println(attacker.getName() + "处于眩晕状态");
		}
		
		if(!defenser.isLive()) {
			System.out.println(defenser.getName() + "挂了");
			return true;
		}
		
		return false;
	}
	
	private void update() {
		attacker.update();
		defenser.update();
	}
	
}
