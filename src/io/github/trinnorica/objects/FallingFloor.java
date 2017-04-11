package io.github.trinnorica.objects;

import io.github.trinnorica.utils.sprites.Moveable;
import res.ExternalFile;

public class FallingFloor extends Collidable implements Moveable {
	
	private boolean falling = false;

	public FallingFloor(int x, int y) {
		super(x, y);
		loadImage(ExternalFile.loadTexture("objects/floor/floor.png"));
		setImageDimensions(30, 30);
	}
	
	public void a(){
		falling = true;
	}

	@Override
	public void move() {
		if(falling) y=y+1;
	}

}
