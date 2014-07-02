//package dota.buff.detail;
//
//import dota.buff.Buff;
//import dota.config.BuffConfig;
//
//// arg0: 增加的攻击力倍数
//
//public class EnchantTotemBuff extends Buff {
//
//	int addAttack = 0;
//	
//	public EnchantTotemBuff(BuffConfig config) {
//		super(config);
//	}
//
//	@Override
//	public void start() {
//		addAttack = owner.getCurrentAttack() * config.arg0/100;
//		owner.addAttack(addAttack);
//	}
//
//	@Override
//	public void stop() {
//		owner.dereaseAttack(addAttack);
//	}
//	
//	@Override
//	public void onCommonAttack() {
//		time = 0;
//	}
//
//}
