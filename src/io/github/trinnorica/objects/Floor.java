package io.github.trinnorica.objects;

import res.ExternalFile;

public class Floor extends Collidable {

	public static final int DIRT = 0;
	public static final int STONE = 1;
	public static final int STONE_DIRT = 2;
	public static final int GRASS = 3;
	
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
