package dota.team;

import java.util.Iterator;

import dota.hero.Combater;

public class CombatTeam implements Iterable<Combater>{
	private Combater[] team = new Combater[5]; // 下标作为位置，是否改成ArrayList TODO
	
	public void battleInit(CombatTeam defensers) {
		for(int i = 0; i < 5; i++) {
			if (team[i] != null) {
				team[i].battleInit(defensers);
			}
		}
	}
	
	public Combater get(int index) {
		return team[index];
	}

	@Override
	public Iterator<Combater> iterator() {
		Iterator<Combater> it = new Iterator<Combater>() {
			int i = 0;
			@Override
			public Combater next() {
				return team[i++];
			}
			
			@Override
			public boolean hasNext() {
				if (i < 5) {
					return true;
				}
				return false;
			}
		};
		return it;
	}
	
	public boolean isLive() {
		for(int i = 0; i < 5; i++) {
			if (team[i] != null && team[i].isLive()) {
				return true;
			}
		}
		return false;
	}
	
	public void update() {
		for(int i = 0; i < 5; i++) {
			if (team[i] != null) {
				team[i].update();
			}
		}
	}
	
	public void add(int index, Combater combater) {
		if (team[index] != null) {
			// TODO
			return;
		}
		team[index] = combater;
	}
}
