package dota.team;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dota.battle.Battle;
import dota.hero.Combater;

public class CombatTeam implements Iterable<Combater>{
	private Battle battle = null;
	private List<Combater> team = new ArrayList<>();
	private int color = 0;
	
	public void setColor(int color) {
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}
	
	public void init(Battle battle) {
		this.battle = battle;
		for (Combater e: team) {
			e.setTeam(this);
		}
	}

	@Override
	public Iterator<Combater> iterator() {
		return team.iterator();
	}
	
	public Battle getBattle() {
		return this.battle;
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
}
