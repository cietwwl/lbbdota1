package dota.hero;

import java.util.ArrayList;
import java.util.List;

import dota.buff.BuffManager;
import dota.config.ParamConfig;
import dota.config.generated.GameConfig;
import dota.config.generated.HeroCfg;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.skill.SkillManager;

public class Hero extends Combater {
	
	private PropertyLikeArmor strength = new PropertyLikeArmor();
	private PropertyLikeArmor agility = new PropertyLikeArmor();
	private PropertyLikeArmor intelligence = new PropertyLikeArmor();
	private int heroType;
	private List<Integer> canLearnSkills;
	
	public void init(HeroCfg config) {
		initBase(config);
		initHp(config);
		initEnergy(config);
		initAttack(config);
		initSkills(config);
		initBuff(config);
		initIas(config);
		initArmor(config);
	}
	
	private void initBase(HeroCfg config) {
		setId(config.getId());
		heroType = config.getHeroType();
		crite.key = 0;
		crite.value = 0;
		name = config.getName();
		strength.base = config.getInitStrength();
		agility.base = config.getInitAgility();
		intelligence.base = config.getInitIntelligence();
		attackDistance = config.getAttackDitance();
	}
	
	private void initHp(HeroCfg config) {
		hp.max = config.getInitHp();
		hp.max += strength.getReal() * ParamConfig.StrengthToHp;
		hp.current = hp.max;
	}
	
	private void initEnergy(HeroCfg config) {
		energy.max = config.getInitEnergy();
		energy.max += intelligence.getReal() * ParamConfig.IntelligenceToEnergy;
	}
	
	private void initAttack(HeroCfg config) {
		attack.base_min = config.getInitMinAttack();
		attack.base_max = config.getInitMaxAttack();
		attack.extra = 0;
		switch(heroType) {
		case Enums.HeroType.STRENGTH_VALUE:
			attack.addBase(strength.base * ParamConfig.StrengthToAttack);
			break;
		case Enums.HeroType.AGILITY_VALUE:
			attack.addBase(agility.base * ParamConfig.AgilityToAttack);
			break;
		case Enums.HeroType.INTELLIGENCE_VALUE:
			attack.addBase(intelligence.base * ParamConfig.IntelligenceToAttack);
			break;
		}
	}
	
	private void initArmor(HeroCfg config) {
		armor.base = config.getInitArmor();
		armor.base += agility.base * ParamConfig.AgilityToArmor;
	}
	
	private void initSkills(HeroCfg config) {
		canLearnSkills = new ArrayList<Integer>();
		String[] skills = config.getInitSkills().split(",");
		for (int i = 0; i < skills.length; i++) {
			canLearnSkills.add(Integer.parseInt(skills[i]));
		}
	}
	
	@Override
	public void learnSkills() {
		skillManager = new SkillManager();
		for (int i: canLearnSkills) {
			SkillCfg skillCfg = GameConfig.getInstance().getSkillCfg(i);
			this.learnSkill(skillCfg);
		}
		
	}
	
	private void initBuff(HeroCfg config) {
		buffManager = new BuffManager();
	}
	
	private void initIas(HeroCfg config) {
		ias += agility.getReal()/100f; // 每一点敏捷增加1%的攻速
		base_attack_speed = config.getInitAttackSpeed();
	}
	
	public void addStrength(float add) {
		strength.base += add;
		// 更新攻击力 TODO
		System.out.println(getName() + "力量: " + strength.base + " + "+ strength.extra);
	}
	
	public int getStrength() {
		return (int) strength.getReal();
	}
}
