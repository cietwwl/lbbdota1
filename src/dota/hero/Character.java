package dota.hero;

import dota.map.GameObject;

public class Character extends GameObject {
	protected PropertyLikeHp hp = new PropertyLikeHp();			// 血
	protected PropertyLikeHp energy = new PropertyLikeHp();		// 魔	
	protected PropertyLikeAttack attack = new PropertyLikeAttack();	// 攻击
	protected PropertyLikeArmor armor = new PropertyLikeArmor();		// 基础护甲
	protected PropertyLikeCrit crite = new PropertyLikeCrit();		// 暴击
	protected int magicRes;					// 魔抗
	protected String name;  				// 名字
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCurrentHp() {
		return hp.current;
	}
	
	public int getMaxHp() {
		return hp.max;
	}
	
	public int getRealAttack() {
		return attack.getReal();
	}
	
	public float getMinBaseAttack() {
		return attack.base_min;
	}
	
	/**
	 * 通过该函数只能加附加值
	 * @param addAttack
	 */
	public void addAttack(int addAttack) {
		attack.extra += addAttack;
	}
	
	/**
	 * 通过该函数只能加附加值
	 * @param rmAttack
	 */
	public void removeAttack(int rmAttack) {
		attack.extra -= rmAttack;
	}
	
	public float getRealArmor() {
		return armor.getReal();
	}
	
	public void loseHp(int hp) {
		this.hp.current -= hp;
		if (this.hp.current < 0) {
			this.hp.current = 0;
		}
	}
	
	public float getCriteProbility() {
		return crite.key/100f;
	}
	
	public int getCriteValue() {
		return crite.value;
	}
	
	public PropertyLikeArmor getArmor() {
		return armor;
	}
	
}

class PropertyLikeCrit {
	public int key;		// 暴击概率， 整数数值
	public int value;   // 暴击倍数
}


