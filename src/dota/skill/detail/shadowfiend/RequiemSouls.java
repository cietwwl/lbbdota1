package dota.skill.detail.shadowfiend;

import java.util.List;

import dota.buff.Buff;
import dota.buff.detail.shadowfiend.NecroMasteryBuff;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.print.PrintHelper;
import dota.skill.Skill;
import dota.util.CombaterHelper;
import dota.util.OP;

// 魂之挽歌
@OP(CODE = Enums.SkillType.REQUIEM_OF_SOULS_VALUE, TYPE = OP.SKILL)
public class RequiemSouls extends Skill {
	private int souls;

	public RequiemSouls(SkillCfg config) {
		super(config);
	}

	@Override
	protected int emit0(Combater attacker, Combater target) {
		float x = CombaterHelper.getDistanceBetweenCombaters(attacker, target);
		float y = (1 - souls/2) * x / config.getEffectScope() + souls/2;
		int damage = target.beAttack((int)y, Enums.AttackType.MAGICAL_VALUE);
		PrintHelper.SkillPrint(attacker, target, config.getName(), damage);
		if (x < config.getEffectScope0()) {
			emitBuff(target, config.getBuffs());
		}
		return damage;
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker) {
		Buff soulBuff = attacker.getBuffManager().getBuff(6);
		souls = ((NecroMasteryBuff)soulBuff).getSouls();
		
		for (Combater e: attacker.getTeam().getOppentTeam()) {
			if (e.isLive() && CombaterHelper.getDistanceBetweenCombaters(attacker, e) <= config.getEffectScope()) {
				targets.add(e);
			}
		}
	}
	
}
