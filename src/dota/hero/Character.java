package dota.hero;

public class Character {
	protected PropertyLikeHp hp;			// 血
	protected PropertyLikeHp energy;		// 魔	
	protected PropertyLikeAttack attack;	// 攻击
	protected PropertyLikeAttack armor;		// 基础护甲
	protected PropertyLikeCrit crite;		// 暴击
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
	
	public int getRealArmor() {
		return armor.getReal();
	}
	
	public void loseHp(int hp) {
		this.hp.current -= hp;
		if (this.hp.current < 0) {
			this.hp.current = 0;
		}
	}
	
}

class PropertyLikeCrit {
	public int key;		// 暴击概率
	public int value;   // 暴击倍数
}


