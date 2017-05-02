package io.github.trinnorica.utils.levels;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import io.github.trinnorica.entity.Enemy;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.entity.Player;
import io.github.trinnorica.objects.Cloud;
import io.github.trinnorica.objects.FallingFloor;
import io.github.trinnorica.objects.Flag;
import io.github.trinnorica.objects.Floor;
import io.github.trinnorica.objects.GoldCoin;
import io.github.trinnorica.objects.Ladder;
import io.github.trinnorica.objects.Switch;
import io.github.trinnorica.objects.Wall;
import io.github.trinnorica.objects.doors.Door;
import io.github.trinnorica.objects.tools.Armour;
import io.github.trinnorica.objects.tools.Bow;
import io.github.trinnorica.objects.tools.DarkSword;
import io.github.trinnorica.objects.tools.FireDagger;
import io.github.trinnorica.objects.tools.IceDagger;
import io.github.trinnorica.objects.tools.Key;
import io.github.trinnorica.objects.tools.Sword;
import io.github.trinnorica.utils.Images;
import io.github.trinnorica.utils.Rotation;
import io.github.trinnorica.utils.sprites.Empty;
import io.github.trinnorica.utils.sprites.EntityType;
import io.github.trinnorica.utils.sprites.Sprite;
import io.github.trinnorica.utils.sprites.SpriteType;
import io.github.trinnorica.utils.sprites.ToolType;
import res.ExternalFile;

public class Level {
	
	List<Sprite> sprites = new ArrayList<>();
	List<Entity> entities = new ArrayList<>();

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
				
			case ICE_DAGGER:
				sprites.add(new IceDagger(x*30, y*30, ToolType.DIRECTIONAL));
				break;
			case FIRE_DAGGER:
				sprites.add(new FireDagger(x*30, y*30, ToolType.DIRECTIONAL));
				break;
			case ARMOUR:
				switch(LevelFactory.decode(c[i])){
				case IRON_ARMOUR:
					sprites.add(new Armour(x*30, y*30, ToolType.NONE, Armour.IRON));
					break;
				case GOLD_ARMOUR:
					sprites.add(new Armour(x*30, y*30, ToolType.NONE, Armour.GOLD));
					break;
				}
				break;
			case GOLD:
				sprites.add(new GoldCoin(x*30+(15/2), y*30+(15/2)));
				break;
			case WALL:
				switch(LevelFactory.decode(c[i])){
				case INVISIBLE_WALL:
					sprites.add(new Wall(x*30, y*30));
					break;
				default:
					break;
				}
				break;
			case DOOR:
				switch(LevelFactory.decode(c[i])){
				case DOOR_1:
					sprites.add(new Door(x*30, y*30-15,1));
					break;
				case DOOR_2:
					sprites.add(new Door(x*30, y*30-15,2));
					break;
				case DOOR_3:
					sprites.add(new Door(x*30, y*30-15,3));
					break;
				case DOOR_4:
					sprites.add(new Door(x*30, y*30-15,4));
					break;
				default:
					break;
				}
				break;
			case KEY:
				switch(LevelFactory.decode(c[i])){
				case KEY_1:
					sprites.add(new Key(x*30, y*30,ToolType.NONE,1));
					break;
				case KEY_2:
					sprites.add(new Key(x*30, y*30,ToolType.NONE,2));
					break;
				case KEY_3:
					sprites.add(new Key(x*30, y*30,ToolType.NONE,3));
					break;
				case KEY_4:
					sprites.add(new Key(x*30, y*30,ToolType.NONE,4));
					break;
				default:
					break;
				}
				break;
			case SWITCH:
				switch(LevelFactory.decode(c[i])){
				case SWITCH_1:
					if(!LevelFactory.decode(c[i-1]).equals(LevelFactory.AIR)){
						sprites.add(new Switch(x*30,y*30+15/2,1,Rotation.LEFT));
						break;
					}
					if(!LevelFactory.decode(c[i+1]).equals(LevelFactory.AIR)){
						sprites.add(new Switch(x*30+15,y*30+15/2,1,Rotation.RIGHT));
						break;
					}
					if(!LevelFactory.decode(c[i+width]).equals(LevelFactory.AIR)){
						sprites.add(new Switch(x*30+15/2,y*30+15,1,Rotation.UP));
						break;
					}
					if(!LevelFactory.decode(c[i-width]).equals(LevelFactory.AIR)){
						sprites.add(new Switch(x*30+15/2,y*30,1,Rotation.DOWN));
						break;
					}
					break;
				case SWITCH_2:
					if(!LevelFactory.decode(c[i-1]).equals(LevelFactory.AIR)){
						sprites.add(new Switch(x*30,y*30+15/2,2,Rotation.LEFT));
						break;
					}
					if(!LevelFactory.decode(c[i+1]).equals(LevelFactory.AIR)){
						sprites.add(new Switch(x*30+15,y*30+15/2,2,Rotation.RIGHT));
						break;
					}
					if(!LevelFactory.decode(c[i+width]).equals(LevelFactory.AIR)){
						sprites.add(new Switch(x*30+15/2,y*30+15,2,Rotation.UP));
						break;
					}
					if(!LevelFactory.decode(c[i-width]).equals(LevelFactory.AIR)){
						sprites.add(new Switch(x*30+15/2,y*30,2,Rotation.DOWN));
						break;
					}
					break;
				case SWITCH_3:
					if(!LevelFactory.decode(c[i-1]).equals(LevelFactory.AIR)){
						sprites.add(new Switch(x*30,y*30+15/2,3,Rotation.LEFT));
						break;
					}
					if(!LevelFactory.decode(c[i+1]).equals(LevelFactory.AIR)){
						sprites.add(new Switch(x*30+15,y*30+15/2,3,Rotation.RIGHT));
						break;
					}
					if(!LevelFactory.decode(c[i+width]).equals(LevelFactory.AIR)){
						sprites.add(new Switch(x*30+15/2,y*30+15,3,Rotation.UP));
						break;
					}
					if(!LevelFactory.decode(c[i-width]).equals(LevelFactory.AIR)){
						sprites.add(new Switch(x*30+15/2,y*30,3,Rotation.DOWN));
						break;
					}
					break;
				case SWITCH_4:
					if(!LevelFactory.decode(c[i-1]).equals(LevelFactory.AIR)){
						sprites.add(new Switch(x*30,y*30+15/2,4,Rotation.LEFT));
						
						break;
					}
					if(!LevelFactory.decode(c[i+1]).equals(LevelFactory.AIR)){
						sprites.add(new Switch(x*30+15,y*30+15/2,4,Rotation.RIGHT));
						break;
					}
					if(!LevelFactory.decode(c[i+width]).equals(LevelFactory.AIR)){
						sprites.add(new Switch(x*30+15/2,y*30+15,4,Rotation.UP));
						break;
					}
					if(!LevelFactory.decode(c[i-width]).equals(LevelFactory.AIR)){
						sprites.add(new Switch(x*30+15/2,y*30,4,Rotation.DOWN));
						break;
					}
					break;
				default:
					break;
				}
				break;
			case PLAYER:
				entities.add(new Player(x*30,y*30));
//				Main.getPlayer().x = x*30;
//				Main.getPlayer().y = y*30;
				break;
			case OGRE:
				switch(LevelFactory.decode(c[i])){
				case OGRE:
					entities.add(new Enemy(x*30, y*30,EntityType.OGRE));
					break;
				case MEGA_OGRE:
					entities.add(new Enemy(x*30, y*30,EntityType.MEGA_OGRE));
					break;
				}
				break;
			case FALLING_FLOOR:
				sprites.add(new FallingFloor(x*30, y*30));
				break;
			case KNIGHT:
				entities.add(new Enemy(x*30, y*30, EntityType.KNIGHT));
				break;
			case DARK_KNIGHT:
				entities.add(new Enemy(x*30, y*30, EntityType.DARK_KNIGHT));
				break;
			case WIZARD:
				entities.add(new Enemy(x*30, y*30, EntityType.WIZARD));
				break;
			case SKELETON:
				entities.add(new Enemy(x*30, y*30, EntityType.SKELETON));
				break;
			case STONE_SWORD:
				entities.add(new Sword(x*30, y*30,ToolType.MELEE));
				break;
			case DARK_SWORD:
				entities.add(new DarkSword(x*30, y*30,ToolType.MELEE));
				break;
			case BOW:
				entities.add(new Bow(x*30, y*30,ToolType.PROJECTILE));
				break;
				
