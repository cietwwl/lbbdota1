package dota.hero;

import java.util.ArrayList;
import java.util.List;

import dota.config.ParamConfig;
import dota.enums.Enums;

public class CombatStateManager {
	private List<CombatState> combatStates = new ArrayList<>();
	
	/**
	 * 被击晕
	 */
	public void beStun(int count) {
		CombatState combatState = getState(Enums.CombatState.STUN_VALUE);
		if (combatState != null) {
			combatState.value = Math.max(count, combatState.value);
		} else {
			CombatState newCombatState = new CombatState(Enums.CombatState.STUN_VALUE, count);
			addState(newCombatState);
		}
	}
	
	/**
	 * 击晕回合数减一
	 */
	public void decreaseStun() {
		CombatState combatState = getState(Enums.CombatState.STUN_VALUE);
		if (combatState != null && combatState.value > 0) {
			combatState.value -= ParamConfig.BattleInterval;
		}
	}
	
	/**
	 * 清除眩晕效果
	 */
	public void clearStun() {
		CombatState combatState = getState(Enums.CombatState.STUN_VALUE);
		if (combatState != null && combatState.value > 0) {
			combatState.value = 0;
		}
	}
	
	/**
	 * 查询剩余眩晕回合数
	 * @return
	 */
	public int getLeftStunCounts() {
		CombatState combatState = getState(Enums.CombatState.STUN_VALUE);
		if (combatState != null) {
			return combatState.value;
		}
		return 0;
	}
	
	private CombatState getState(int type) {
		for (CombatState e: combatStates) {
			if (e.type == type) {
				return e;
			}
		}
		//TODO
		return null;
	}
	
	private void addState(CombatState combatState) {
		if (combatStates.contains(combatState)) {
			//TODO
			return;
		}
		combatStates.add(combatState);
	}
}