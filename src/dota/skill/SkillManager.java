package dota.skill;
import java.util.ArrayList;
import java.util.List;

import dota.enums.Enums;

public class SkillManager {
	private List<Skill> activeSkillList = new ArrayList<Skill>(); // 主动技能
	private List<Skill> passiveSkillList = new ArrayList<Skill>(); // 被动技能
	
	public void add(Skill skill) {
		if (skill.getConfig().getEmitType() != Enums.SkillEmitType.PASSIVE_VALUE) {
			activeSkillList.add(skill);
		} else {
			passiveSkillList.add(skill);
		}	
	}
	
	public void update() {
		for (Skill e: activeSkillList) {
			e.update();
		}
	}
	
	public List<Skill> getCanEmitSkills() {
		List<Skill> result = new ArrayList<>();
		for (Skill e: activeSkillList) {
			if (e.canEmit()) {
				result.add(e);
			}
		}
		return result;
	}
}