			case CASTLE_BLOCK:
				sprites.add(new Sprite(x*30, y*30, ExternalFile.loadTexture("objects/background/gray-brick.png"), 30, 30));
				break;
			case CASTLE_BLOCK_FLOOR:
				sprites.add(new Floor(x*30, y*30, Floor.CASTLE_FLOOR));
				break;
			case CASTLE_BLOCK_BACKGROUND:
				sprites.add(new Sprite(x*30, y*30, ExternalFile.loadTexture("objects/background/gray-brick-background.png"), 30, 30));
				break;
			case EVIL_FLAG:
				sprites.add(new Sprite(x*30, y*30, ExternalFile.loadTexture("objects/background/evil-flag.png"), 30, 30));
				break;
			case CASTLE_BLOCK_VINES:
				sprites.add(new Ladder(x*30, y*30, Ladder.VINE));
				break;
		
			case DIRT:
				if(LevelFactory.decode(c[i]).equals(LevelFactory.DARK_GRAY)){
					sprites.add(new Sprite(x*30,y*30,Images.createColorImage(Color.DARK_GRAY),30,30));
				} else 
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
				if(LevelFactory.decode(c[i]).equals(LevelFactory.CAVE)){
					sprites.add(new Flag(x*30,y*30,Flag.CAVE));
				}
				if(LevelFactory.decode(c[i]).equals(LevelFactory.GATE)){
					try{
						if(LevelFactory.decode(c[i-width]).getSpriteType().equals(SpriteType.GATE)){
							sprites.add(new Flag(x*30,y*30,Flag.POLE));
						}
						else sprites.add(new Flag(x*30,y*30,Flag.FLAG));
					} catch(ArrayIndexOutOfBoundsException ex){
						sprites.add(new Flag(x*30,y*30,Flag.FLAG));
					}
				}
				
				
				break;
			case LADDER:
				sprites.add(new Ladder(x*30,y*30, Ladder.LADDER));
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
