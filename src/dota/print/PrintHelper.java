package dota.print;

import dota.hero.Combater;

public class PrintHelper {
	public static void BuffPrint(Combater attacker, Combater defenser, String buffName, float data) {
		System.out.println("["+attacker.getName()+"]" + "***" + buffName +"***" +
				"-->[" + defenser.getName() + "]:" + data);
	}
	
	public static void SkillPrint(Combater attacker, Combater target, String skillName, int damage) {
		System.out.println("["+attacker.getName()+"]" + "%%%" + skillName +"%%%" +
				"-->[" + target.getName() + "]:" + damage);
	}
}
