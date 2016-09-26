package io.github.trinnorica.utils.levels;

import io.github.trinnorica.objects.Cloud;
import io.github.trinnorica.objects.Floor;
import io.github.trinnorica.utils.sprites.Empty;
import io.github.trinnorica.utils.sprites.Sprite;
import io.github.trinnorica.utils.sprites.SpriteType;
import res.ExternalFile;

public enum LevelFactory {
	
	A('A',SpriteType.CLOUD_BEGIN),
	B('B',SpriteType.CLOUD_MIDDLE),
	C('C',SpriteType.CLOUD_END),
	D('D',SpriteType.DIRT),
	E('E',SpriteType.DIRT_WALL_LEFT),
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
