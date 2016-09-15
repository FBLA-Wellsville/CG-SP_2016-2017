package io.github.trinnorica.utils;

public enum SpriteType {
	
	FLOOR,
	FALLING_FLOOR,
	COMPETITOR,
	GATE,
	PLAYER,
	LADDER,
	WALL,
	GOLD,
	ARROW,
	BOW,
	NINJA_CLOAK,
	FALLING_WALL,
	SWITCH,
	TRIGGERED_SWITCH,
	KEY,
	DOOR,
	OPEN_DOOR,
	SPIKE, 
	BOSS,
	BOOTS, BOX;
	
	SpriteType() {
		
	}
	
	public SpriteSubType getSubType(){
		if(this == FLOOR) return SpriteSubType.PARTIAL_COLLIDEABLE;
		if(this == FALLING_FLOOR) return SpriteSubType.PARTIAL_COLLIDEABLE;
		if(this == COMPETITOR) return SpriteSubType.ENEMY;
		if(this == BOSS) return SpriteSubType.ENEMY;
		if(this == SPIKE) return SpriteSubType.BAD_THINGS;
		if(this == GATE) return SpriteSubType.NON_COLLIDEABLE;
		if(this == LADDER) return SpriteSubType.CLIMABLE;
		if(this == WALL) return SpriteSubType.COLLIDEABLE;
		if(this == GOLD) return SpriteSubType.MONEY;
		if(this == ARROW) return SpriteSubType.PROJECTILE;
		if(this == BOW) return SpriteSubType.WEAPON;
		if(this == NINJA_CLOAK) return SpriteSubType.TOOL;
		if(this == BOOTS) return SpriteSubType.TOOL;
		if(this == KEY) return SpriteSubType.TOOL;
		if(this == DOOR) return SpriteSubType.INTERACTABLE;
		if(this == OPEN_DOOR) return SpriteSubType.PARTIAL_COLLIDEABLE;
		if(this == SWITCH) return SpriteSubType.INTERACTABLE;
		if(this == TRIGGERED_SWITCH) return SpriteSubType.INTERACTABLE;
		if(this == FALLING_WALL) return SpriteSubType.COLLIDEABLE;
		if(this == BOX) return SpriteSubType.COLLIDEABLE;
		else return null;
	}
}