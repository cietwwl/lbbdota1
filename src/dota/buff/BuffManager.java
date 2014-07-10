package dota.buff;

import java.util.ArrayList;
import java.util.Iterator;

import dota.hero.Combater;
import dota.team.CombatTeam;

public class BuffManager {
	private ArrayList<Buff> buffCollection = new ArrayList<>();
	
	public void add(Buff buff) {
		buffCollection.add(buff);
	}
	
	public void update(Combater owner) {
		Iterator<Buff> it = buffCollection.iterator();
		while(it.hasNext()) {
			Buff buff = it.next();
			buff.update();
			if( buff.isOver() ) {
				buff.stop();
				it.remove();
				System.out.println(owner.getName() + " 的BUFF " + buff.getConfig().getName() + " 消失");
				buff = null;
			}
		}
	}
	
	public void onCommonAttack(Combater attacker, CombatTeam defenser, int damage) {
		Iterator<Buff> it = buffCollection.iterator();
		while(it.hasNext()) {
			Buff buff = it.next();
			buff.onCommonAttack(attacker, defenser, damage);
		}
	}
	
	public void onEmitAnyActiveSkill(Combater attacker, CombatTeam defenseTeam) {
		Iterator<Buff> it = buffCollection.iterator();
		while(it.hasNext()) {
			Buff buff = it.next();
			buff.onEmitAnyActiveSkill(attacker, defenseTeam);;
		}
	}
	
	public void onKillAnyCombater(Combater soul) {
		Iterator<Buff> it = buffCollection.iterator();
		while(it.hasNext()) {
			Buff buff = it.next();
			buff.onKillAnyCombater(soul);;
		}
	}
	
	public Buff getBuff(int buffId) {
		for (Buff e: buffCollection) {
			if (e.getConfig().getId() == buffId) {
				return e;
			}
		}
		return null;
	}
	
	public void printAll() {
//		System.out.println("Buff名称        BUFF剩余时间");
//		Iterator<Buff> it = buffCollection.iterator();
//		while(it.hasNext()) {
//			Buff buff = it.next();
//			System.out.println(buff.getName() + "    " + buff.time);
//		}
	}
}
