package io.github.trinnorica.objects;

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
		setImageDimensions(30, 30);
	}
	
	public int getFloorType(){
		return type;
	}

}
