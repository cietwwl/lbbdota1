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
		
		Hero laoNiu = HeroFactory.create(1);
		Hero liuLang = HeroFactory.create(2);
		Hero yingMo = HeroFactory.create(3);
		Hero tuFu = HeroFactory.create(4);
		Hero huoNv = HeroFactory.create(5);
		Hero bingNv = HeroFactory.create(6);
		Hero fengXing = HeroFactory.create(7);
		Hero xiaoHei = HeroFactory.create(8);
		Hero chuanZhang = HeroFactory.create(9);
		Hero chaoXi = HeroFactory.create(10);
		
		team1.add(laoNiu);
		team1.add(yingMo);
		team1.add(bingNv);
		team1.add(chuanZhang);
		team1.add(fengXing);
		
		team2.add(liuLang);
		team2.add(tuFu);
		team2.add(xiaoHei);
		team2.add(huoNv);
		team2.add(chaoXi);
		
		laoNiu.setPosition(1, 1);
		chuanZhang.setPosition(2, 1);
		yingMo.setPosition(0, 0);
		bingNv.setPosition(0, 1);
		fengXing.setPosition(0, 2);
		
		liuLang.setPosition(0, 2);
		tuFu.setPosition(1, 2);
		chaoXi.setPosition(2, 2);
		xiaoHei.setPosition(1, 3);
		huoNv.setPosition(2, 3);
		Battle battle = new Battle();
		battle.init(team1, team2, null);
		battle.start();
	}

}
