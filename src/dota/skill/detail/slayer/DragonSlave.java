package dota.skill.detail.slayer;

import java.util.ArrayList;
import java.util.List;

import dota.ai.SelectTarget;
import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.print.PrintHelper;
import dota.skill.Skill;
import dota.util.DotaMath;
import dota.util.OP;
import dota.util.Point;

@OP(CODE = Enums.SkillType.DRAGON_SLAVE_VALUE, TYPE = OP.SKILL)
public class DragonSlave extends Skill {
	
	private static final int STARTING_AOE = 275;
	private static final int DISTANCE = 800;
	private static final int FINAL_AOE = 200;
	private static final int MAX_DISTANCE = 1250;
	
	public DragonSlave(SkillCfg config) {
		super(config);
	}

	@Override
	protected int emit0(Combater attacker, Combater target) {
		int damage = target.beAttack(config.getDamage(), Enums.AttackType.MAGICAL_VALUE);
		PrintHelper.SkillPrint(attacker, target, config.getName(), damage);
		return damage;
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker) {	
		Combater target = SelectTarget.getOneOppentByRandom(attacker, config.getEmitDistance());
		targets.addAll(SelectTarget.getAllTargetOfPolygon(buildPolygon(attacker, target), attacker.getTeam().getOppentTeam()));
	}
	
	private List<Point> buildPolygon(Combater attacker, Combater target) {
		List<Point> polygon = new ArrayList<>();
		Point pA = new Point(attacker.positionX, attacker.positionY);
		Point pT = new Point(attacker.positionX, target.positionY);
		int castDis = DotaMath.distance(pA, pT);
		Point pM = null;
		if (castDis < MAX_DISTANCE - DISTANCE) {
			pM = DotaMath.getPointInSegment(pA, pT, castDis + DISTANCE);
		} else {
			pM = DotaMath.getPointInSegment(pA, pT, MAX_DISTANCE);
			pT = DotaMath.getPointInSegment(pA, pT, MAX_DISTANCE - DISTANCE);
		}
		
		Point p1 = new Point(0, 0);
		Point p2 = new Point(0, 0);
		Point p3 = new Point(0, 0);
		Point p4 = new Point(0, 0);
		
		DotaMath.getPointsOfAT(pA, pT, p1, p2, STARTING_AOE / 2);
		DotaMath.getPointsOfAT(pA, pM, p3, p4, FINAL_AOE / 2);
		
		polygon.add(p1);
		polygon.add(p2);
		
		Point vecP12 = new Point(p1.x - p2.x, p1.y - p2.y);
		Point vecP34 = new Point(p3.x - p3.x, p3.y - p3.y);
		if (vecP12.x * vecP34.x < 0 ||vecP12.y * vecP34.y < 0) {
			polygon.add(p3);
			polygon.add(p4);
		} else {
			polygon.add(p4);
			polygon.add(p3);
		}
		
		return polygon;
	}

}
