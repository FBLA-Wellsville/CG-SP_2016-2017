package io.github.trinnorica.utils;

import java.util.ArrayList;
import java.util.List;

import io.github.trinnorica.entity.Player;

public class Level {
	
	List<Sprite> sprites = new ArrayList<>();

	int y = 0;
	int x = 0;
	public Level(char[] c, int width, int height) {
		
		for(int i=0;i!=c.length;i++){
			if(x>=width){
				System.out.println("X: " + x + "\nWidth: " + width);
				x=0;
				y=y+1;
			}
			sprites.add(LevelCoder.decode(c[i]).createSprite(x*30,y*30));
			x=x+1;
		}
		sprites.add(new Player(0, 0));
	}

}
