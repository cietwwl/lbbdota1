package dota.buff.detail.earthshaker;

import dota.buff.Buff;
import dota.config.ParamConfig;
import dota.config.generated.BuffCfg;
import dota.enums.Enums;
import dota.print.PrintHelper;
import dota.util.OP;

// arg0: 增加的攻击力倍数
@OP(CODE = Enums.BuffType.ENCHANT_TOTEM_BUFF_VALUE, TYPE = OP.BUFF)
public class EnchantTotemBuff extends Buff {

	int addAttack = 0;		// 增加的攻击力
	int leftCounts = 0;		// 剩余的维持的攻击次数
	
	public EnchantTotemBuff(BuffCfg config) {
		super(config);
	}

	@Override
	public void start() {
		addAttack =  (int) (owner.getMinBaseAttack() * config.getEffectValue()/100);
		owner.addAttack(addAttack);
		leftCounts = config.getEffectCounts();
	}

	@Override
	public void stop() {
		owner.removeAttack(addAttack);
	}
	
	@Override
	public void onCommonAttack(int damage) {
		leftCounts --;
		if (leftCounts == 0) {
			time = ParamConfig.BUFF_OVER_LEFTCOUNT;
			PrintHelper.BuffOver(owner, config.getName());
		}
	}

}
