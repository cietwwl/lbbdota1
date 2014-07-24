package dota.buff.detail;

import java.util.ArrayList;
import java.util.List;

import dota.buff.Buff;
import dota.config.ParamConfig;
import dota.config.generated.BuffCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.print.PrintHelper;
import dota.team.CombatTeam;
import dota.util.CombaterHelper;
import dota.util.OP;

@OP(CODE = Enums.BuffType.FIREY_SOUL_VALUE, TYPE = OP.BUFF)
public class FierySoul extends Buff {
	
	int maxSize = 3;
	List<Soul> souls = new ArrayList<>();

	public FierySoul(BuffCfg config) {
		super(config);
	}

	@Override
	protected void start() {
		
	}

	@Override
	public void stop() {
		for (Soul e: souls) {
			souls.remove(e);
			removeEffectonOwner(e);
		}
	}
	
	@Override
	public void onEmitAnyActiveSkill(Combater emiter, CombatTeam defenser) {
		if (souls.size() == 3) {
			return;
		}
		Soul soul = new Soul();
		soul.addIas = config.getEffectValue()/100f;
		soul.addSpeed = config.getEffectValue0();
		soul.time = config.getEffectTime1();
		souls.add(soul);
		addEffectOnOwner(soul);
		PrintHelper.BuffPrint(owner, owner, config.getName(), soul.addIas);
	}
	
	@Override
	protected void update0() {
		List<Soul> toRemove = new ArrayList<>();
		for (Soul e: souls) {
			e.time -= ParamConfig.BattleInterval;
			if (e.time <= 0) {
				toRemove.add(e);
				removeEffectonOwner(e);
			}
		}
		souls.removeAll(toRemove);
	}
	
	private void addEffectOnOwner(Soul e) {
		owner.addIas(e.addIas);
		//TODO speed
	}
	
	private void removeEffectonOwner(Soul e) {
		owner.removeIas(e.addIas);
		//TODO speed
	}
	
	private class Soul {
		public float addIas;
		public int addSpeed;
		public int time;
	}
	


}
