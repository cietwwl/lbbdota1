package dota.skill.detail.share;

import java.util.List;

import dota.ai.SelectTarget;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.skill.Skill;
import dota.team.CombatTeam;
import dota.util.OP;

// 只是释放BUFF的技能
// 强化图腾， 余震， 巨力挥舞， 战吼， 神之力量
@OP(CODE = Enums.SkillType.EMIT_BUFF_VALUE, TYPE = OP.SKILL)
public class EmitBuff extends Skill {

	public EmitBuff(SkillCfg config) {
		super(config);
	}

	@Override
	protected int emit0(Combater attacker, Combater target, CombatTeam attackTeam, CombatTeam defenseTeam) {
		emitBuff(target, attackTeam, defenseTeam);
		return 0;
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker,
			CombatTeam defenserTeam, CombatTeam attackerTeam) {
		// 无目标释放
		if (config.getEmitType() == Enums.SkillEmitType.NOTARGET_VALUE) {
			// 作用范围是0，只是给自己释放的技能
			if (config.getEffectScope() == 0) {
				targets.add(attacker);
			} else {
			// AOE, 判断作用目标类型
				if (config.getEffectTargetType() == Enums.EffectTargetType.ENEMY_VALUE) {
					// 敌方
					targets.addAll(SelectTarget.getAllTargetsOfScope(attacker, config.getEffectScope(), defenserTeam));
				} else if (config.getEffectTargetType() == Enums.EffectTargetType.ENEMY_VALUE) {
					// 友方
					targets.addAll(SelectTarget.getAllTargetsOfScope(attacker, config.getEffectScope(), attackerTeam));
				}
			}
		} else if (config.getEmitType() == Enums.SkillEmitType.ONETARGET_VALUE) {
		// 指向型技能	
		} else if (config.getEmitType() == Enums.SkillEmitType.PASSIVE_VALUE) {
		// 被动技能，暂时处理为给自己加一个BUFF
			targets.add(attacker);
		}
	}

}
