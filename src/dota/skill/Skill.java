package dota.skill;

import dota.config.SkillConfig;
import dota.hero.Combater;

public abstract class Skill {
	protected SkillConfig config;
	protected Combater owner;
	private int CD = 0;
	
	public void setCD(int CD) {
		this.CD = CD;
	}
	
	public int getCD() {
		return CD;
	}
	
	public void decreaseCD() {
		if(CD == 0) {
			return;
		}
		CD--;
	}
	
	public Skill(SkillConfig config) {
		this.config = config;
	}
	
	public void initOwner(Combater owner) {
		this.owner = owner;
	}
	
	protected abstract void emit0(Combater defenser);
	
	public void emit(Combater defenser) {
		if(canEmit()) {
			emit0(defenser);
			setCD(config.CD);
		}
	}
	
	public void emitPassive(Combater defenser) {
		emit0(defenser);
	}
	
	public String getName() {
		return config.name;
	}
	
	public Combater getOwner() {
		return owner;
	}
	
	public void update() {
		decreaseCD();
	}
	
	public boolean canEmit() {
		if(config.emitType!=0) {
			System.out.println("被动技能");
			return false;
		}
		if(CD > 0) {
			System.out.println("技能正处于CD中");
			return false;
		}
		return true;
	}
	
	public int getType() {
		return config.skillType;
	}
	
	public int getEmitType() {
		return config.emitType;
	}
}
