package dota.team;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dota.battle.Combat;
import dota.hero.Combater;

public class CombatTeam implements Iterable<Combater>{
	private Combat combat = null;
	private List<Combater> team = new ArrayList<>();
	private int color = 0;
	
	public void setColor(int color) {
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}
	
	public void init(Combat battle) {
		this.combat = battle;
		for (Combater e: team) {
			e.setTeam(this);
		}
	}

	@Override
	public Iterator<Combater> iterator() {
		return team.iterator();
	}
	
	public Combat getBattle() {
		return this.combat;
	}
	
	public boolean isLive() {
		for (Combater e: team) {
			if (e.isLive()) {
				return true;
			}
		}
		return false;
	}
	
	public void update() {
		for (Combater e: team) {
			e.update();
		}
	}
	
	public void add(Combater combater) {
		if (!team.contains(combater)) {
			team.add(combater);
		}
		// TODO
	}
	
	public CombatTeam getOppentTeam() {
		CombatTeam team1 = combat.getSentinelHeros();
		if (team1.getColor() != color) {
			return team1;
		}
		return combat.getSourgeHeros();
	}
}
