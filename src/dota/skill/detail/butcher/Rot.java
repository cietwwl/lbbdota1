package dota.skill.detail.butcher;

import java.util.List;

import dota.buff.detail.RotBuff;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.skill.Skill;
import dota.team.CombatTeam;
import dota.util.OP;

@OP(CODE = Enums.SkillType.ROT_VALUE, TYPE = OP.SKILL)
public class Rot extends Skill {
	
	private boolean openFlag = false;
	private RotBuff rotBuff = null;

	public Rot(SkillCfg config) {
		super(config);
	}

	@Override
	protected int emit0(Combater attacker, Combater target,
			CombatTeam attackTeam, CombatTeam defenseTeam) {
		
		if (rotBuff == null) {
			emitBuff(target, attackTeam, defenseTeam);
			rotBuff = (RotBuff) attacker.getBuffManager().getBuff(12);
		}
		
		if (openFlag) {
			rotBuff.setOpenFlag(false);
			System.out.println(attacker.getName() + " 关闭 " + config.getName());
		} else {
			rotBuff.setOpenFlag(true);
			System.out.println(attacker.getName() + " 激活 " + config.getName());
		}
		
		return 0;
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker,
			CombatTeam defenserTeam, CombatTeam attackerTeam) {
		targets.add(attacker);
	}
	
	public RotBuff getRotBuff() {
		return this.rotBuff;
	}
	
}
