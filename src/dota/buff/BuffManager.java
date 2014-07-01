package dota.buff;

import java.util.ArrayList;
import java.util.Iterator;

import dota.hero.Combater;

public class BuffManager {
	private ArrayList<Buff> buffCollection = new ArrayList<>();
	
	public void add(Buff buff) {
		buffCollection.add(buff);
	}
	
	public void update() {
		Iterator<Buff> it = buffCollection.iterator();
		while(it.hasNext()) {
			Buff buff = it.next();
			buff.update();
			if( buff.isOver() ) {
				buff.stop();
				it.remove();
				buff = null;
			}
		}
	}
	
	public void onCommonAttack() {
		Iterator<Buff> it = buffCollection.iterator();
		while(it.hasNext()) {
			Buff buff = it.next();
			buff.onCommonAttack();
		}
	}
	
	public void onEmitAnySkill(Combater defenser) {
		Iterator<Buff> it = buffCollection.iterator();
		while(it.hasNext()) {
			Buff buff = it.next();
			buff.onEmitAnySkill(defenser);
		}
	}
	
	public void printAll() {
		System.out.println("Buff名称        BUFF剩余时间");
		Iterator<Buff> it = buffCollection.iterator();
		while(it.hasNext()) {
			Buff buff = it.next();
			System.out.println(buff.getName() + "    " + buff.time);
		}
	}
}
