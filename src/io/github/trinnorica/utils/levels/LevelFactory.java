package io.github.trinnorica.utils.levels;

import io.github.trinnorica.utils.sprites.SpriteType;

public enum LevelFactory {
	
	A('A',SpriteType.CLOUD),
	B('B',SpriteType.DIRT),
	C('C',SpriteType.DIRT_WALL_LEFT),
	F('F',SpriteType.DIRT_WALL_RIGHT),
	G('G',SpriteType.DIRT_ARCH_LEFT),
	H('H',SpriteType.DIRT_ARCH_RIGHT),
	I('I',SpriteType.DIRT_ARCH_MIDDLE),
	J('J',SpriteType.FLOOR),
	K('K',SpriteType.GATE),
	X('X',SpriteType.AIR);
	
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
		return X;
	}

	

}
