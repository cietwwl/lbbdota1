package dota.print;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dota.battle.Combat;
import dota.hero.Character;
import dota.hero.Combater;
import dota.hero.PropertyLikeArmor;
import dota.hero.PropertyLikeAttack;

public class PrintHelper {
	
	public static Logger logger = LoggerFactory.getLogger(PrintHelper.class);
	
	public static void SkillPrint(Combater attacker, Combater target, String skillName, int damage) {
		logger.info("	[{}] %{}% --> [{}]: DAMAGE {} LEFT-HP {}", 
				attacker.getName(), skillName, target.getName(), damage, target.getCurrentHp());
	}
	
	public static void SkillLearnPrint(Combater owner, String skillName) {
		// printTime();
		logger.info("[{}] LEARN %{}%", owner.getName(), skillName);
	}
	
	public static void SkillEmitPrint(Combater owner, String skillName) {
		logger.info("{} [{}] EMIT %{}%", printTime(), owner.getName(), skillName);
	}
	
	public static void SkillPrint(Combater attacker, Combater target,
			String name, int damage, int effectTime) {
		// printTime();
		logger.info("	[{}] %{}% --> [{}]: DAMAGE {} STUN {} LEFT-HP {}",
				attacker.getName(), name, target.getName(), damage, effectTime, target.getCurrentHp());
	}
	
	public static void BuffTimeOut(Combater buffOwner, String buffName) {
		logger.info("{} [{}] *{}*: OVER", printTime(), buffOwner.getName(), buffName);
	}
	
	public static void BuffOver(Combater buffOwner, String buffName) {
		// printTime();
		logger.info("	[{}] *{}*: OVER", buffOwner.getName(), buffName);
	}
	
	public static void BuffPrint(Combater attacker, Combater defenser, String buffName, float data) {
		// printTime();
		logger.info("	[{}] *{}* --> [{}]: DAMAGE {} LEFT-HP {}",
				attacker.getName(), buffName, defenser.getName(), data, defenser.getCurrentHp());
	}
	
	public static void BuffPrintWithTime(Combater attacker, Combater defenser, String buffName, float data) {
		// printTime();
		logger.info("{} [{}] *{}* --> [{}]: DAMAGE {} LEFT-HP {}",
				printTime(), attacker.getName(), buffName, defenser.getName(), data, defenser.getCurrentHp());
	}
	
	public static void BuffPrint(Combater attacker, Combater defenser, String buffName, float data, float stun) {
		logger.info("	[{}] *{}* --> [{}]: DAMAGE {} STUN {} LEFT-HP {}",
				attacker.getName(), buffName, defenser.getName(), data, stun, defenser.getCurrentHp());
	}
	
	public static void BuffGetPrint(Combater owner, String buffName) {
		// printTime();
		logger.info("	[{}] GET *{}*", owner.getName(), buffName);
	}
	
	public static void BuffOpenPrint(String combaterName, String buffName, boolean b) {
		if (b) {
			logger.info("{} [{}] OPEN *{}*", printTime(), combaterName, buffName);
		} else {
			logger.info("{} [{}] CLOSE *{}*", printTime(), combaterName, buffName);
		}
	}
	
	public static void KillPrint(Combater killer, Combater death) {
		// printTime();
		logger.info("	[{}] KILL *{}*", killer.getName(), death.getName());
	}
	
	public static void printAttack(Character combater) {
		PropertyLikeAttack attack = combater.getAttack();
		String str = "	[" + combater.getName() + "]" + " ATTACK: " + 
		attack.base_min + " ~ " + attack.base_max;
		if (attack.extra < 0 ) {
			logger.info("{} - {}", str, attack.extra);
		} else if (attack.extra > 0){
			logger.info("{} + {}", str, attack.extra);
		} else {
			logger.info(str);
		}
	}
	
	public static void printArmor(Character combater) {
		PropertyLikeArmor armor = combater.getArmor();
		String str = "	[" + combater.getName() + "]" + " ARMOR: " + armor.base;
		if (armor.extra < 0 ) {
			logger.info("{} - {}", str, armor.extra);
		} else if (armor.extra > 0){
			logger.info("{} + {}", str, armor.extra);
		}
	}
	
	private static String printTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("mm:ss"); 
        return sdf.format(Combat.time);
	}



}
