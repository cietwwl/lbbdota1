package dota.team;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dota.hero.Combater;

public class CombatTeam implements Iterable<Combater>{
	private List<Combater> team = new ArrayList<>();
	
	// TODO 改成坐标体系后，这个也要改
	public void battleInit(CombatTeam defenserTeam) {
		for (Combater e: team) {
			e.battleInit(defenserTeam);
		}
	}

	@Override
	public Iterator<Combater> iterator() {
		return team.iterator();
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
