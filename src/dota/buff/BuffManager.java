package dota.buff;

import java.util.ArrayList;
import java.util.Iterator;

import dota.enums.Enums;
import dota.hero.Combater;
import dota.print.PrintHelper;

public class BuffManager {
	private ArrayList<Buff> buffCollection = new ArrayList<>();
	
	public void add(Buff buff) {
		buffCollection.add(buff);
	}
	
	public Buff getBuff(int buffId) {
		for (Buff e: buffCollection) {
			if (e.getConfig().getId() == buffId) {
				return e;
			}
		}
		return null;
	}
	
	public void update(Combater owner) {
		Iterator<Buff> it = buffCollection.iterator();
		while(it.hasNext()) {
			Buff buff = it.next();
			buff.update();
			if( buff.isOver() ) {
				buff.stop();
				it.remove();
				if (buff.isTimeOut()) {
					PrintHelper.BuffTimeOut(buff.owner, buff.getConfig().getName());
				}
				buff = null;
			}
		}
	}
	
	public void triggerBuffEvent(int event, int damage, Object para0, Object para1) {
		Iterator<Buff> it = buffCollection.iterator();
		while (it.hasNext()) {
			Buff buff = it.next();
			switch (event) {
			case Enums.BuffEvent.COMMON_ATTACK_VALUE:
				buff.onCommonAttack(damage);
				break;
			case Enums.BuffEvent.EMIT_ANY_ACTIVE_SKILL_VALUE:
				buff.onEmitAnyActiveSkill();
				break;
			case Enums.BuffEvent.KILL_ANY_COMBATER_VALUE:
				buff.onKillAnyCombater((Combater)para0);// death
				break;
			case Enums.BuffEvent.OWNER_DEATH_VALUE:
				buff.onOwnerDeath();
				break;
			case Enums.BuffEvent.ANY_OPPENT_DEATH_VALUE:
				buff.onAnyOppentDeath((Combater)para0, (Combater)para1); // killer, death
				break;
			case Enums.BuffEvent.OWNER_BE_STUN_VALUE:
				buff.onOwnerBeStun();
				break;
			}
		}
	}
	
//	public void printAll() {
//		System.out.println("Buff名称        BUFF剩余时间");
//		Iterator<Buff> it = buffCollection.iterator();
//		while(it.hasNext()) {
//			Buff buff = it.next();
//			System.out.println(buff.getName() + "    " + buff.time);
//		}
//	}

}
