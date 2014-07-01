package dota.config;

public class SkillConfig {
	public int skillType;
	public int CD;	// 由于设计问题，这里实际CD是要-1的，所以如果要实现3回合，就要配4回合
	public int arg0;
	public int arg1;
	public String name;
	public BuffConfig buff0;
	public int emitType;	// 0主动，1，被动
}
