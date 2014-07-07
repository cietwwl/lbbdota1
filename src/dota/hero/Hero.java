package dota.hero;

import dota.buff.BuffManager;
import dota.config.ParamConfig;
import dota.config.generated.HeroCfg;
import dota.enums.Enums;
import dota.skill.Skill;
import dota.skill.SkillFactory;
import dota.skill.SkillManager;

public class Hero extends Combater {
	
	private PropertyLikeArmor strength = new PropertyLikeArmor();
	private PropertyLikeArmor agility = new PropertyLikeArmor();
	private PropertyLikeArmor intelligence = new PropertyLikeArmor();
	private int heroType;
	
	public void init(HeroCfg config) {
		initBase(config);
		initHp(config);
		initEnergy(config);
		initAttack(config);
		initSkill(config);
		initBuff(config);
		initIas(config);
	}
	
	private void initBase(HeroCfg config) {
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
	
	private void initSkill(HeroCfg config) {
		String[] skills = config.getInitSkills().split(",");
		skillManager = new SkillManager();
		for (int i = 0; i < skills.length; i++) {
			Skill skill = SkillFactory.createSkill(Integer.parseInt(skills[i]));
			skillManager.add(skill);
		}
		
	}
	
	private void initBuff(HeroCfg config) {
		buffManager = new BuffManager();
	}
	
	private void initIas(HeroCfg config) {
		ias += agility.getReal()/100f; // 每一点敏捷增加1%的攻速
		base_attack_speed = config.getInitAttackSpeed();
	}
}
