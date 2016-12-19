package io.github.trinnorica.utils.levels;

import io.github.trinnorica.utils.sprites.SpriteType;

public enum LevelFactory {
	
	CLOUD('A',SpriteType.CLOUD),
	DIRT('B',SpriteType.DIRT),
	DIRT_ARCH_DOWN('C',SpriteType.DIRT_ARCH_DOWN),
	STONE('D',SpriteType.STONE),
	FLOOR('E',SpriteType.FLOOR),
	DYNAMIC_DIRT('F',SpriteType.DYNAMIC_DIRT),
	GRASS('G',SpriteType.GRASS),
	//ALT 9
	COIN('○',SpriteType.GOLD),
	//ALT 2
	TEST_ENTITY_AIR('☻',SpriteType.TEST_ENTITY),
	//ALT 1
	PLAYER('☺',SpriteType.PLAYER),
	
	
	GATE('K',SpriteType.GATE),
	LADDER('M',SpriteType.LADDER),
	AIR('X',SpriteType.AIR);
	
	
	SpriteType type;
	char c;
	
	LevelFactory(char c, SpriteType type){
		this.c = c;
		this.type = type;
	}
	
	public char getChar(){
		return c;
	}
	public SpriteType getSpriteType(){
		return type;
	}
	
	public static LevelFactory decode(char c){
		for(LevelFactory l : values()){
			if(l.c == c){
				return l;
			}
		}
		return AIR;
	}

	

}
