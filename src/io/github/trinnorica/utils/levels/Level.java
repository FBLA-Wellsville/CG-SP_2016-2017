package io.github.trinnorica.utils.levels;

import java.util.ArrayList;
import java.util.List;

import io.github.trinnorica.entity.Player;
import io.github.trinnorica.objects.Cloud;
import io.github.trinnorica.objects.Flag;
import io.github.trinnorica.objects.Floor;
import io.github.trinnorica.utils.sprites.Empty;
import io.github.trinnorica.utils.sprites.Sprite;
import io.github.trinnorica.utils.sprites.SpriteType;
import res.ExternalFile;

public class Level {
	
	List<Sprite> sprites = new ArrayList<>();

	int y = 0;
	int x = 0;
	public Level(char[] c, int width, int height) {
		
		for(int i=0;i!=c.length;i++){
			if(x>=width){
				x=0;
				y=y+1;
			}
			switch(LevelFactory.decode(c[i]).getSpriteType()){
			case CLOUD_BEGIN:
				sprites.add(new Cloud(x*30,y*30,SpriteType.CLOUD_BEGIN));
				break;
			case CLOUD_MIDDLE:
				sprites.add(new Cloud(x*30,y*30,SpriteType.CLOUD_MIDDLE));
				break;
			case CLOUD_END:
				sprites.add(new Cloud(x*30,y*30,SpriteType.CLOUD_END));
				break;
			case DIRT: 
				sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/dirt.png"),30,30));
				break;
			case DIRT_WALL_LEFT: 
				sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/dirt-wall-left.png"),30,30));
				break;
			case DIRT_WALL_RIGHT: 
				sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/dirt-wall-right.png"),30,30));
				break;
			case DIRT_ARCH_LEFT: 
				sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/dirt-arch-left.png"),30,30));
				break;
			case DIRT_ARCH_RIGHT: 
				sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/dirt-arch-right.png"),30,30));
				break;
			case DIRT_ARCH_MIDDLE: 
				sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/dirt-arch-middle.png"),30,30));
				break;
			case FLOOR: 
				sprites.add(new Floor(x*30,y*30));
				break;
			case GATE:
				if(LevelFactory.decode(c[i-width]).getSpriteType().equals(SpriteType.GATE)){
					sprites.add(new Flag(x*30,y*30,Flag.POLE));
				}
				else sprites.add(new Flag(x*30,y*30,Flag.FLAG));
				break;
				
			default: break;
			}
			sprites.add(new Empty(x*30,y*30));
			x=x+1;
		}
		sprites.add(new Player(0, 0));
	}

}
