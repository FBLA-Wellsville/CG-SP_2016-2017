package io.github.trinnorica.utils.levels;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Player;
import io.github.trinnorica.utils.sprites.Sprite;

public class LevelBuilder {
	
	public Level buildLevel(char[] c, int width, int height){
		Main.clearObjects();
		Player player = null;
		Level l =  new Level(c,width,height);
		for(Sprite s : l.sprites){
			if(!(s instanceof Player))Main.addSprite(s);
			else player = (Player) s;
		}
		
		if(player == null){
			player = new Player(1,1);
		}
		Main.setPlayer(player);
		return l;
	}

}
