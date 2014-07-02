package dota.main;

import dota.battle.Battle;
import dota.hero.Hero;
import dota.hero.HeroFactory;
import dota.team.CombatTeam;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(System.getProperty("java.class.path"));
		test001();
	}
	
	private static void test001() {
		CombatTeam team1 = new CombatTeam();
		CombatTeam team2 = new CombatTeam();
		
		for (int i = 0; i < 5; i++) {
			Hero laoNiu0 = HeroFactory.create(1);
			Hero laoNiu1 = HeroFactory.create(1);
			team1.add(i, laoNiu0);
			team2.add(i, laoNiu1);
		}
		
		Battle battle = new Battle(team1, team2);
		battle.start();
	}

}
