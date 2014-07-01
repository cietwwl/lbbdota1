package dota.main;

import dota.battle.Battle;
import dota.config.HeroConfigFactory;
import dota.config.SkillConfigFactory;
import dota.hero.Hero;
import dota.skill.SkillFactory;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test001();
	}
	
	public static void test001() {
		Hero hero1 = new Hero(HeroConfigFactory.getInstance().getConfig(0));
		Hero hero2 = new Hero(HeroConfigFactory.getInstance().getConfig(1));
		hero1.setName("hero");
		hero1.setControlType(1);
		hero1.addSkill(SkillConfigFactory.getInstance().getConfig(1));
		hero1.addSkill(SkillConfigFactory.getInstance().getConfig(2));
		hero1.addSkill(SkillConfigFactory.getInstance().getConfig(3));
		Battle battle = new Battle(hero1, hero2);
		battle.start();
	}

}
