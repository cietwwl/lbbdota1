package dota.hero;

import dota.buff.BuffManager;
import dota.config.ParamConfig;
import dota.config.generated.GameConfig;
import dota.config.generated.HeroCfg;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.skill.Skill;
import dota.skill.SkillFactory;
import dota.skill.SkillManager;
import dota.skill.detail.CommonAttackSkill;
import dota.util.DotaMath;

public class Hero extends Combater {
	
	private PropertyLikeAttack strength = new PropertyLikeAttack();
	private PropertyLikeAttack agility = new PropertyLikeAttack();
	private PropertyLikeAttack intelligence = new PropertyLikeAttack();
	private int heroType;
	
	public void init(HeroCfg config) {
		initBase(config);
		initHp(config);
		initAttack(config);
		initSkill(config);
		initBuff(config);
	}
	
	private void initBase(HeroCfg config) {
		heroType = config.getHeroType();
		crite.key = 0;
		crite.value = 0;
		name = config.getName();
		strength.base = config.getInitStrength();
		agility.base = config.getInitAgility();
		intelligence.base = config.getInitIntelligence();
	}
	
	private void initHp(HeroCfg config) {
		hp.max = config.getInitHp();
		hp.max += strength.getReal() * ParamConfig.StrengthToHp;
		hp.current = hp.max;
	}
	
	private void initAttack(HeroCfg config) {
		attack.base = config.getInitAttack();
		attack.extra = 0;
		switch(heroType) {
		case Enums.HeroType.STRENGTH_VALUE:
			attack.base += strength.base * ParamConfig.StrengthToAttack;
			break;
		case Enums.HeroType.AGILITY_VALUE:
			attack.base += agility.base * ParamConfig.AgilityToAttack;
			break;
		case Enums.HeroType.INTELLIGENCE_VALUE:
			attack.base += intelligence.base * ParamConfig.IntelligenceToAttack;
			break;
		}
	}
	
	private void initSkill(HeroCfg config) {
		SkillCfg skillCfg = GameConfig.getInstance().getSkillCfg(1);
		Skill skill = SkillFactory.creatSkill(skillCfg);
		skillManager = new SkillManager(skill);
	};
	
	private void initBuff(HeroCfg config) {
		buffManager = new BuffManager();
	};
}
