
package dota.ai;
import java.util.List;
import dota.skill.Skill;
import dota.skill.SkillManager;
import dota.util.DotaMath;

public class SelectSkill {
	
	/*
	 * 0,默认技能
	 * 1,玩家选择技能
	 * 2,AI
	 */
	public static Skill selectSkill(SkillManager skillManager) {
//		if(controlType == 1) {
//			@SuppressWarnings("resource")
//			Scanner sin = new Scanner(System.in);
//			skillManager.printAll();
//			System.out.print("选择技能:");
//			int n = sin.nextInt();
//			while(!skillManager.canEmit(n)) {
//				System.out.print("重新选择技能:");
//				n = sin.nextInt();
//			}
//			
//			return skillManager.getSkill(n, 0);
//		}
//		else {
			return randomSkill(skillManager);
//		}
	}
	
	//
	private static Skill randomSkill(SkillManager skillManager) {
		List<Skill> candidate = skillManager.getCanEmitSkills();
		if (candidate.size() == 0) {
			return null;
		}
		return candidate.get(DotaMath.RandomInRange(0, candidate.size() - 1));
	}
}
