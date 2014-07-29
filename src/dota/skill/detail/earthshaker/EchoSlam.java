package dota.skill.detail.earthshaker;

import java.util.List;

import dota.ai.SelectTarget;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.print.PrintHelper;
import dota.skill.Skill;
import dota.util.OP;

// 回音击
@OP(CODE = Enums.SkillType.ECHO_SLAM_VALUE, TYPE = OP.SKILL)
public class EchoSlam extends Skill {
	
	private int damage = 0;
	
	public EchoSlam(SkillCfg config) {
		super(config);
	}

	@Override
	protected int emit0(Combater attacker, Combater target) {
		int damage0 = target.beAttack(damage, Enums.AttackType.MAGICAL_VALUE);
		PrintHelper.SkillPrint(attacker, target, config.getName(), damage0);
		return damage;
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker) {
		targets.addAll(SelectTarget.getAllTargetsOfScope(attacker, config.getEmitDistance(), attacker.getTeam().getOppentTeam()));
		damage = config.getDamage() + config.getDamagePara1() * targets.size();
	}

}
