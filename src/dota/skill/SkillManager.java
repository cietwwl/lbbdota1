package dota.skill;
import java.util.ArrayList;
import java.util.List;

import dota.enums.Enums;
import dota.hero.Combater;
import dota.skill.Skill;
import dota.team.CombatTeam;

public class SkillManager {
	private List<Skill> activeSkillList = new ArrayList<Skill>(); // 主动技能
	private List<Skill> passiveSkillList = new ArrayList<Skill>(); // 被动技能
	
	public SkillManager() {
	}
	
	public void add(Skill skill) {
		if (skill.getConfig().getEmitType() == Enums.SkillEmitType.ACTIEVE_VALUE) {
			activeSkillList.add(skill);
		} else {
			passiveSkillList.add(skill);
		}
	}
	
	public Skill getDefaultSkill() {
		return activeSkillList.get(0);
	}
	
	public Skill getSkill(int index, int emitType) {
		if (emitType == Enums.SkillEmitType.ACTIEVE_VALUE) {
			return activeSkillList.get(index);
		} else {
			return passiveSkillList.get(index);
		}	
	}
	
	public void update() {
		for (Skill e: activeSkillList) {
			e.update();
		}
	}
	
	public int getSize() {
		return activeSkillList.size();
	}
	
	public void printAll() {
		System.out.println("技能代号"+ "	" + "名字" + "	" + "CD");
		for(int i = 0; i < activeSkillList.size(); i++) {
			Skill skill = activeSkillList.get(i);
			System.out.println(i + "	" + skill.getConfig().getName() + "		" + skill.getCD());
		}
	}
	
	public boolean canEmit(int n) {
		Skill skill = null;
		try {
			skill = activeSkillList.get(n);
		} catch (Exception e) {
			System.out.println("无效的技能");
			return false;
		}
		
		if(!skill.canEmit()) {
			return false;
		}
		
		return true;
	}
	
	public void emitPassiveSkill(Combater attacker, CombatTeam targets) {
		for(Skill skill:passiveSkillList) {
			skill.emit(attacker, targets);
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
