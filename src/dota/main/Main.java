package dota.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dota.battle.Combat;
import dota.hero.Hero;
import dota.hero.HeroFactory;
import dota.print.PrintHelper;
import dota.team.CombatTeam;
import dota.util.FactoryHelper;

public class Main {
	
	private static final int SENTINEL = 1;
	private static final int SCOURGE = 2;

	public static void main(String[] args) {
		FactoryHelper.init();
		test001();
	}
	
	private static void test001() {
		CombatTeam team1 = new CombatTeam();
		CombatTeam team2 = new CombatTeam();
		team1.setColor(SENTINEL);
		team2.setColor(SCOURGE);
		
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
		
		laoNiu.setPosition(100, 0);
		chuanZhang.setPosition(100, 100);
		yingMo.setPosition(0, 0);
		bingNv.setPosition(0, 100);
		fengXing.setPosition(0, 200);
		
		liuLang.setPosition(200, 100);
		tuFu.setPosition(200, 200);
		chaoXi.setPosition(200, 0);
		xiaoHei.setPosition(300, 0);
		huoNv.setPosition(300, 100);
		Combat battle = new Combat();
		battle.init(team1, team2, null);
		battle.start();
	}

}
