package dota.skill.detail.butcher;

import java.util.List;

import dota.buff.detail.butcher.RotBuff;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.print.PrintHelper;
import dota.skill.Skill;
import dota.util.OP;

// 腐烂
@OP(CODE = Enums.SkillType.ROT_VALUE, TYPE = OP.SKILL)
public class Rot extends Skill {
	
	private boolean openFlag = false;
	private RotBuff rotBuff = null;

	public Rot(SkillCfg config) {
		super(config);
	}

	@Override
	protected int emit0(Combater attacker, Combater target) {
		if (openFlag) {
			rotBuff.setOpenFlag(false);
			PrintHelper.BuffOpenPrint(attacker.getName(), config.getName(), false);
			rotBuff = (RotBuff) attacker.getBuffManager().getBuff(12);
			rotBuff.clear();
			PrintHelper.BuffOver(attacker, rotBuff.getConfig().getName());
			rotBuff = null;
			openFlag = false;
		} else {
			PrintHelper.BuffOpenPrint(attacker.getName(), config.getName(), true);
			emitBuff(target, config.getBuffs());
			rotBuff = (RotBuff) attacker.getBuffManager().getBuff(12);
			rotBuff.setOpenFlag(true);
			openFlag = true;
		}
		
		return 0;
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker) {
		targets.add(attacker);
	}
	
	public RotBuff getRotBuff() {
		return this.rotBuff;
	}
	
}
