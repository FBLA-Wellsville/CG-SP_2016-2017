package io.github.trinnorica.objects;

import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.sprites.PartialCollidable;
import res.ExternalFile;

public class Floor extends PartialCollidable {

	public static final int DIRT = 0;
	public static final int STONE = 1;
	public static final int STONE_DIRT = 2;
	public static final int GRASS = 3;
	public static final int DIRT_BACKGROUND = 4;
	public static final int DIRT_WALL_RIGHT = 5;
	public static final int DIRT_WALL_LEFT = 6;
	public static final int DIRT_WALL_BOTH = 7;
	
	private int type;
	
	public Floor(int x, int y, int type) {
		super(x, y);
		this.type = type;
		init(type);
	}

	private void init(int type) {
		loadImage(ExternalFile.loadTexture("objects/floor/floor-" + type + ".png"));
		switch(type){
		case DIRT:
			addCollidableDirection(Direction.DOWN);
			break;
		case STONE:
			addCollidableDirection(Direction.DOWN);
			break;
		case STONE_DIRT:
			addCollidableDirection(Direction.DOWN);
			break;
		case GRASS:
			addCollidableDirection(Direction.DOWN);
			break;
		case DIRT_BACKGROUND:
			addCollidableDirection(Direction.DOWN);
			addCollidableDirection(Direction.LEFT);
			addCollidableDirection(Direction.RIGHT);
			break;
		case DIRT_WALL_RIGHT:
			addCollidableDirection(Direction.RIGHT);
			addCollidableDirection(Direction.DOWN);
			break;
		case DIRT_WALL_LEFT:
			addCollidableDirection(Direction.LEFT);
			addCollidableDirection(Direction.DOWN);
			break;
		case DIRT_WALL_BOTH:
			addCollidableDirection(Direction.DOWN);
			addCollidableDirection(Direction.RIGHT);
			addCollidableDirection(Direction.LEFT);
			break;
		
		}
		setImageDimensions(30, 30);
	}
	
	public int getFloorType(){
		return type;
	}

}
