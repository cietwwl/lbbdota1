package dota.buff.detail.share;

import java.util.ArrayList;
import java.util.List;

import dota.buff.Buff;
import dota.config.generated.BuffCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.util.CombaterHelper;
import dota.util.OP;

// 光环类BUFF
@OP(CODE = Enums.BuffType.AURA_BUFF_VALUE, TYPE = OP.BUFF)
public class AuraBuff extends Buff {
	
	private List<Combater> effecters = new ArrayList<>(); // 受光环影响的单位
	private List<Integer> buffs = new ArrayList<>();

	public AuraBuff(BuffCfg config) {
		super(config);
	}

	@Override
	protected void start() {
		initBuffs();
		List<Combater> targets = selectTargets(owner);
		effecters.addAll(targets);
		for (Combater e: targets) {
			emitBuff(e);
		}
	}
	
	private void initBuffs() {
		String[] buffStr = config.getBuffs().split(",");
		for (int i = 0; i < buffStr.length; i++) {
			buffs.add(Integer.parseInt(buffStr[i]));
		}
	}
	
	private void emitBuff(Combater target) {	
		for (int i = 0; i < buffs.size(); i++) {
			target.addBuff(buffs.get(i));
		}
	}
	
	@Override
	public void stop() {
		for (Combater e: effecters) {
			for (int buffId: buffs) {
				Buff buff = e.getBuffManager().getBuff(buffId);
				buff.clear();
			}
		}
	}
	
	// 频繁的内存释放和开辟 TODO
	@Override
	protected void update0() {
		List<Combater> nowTargets = selectTargets(owner);
		for (Combater e: nowTargets) {
			if (!effecters.contains(e)) {
				effecters.add(e);
				emitBuff(e);
			}
		}
		
		List<Combater> rmTargets = new ArrayList<>();
		
		for (Combater e: effecters) {
			if (!e.isLive()) {
				rmTargets.add(e);
				continue;
			}
			if (!nowTargets.contains(e)) {
				rmTargets.add(e);
				for (int buffId: buffs) {
					Buff buff = e.getBuffManager().getBuff(buffId);
					buff.clear();
				}
			}
		}
		
		effecters.removeAll(rmTargets);
	}
	
	private List<Combater> selectTargets(Combater emiter) {
		List<Combater> targets = new ArrayList<>();
		for (Combater e: emiter.getTeam().getOppentTeam()) {
			if (e.isLive() && CombaterHelper.getDistanceBetweenCombaters(emiter, e) <= config.getEffectScope()) {
				targets.add(e);
			}
		}
		return targets;
	}

}
