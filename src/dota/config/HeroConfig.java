package dota.config;

import dota.hero.HeroStruct;

public class HeroConfig {
	public int initHp;
	public int initAttack;
	public HeroStruct heroStruct = new HeroStruct();
	public int heroType;
	public int crit;
	public String name;
	public SkillConfig commonAttackSkill;
}
