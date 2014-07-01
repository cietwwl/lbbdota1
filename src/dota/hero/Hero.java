package dota.hero;

import dota.buff.BuffManager;
import dota.config.HeroConfig;
import dota.config.ParamConfig;
import dota.skill.Skill;
import dota.skill.SkillFactory;
import dota.skill.SkillManager;
import dota.skill.detail.CommonAttackSkill;
import dota.util.DotaMath;

public class Hero extends Combater {
	
	private int strength;
	private int agility;
	private int intelligence;
	private int heroType;
	
	protected void init(HeroConfig config) {
		heroType = config.heroType;
		critKey = config.crit;
		name = config.name;
		initHp(config);
		initAttack(config);
		initSkill(config);
		initBuff(config);
	}
	
	@Override
	protected void initHp(HeroConfig config) {
		hp = config.initHp;
		hp += config.heroStruct.strength * ParamConfig.StrengthToHp;
	}
	
	@Override
	protected void initAttack(HeroConfig config) {
		attack = config.initAttack;
		switch(heroType) {
		case 1:
			attack += config.heroStruct.strength * ParamConfig.StrengthToAttack;
			break;
		case 2:
			attack += config.heroStruct.agility * ParamConfig.AgilityToAttack;
			break;
		case 3:
			attack += config.heroStruct.intelligence * ParamConfig.IntelligenceToAttack;
			break;
		}
	}
	
	@Override
	protected void initSkill(HeroConfig config) {
		Skill skill = SkillFactory.Instance().creatSkill(config.commonAttackSkill, this);
		skillManager = new SkillManager(skill);
	};
	
	@Override
	protected void initBuff(HeroConfig config) {
		buffManager = new BuffManager();
	};
	
	@Override
	public int getRealAttack() {
		int damage = getRandomAttack(getAttack());
		int crited = isCrit();
		if(crited > 0) {
			System.out.print("触发暴击,");
		}
		return damage * (1+crited);
	}
	
	private int getRandomAttack(int attack) {
		if(DotaMath.RandomInRange(1, 10) >= 5) {
			attack += DotaMath.RandomInRange(0, (int)(attack*(ParamConfig.AttackRange/100.0)));
		}
		else {
			attack -= DotaMath.RandomInRange(0, (int)(attack*(ParamConfig.AttackRange/100.0)));
		}
		return attack;
	}
	
}
