package io.github.trinnorica.utils.levels;

import java.util.ArrayList;
import java.util.List;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Enemy;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.entity.Player;
import io.github.trinnorica.objects.Cloud;
import io.github.trinnorica.objects.Flag;
import io.github.trinnorica.objects.Floor;
import io.github.trinnorica.objects.GoldCoin;
import io.github.trinnorica.objects.Ladder;
import io.github.trinnorica.objects.tools.Sword;
import io.github.trinnorica.utils.sprites.Empty;
import io.github.trinnorica.utils.sprites.EntityType;
import io.github.trinnorica.utils.sprites.Sprite;
import io.github.trinnorica.utils.sprites.SpriteType;
import io.github.trinnorica.utils.sprites.ToolType;
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
			case CLOUD:
				try{
					if(LevelFactory.decode(c[i-1]).getSpriteType().equals(SpriteType.CLOUD)){
						if(!LevelFactory.decode(c[i+1]).getSpriteType().equals(SpriteType.CLOUD))
							sprites.add(new Cloud(x*30,y*30,Cloud.END));
						else sprites.add(new Cloud(x*30,y*30,Cloud.MIDDLE));
					}
					else sprites.add(new Cloud(x*30,y*30,Cloud.BEGIN));
				} catch (ArrayIndexOutOfBoundsException ex){
					sprites.add(new Cloud(x*30,y*30,Cloud.BEGIN));
				}
				
		
				break;
			case GOLD:
				sprites.add(new GoldCoin(x*30+(15/2), y*30+(15/2)));
				break;
			case PLAYER:
				sprites.add(new Player(x*30,y*30));
//				Main.getPlayer().x = x*30;
//				Main.getPlayer().y = y*30;
				break;
			case OGRE:
				sprites.add(new Enemy(x*30, y*30,EntityType.OGRE));
				break;
			case KNIGHT:
				sprites.add(new Enemy(x*30, y*20, EntityType.KNIGHT));
				break;
			case DARK_KNIGHT:
				sprites.add(new Enemy(x*30, y*20, EntityType.DARK_KNIGHT));
				break;
			case WIZARD:
				sprites.add(new Enemy(x*30, y*20, EntityType.WIZARD));
				break;
			case STONE_SWORD:
				sprites.add(new Sword(x*30, y*30,ToolType.MELEE));
				break;
			case DIRT:
				sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/dirt.png"),30,30));
				break;
			case DIRT_ARCH_DOWN:
				sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/dirt-arch-middle.png"),30,30));
				
				break;
			case DYNAMIC_DIRT:
				try{
					if(LevelFactory.decode(c[i-1]).getSpriteType().equals(SpriteType.DIRT_ARCH_DOWN)){
						if(LevelFactory.decode(c[i+width]).getSpriteType().equals(SpriteType.DIRT) || LevelFactory.decode(c[i+width]).getSpriteType().equals(SpriteType.DYNAMIC_DIRT)){
							sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/dirt-arch-right.png"), 30, 30));
							break;
						}
					}
					if(LevelFactory.decode(c[i+1]).getSpriteType().equals(SpriteType.DIRT_ARCH_DOWN)){
						if(LevelFactory.decode(c[i+width]).getSpriteType().equals(SpriteType.DIRT) || LevelFactory.decode(c[i+width]).getSpriteType().equals(SpriteType.DYNAMIC_DIRT)){
							sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/dirt-arch-left.png"), 30, 30));
							break;
						}
					}
					if(!LevelFactory.decode(c[i-1]).getSpriteType().equals(SpriteType.DIRT)){
						if(!LevelFactory.decode(c[i-1]).getSpriteType().equals(SpriteType.FLOOR)){
							if(!(x*30-40 <= 0)) sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/dirt-wall-right.png"), 30, 30));
							else sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/dirt.png"), 30, 30));
						} else {
							sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/dirt.png"), 30, 30));
						}
						break;
					}
					if(!LevelFactory.decode(c[i+1]).getSpriteType().equals(SpriteType.DIRT)){
						if(!LevelFactory.decode(c[i+1]).getSpriteType().equals(SpriteType.FLOOR)){
							if(!(x*30-40 <= 0)) sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/dirt-wall-left.png"), 30, 30));
							else sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/dirt.png"), 30, 30));
						} else {
							sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/dirt.png"), 30, 30));
						}
						break;
					}		
					sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/dirt.png"), 30, 30));
			
				} catch(IndexOutOfBoundsException ex){
					sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/dirt.png"), 30, 30));
				}
			
			case FLOOR:
				
				try{
					
					if(LevelFactory.decode(c[i-width]).getSpriteType().equals(SpriteType.FLOOR)){
						sprites.add(new Floor(x*30,y*30,Floor.DIRT_BACKGROUND));
						break;
					}
					
					if(LevelFactory.decode(c[i+width+1]).getSpriteType().equals(SpriteType.FLOOR) && LevelFactory.decode(c[i+width-1]).getSpriteType().equals(SpriteType.FLOOR)){
						sprites.add(new Floor(x*30,y*30,Floor.DIRT_WALL_BOTH));
						break;
						
					}
					
					
					if(LevelFactory.decode(c[i+width+1]).getSpriteType().equals(SpriteType.FLOOR)){
						sprites.add(new Floor(x*30,y*30,Floor.DIRT_WALL_LEFT));
						break;
						
					}
					
					if(LevelFactory.decode(c[i+width-1]).getSpriteType().equals(SpriteType.FLOOR)){
						sprites.add(new Floor(x*30,y*30,Floor.DIRT_WALL_RIGHT));
						break;
						
					}
					
					if(LevelFactory.decode(c[i+width]).getSpriteType().equals(SpriteType.STONE)){
						if(LevelFactory.decode(c[i-1]).getSpriteType().equals(SpriteType.STONE) || LevelFactory.decode(c[i+1]).getSpriteType().equals(SpriteType.STONE)){
							sprites.add(new Floor(x*30,y*30,Floor.STONE));
						} else {
							sprites.add(new Floor(x*30,y*30, Floor.STONE_DIRT));
						}
					} else {
						sprites.add(new Floor(x*30,y*30,Floor.DIRT));
					}
				} catch(IndexOutOfBoundsException ex){
					sprites.add(new Floor(x*30,y*30,Floor.DIRT));
				}
				
				break;
			case GATE:
				try{
					if(LevelFactory.decode(c[i-width]).getSpriteType().equals(SpriteType.GATE)){
						sprites.add(new Flag(x*30,y*30,Flag.POLE));
					}
					else sprites.add(new Flag(x*30,y*30,Flag.FLAG));
				} catch(ArrayIndexOutOfBoundsException ex){
					sprites.add(new Flag(x*30,y*30,Flag.FLAG));
				}
				
				break;
			case LADDER:
				sprites.add(new Ladder(x*30,y*30));
				break;
			case STONE:
				try{
					if(LevelFactory.decode(c[i-width]).getSpriteType().equals(SpriteType.DIRT))
						sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/stone-dirt-down.png"), 30, 30));
					else sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/stone.png"), 30, 30));
					break;
				} catch(ArrayIndexOutOfBoundsException ex){
					sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/stone.png"), 30, 30));
				}
				
			case GRASS:
				sprites.add(new Sprite(x*30,y*30,ExternalFile.loadTexture("objects/background/grass.png"), 30, 30));
			default: break;
			}
			sprites.add(new Empty(x*30,y*30));
			x=x+1;
		}
	}

}
