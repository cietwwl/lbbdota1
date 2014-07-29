package dota.config;

public class ParamConfig {
	// 战斗
	public static final int BattleInterval = 10;
	public static final float AttackRange = 0.1f;
	
	// 英雄属性
	public static final int StrengthToHp = 19;
	public static final int StrengthToAttack = 1;
	public static final int AgilityToAttack = 1;
	public static final int IntelligenceToAttack = 1;
	public static final int IntelligenceToEnergy = 10;
	public static final float AgilityToArmor = 0.1f;
	
	// BUFF
	public static final int BUFF_OVER_TIMEOUT = 0;    // BUFF由于时间到而结束
	public static final int BUFF_OVER_LEFTCOUNT = -99; // BUFF由于维持次数为0而结束
	public static final int BUFF_OVER_CLEAR = -100; // BUFF由于被清除而结束
	
}
