package io.github.trinnorica.utils;

public enum SoundType {
	OTHER(Sound.SCORE,Sound.JUMP,Sound.BOW_SHOOT,Sound.BUTTON_CLICK,Sound.LEVELUP,Sound.TOOL,Sound.WIN),
	BACKGROUND(Sound.BACKGROUND_BOSS,Sound.BACKGROUND_CAVE,Sound.BACKGROUND_GRASS,Sound.BACKGROUND_CREDITS,Sound.BACKGROUND_MENU);
	
	Sound[] sounds;
	
	SoundType(Sound... sound){
		sounds=sound;
	}
	

}
