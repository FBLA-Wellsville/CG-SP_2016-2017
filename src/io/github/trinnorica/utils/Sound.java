package io.github.trinnorica.utils;

import java.util.Random;

public enum Sound {
	
	
	BUTTON_CLICK("button_click.wav"),
	BOW_SHOOT("bow_shoot.wav"),
	JUMP("jump_1.wav:jump_2.wav"),
	SCORE("score.wav"),
	WIN("win.wav"),
	LEVELUP("win.wav"),
	TOOL("levelup.wav"),
	TEST("test.wav"), 
	BACKGROUND_CAVE("background_cave_1.wav"),
	BACKGROUND_BOSS("background_boss_1.wav"),
	BACKGROUND_GRASS("background_grass_1.wav:background_grass_2.wav"), 
	BACKGROUND_MENU("background_menu.wav"), 
	BACKGROUND_CREDITS("background_credits.wav"), 
	BACKGROUND_HELL("background_menu.wav");
	
	String sound;
	
	Sound(String sound){
		this.sound = sound;
	}
	
	public Sound getSound(){
		return this;
	}
	public String getSoundString(){
		if(sound.contains(":")){

			String[] i = sound.split(":");
			return i[new Random().nextInt(i.length)];
		
		}
		return sound;
	}
	
	public SoundType getSoundType(){
		switch(this){
		case BUTTON_CLICK:
			return SoundType.OTHER;
		case BOW_SHOOT:
			return SoundType.OTHER;
		case JUMP:
			return SoundType.OTHER;
		case SCORE:
			return SoundType.OTHER;
		case WIN:
			return SoundType.OTHER;
		case LEVELUP:
			return SoundType.OTHER;
		case BACKGROUND_CAVE:
			return SoundType.BACKGROUND;
		case BACKGROUND_BOSS:
			return SoundType.BACKGROUND;
		case BACKGROUND_GRASS:
			return SoundType.BACKGROUND;
		case BACKGROUND_MENU:
			return SoundType.BACKGROUND;
		case BACKGROUND_CREDITS:
			return SoundType.BACKGROUND;
		default:
			return SoundType.OTHER;
			
		}
		
	}

//	public static Sound levelBackgroundMusic(LevelType levelType) {
//		switch(levelType){
//		case BOSS:
//			return BACKGROUND_BOSS;
//		case GRASS:
//			return BACKGROUND_GRASS;
//		case CAVE:
//			return BACKGROUND_CAVE;
//		default:
//			return Sound.BACKGROUND_GRASS;
//		}
//	}

}
