package dota.skill.detail.shadowfiend;

import java.util.List;

import dota.buff.Buff;
import dota.buff.detail.NecroMastery;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.skill.Skill;
import dota.team.CombatTeam;
import dota.util.HeroHelper;
import dota.util.OP;

@OP(CODE = Enums.SkillType.REQUIEM_OF_SOULS_VALUE, TYPE = OP.SKILL)
public class RequiemSouls extends Skill {
	private int souls;

	public RequiemSouls(SkillCfg config) {
		super(config);
	}

	@Override
	protected int emit0(Combater attacker, Combater target, CombatTeam attackTeam, CombatTeam defenseTeam) {
		float x = HeroHelper.getDistanceBetweenCombaters(attacker, target);
		float y = (1 - souls/2) * x / config.getEffectScope() + souls/2;
		int damage = target.beAttack((int)y, Enums.AttackType.MAGICAL_VALUE, attacker);
		System.out.println(attacker.getName() + " 的 " + config.getName() + 
				" 对 " + target.getName() + " 造成了 " + damage + " 的伤害");
		if (x < config.getEffectScope0()) {
			emitBuff(target, attackTeam, defenseTeam);
		}
		return damage;
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker,
			CombatTeam defenserTeam, CombatTeam attackerTeam) {
		Buff soulBuff = attacker.getBuffManager().getBuff(6);
		souls = ((NecroMastery)soulBuff).getSouls();
		
		for (Combater e: defenserTeam) {
			if (e.isLive() && HeroHelper.getDistanceBetweenCombaters(attacker, e) <= config.getEffectScope()) {
				targets.add(e);
			}
		}
	}
	
}
