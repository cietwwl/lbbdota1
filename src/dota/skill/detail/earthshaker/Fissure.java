//package dota.skill.detail.earthshaker;
//
//import dota.config.SkillConfig;
//import dota.hero.Combater;
//import dota.skill.Skill;
//
///*
// * 老牛F
// */
//public class Fissure extends Skill{
//	
//	// type: 1
//	// arg0: 眩晕回合数
//	// arg1: 伤害
//	public Fissure(SkillConfig config) {
//		super(config);
//	}
//
//	@Override
//	public void emit0(Combater defenser) {
//		int damage = defenser.beAttack(config.arg1);
//		defenser.beStun(config.arg0);
//		System.out.println(getOwner().getName() + " 对 " + defenser.getName() + "释放 " + this.getName() + ", 造成" + damage + "的伤害和" + config.arg0 + "的眩晕");
//	}
//	
//}
