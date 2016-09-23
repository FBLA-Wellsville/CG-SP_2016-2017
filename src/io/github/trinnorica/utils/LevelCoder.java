package io.github.trinnorica.utils;

import io.github.trinnorica.objects.Cloud;
import io.github.trinnorica.objects.Floor;

public enum LevelCoder {
	
	A('A',SpriteType.CLOUD_BEGIN),
	B('B',SpriteType.CLOUD_MIDDLE),
	C('C',SpriteType.CLOUD_END),
	X('X',SpriteType.AIR);
	
	SpriteType type;
	char c;
	
	LevelCoder(char c, SpriteType type){
		this.c = c;
		this.type = type;
	}
	
	public char getChar(){
		return c;
	}
	public SpriteType getSpriteType(){
		return type;
	}
	
	public static LevelCoder decode(char c){
		for(LevelCoder l : values()){
			if(l.c == c){
				return l;
			}
		}
		System.out.println("test");
		return X;
	}

	public Sprite createSprite(int x, int y) {
		switch(type){
		case CLOUD_BEGIN:
			return new Cloud(x,y,SpriteType.CLOUD_BEGIN);
		case CLOUD_MIDDLE:
			return new Cloud(x,y,SpriteType.CLOUD_MIDDLE);
		case CLOUD_END:
			return new Cloud(x,y,SpriteType.CLOUD_END);
		default: break;
		}
		return new Sprite(x,y);
	}

}
