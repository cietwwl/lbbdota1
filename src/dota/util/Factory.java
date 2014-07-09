package dota.util;

import dota.config.generated.SkillCfg;
import dota.skill.Skill;

public abstract class Factory {
	public abstract Skill create(SkillCfg config);
}