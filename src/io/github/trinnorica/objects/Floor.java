package io.github.trinnorica.objects;

import res.ExternalFile;

public class Floor extends Collidable {

	public Floor(int x, int y) {
		super(x, y);
		init();
	}

	private void init() {
		loadImage(ExternalFile.loadTexture("objects/floor/floor.png"));
		setImageDimensions(30, 7);
	}

}
