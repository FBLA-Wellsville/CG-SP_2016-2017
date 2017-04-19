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
	FALLING_FLOOR('H',SpriteType.FALLING_FLOOR),
	INVISIBLE_WALL('I',SpriteType.WALL),
	DARK_GRAY('J',SpriteType.DIRT),
	//For all doors, type Alt 100<door ID>
	
	DOOR_1('Θ',SpriteType.DOOR),
	DOOR_2('Ω',SpriteType.DOOR),
	DOOR_3('δ',SpriteType.DOOR),
	DOOR_4('∞',SpriteType.DOOR),
	//For all keys, type Alt 200<key ID>
	KEY_1('╤',SpriteType.KEY),
	KEY_2('╥',SpriteType.KEY),
	KEY_3('╙',SpriteType.KEY),
	KEY_4('╘',SpriteType.KEY),
	
	//For all switches, type Alt 300<switch ID>
	SWITCH_1('╣',SpriteType.SWITCH),
	SWITCH_2('║',SpriteType.SWITCH),
	SWITCH_3('╗',SpriteType.SWITCH),
	SWITCH_4('╝',SpriteType.SWITCH),
	//ALT 9
	COIN('○',SpriteType.GOLD),
	//ALT 2
	OGRE('☻',SpriteType.OGRE),
	//ALT 10
	KNIGHT('◙',SpriteType.KNIGHT),
	//ALT 11
	DARK_KNIGHT('♂',SpriteType.DARK_KNIGHT),
	//ALT 12
	WIZARD('♀',SpriteType.WIZARD),
	//ALT 13
	SKELETON('♪',SpriteType.SKELETON),
	//ALT 14
	SUPER_OGRE('♫',SpriteType.OGRE),
	//ALT 1
	PLAYER('☺',SpriteType.PLAYER),
	//ALT 4
	STONE_SWORD('♦',SpriteType.STONE_SWORD),
	//ALT 5
	DARK_SWORD('♣',SpriteType.DARK_SWORD),
	//ALT 6
	STICK('♠',SpriteType.STICK),
	//ALT 7
	BOW('•',SpriteType.BOW),
	
	
	//Alt 20
	IRON_ARMOUR('¶',SpriteType.ARMOUR),
	//Alt 21
	GOLD_ARMOUR('§',SpriteType.ARMOUR),
	
	GATE('K',SpriteType.GATE),
	CAVE('L',SpriteType.GATE),
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
