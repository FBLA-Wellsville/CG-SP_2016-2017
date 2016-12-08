package io.github.trinnorica.utils.levels;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Player;
import io.github.trinnorica.utils.sprites.Sprite;

public class LevelBuilder {
	
	public Level buildLevel(char[] c, int width, int height){
		Main.clearObjects();
		Level l =  new Level(c,width,height);
		for(Sprite s : l.sprites){
			if(!(s instanceof Player))Main.addSprite(s);
		}
		for(Sprite s : l.entities){
			if(!(s instanceof Player))Main.addSprite(s);
		}
		
		Main.addSprite(Main.getPlayer());
		
		return l;
	}

}
