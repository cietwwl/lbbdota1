package dota.skill.detail.rogueknight;

import java.util.List;

import dota.ai.SelectTarget;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.skill.Skill;
import dota.team.CombatTeam;

public class StormBolt extends Skill {

	public StormBolt(SkillCfg config) {
		super(config);
	}

	@Override
	protected int emit0(Combater attacker, Combater target) {
		int damage = target.beAttack(config.getDamage(), Enums.AttackType.MAGICAL_VALUE);
		target.beStun(config.getEffectTime());
		System.out.println(attacker.getName() + " 对 " + target.getName() + "释放 " + this.getConfig().getName() + ", 造成" + damage + "的伤害和" + config.getEffectTime() + "的眩晕");
	    return damage;
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker,
			CombatTeam defenserTeam, CombatTeam attackerTeam) {
		Combater target = SelectTarget.getOneOppentByRandom(attacker, defenserTeam, config.getEmitDistance());
		targets.addAll(SelectTarget.getAllTargetsOfScope(target, config.getEffectScope(), defenserTeam));
	}

}
