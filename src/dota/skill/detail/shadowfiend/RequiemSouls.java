package dota.skill.detail.shadowfiend;

import java.util.List;

import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.skill.Skill;
import dota.team.CombatTeam;
import dota.util.OP;

@OP(CODE = Enums.SkillType.REQUIEM_OF_SOULS_VALUE, TYPE = OP.SKILL)
public class RequiemSouls extends Skill {

	public RequiemSouls(SkillCfg config) {
		super(config);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int emit0(Combater attacker, Combater target) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker,
			CombatTeam defenserTeam, CombatTeam attackerTeam) {
		// TODO Auto-generated method stub
		
	}
	
}
