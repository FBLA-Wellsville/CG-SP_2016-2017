package io.github.trinnorica.utils;

import io.github.trinnorica.Main;

public class LevelBuilder {
	
	public Level buildLevel(char[] c, int width, int height){
		Level l =  new Level(c,width,height);
		for(Sprite s : l.sprites){
			Main.addSprite(s);
		}
		return l;
	}

}
