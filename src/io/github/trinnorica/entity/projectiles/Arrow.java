package io.github.trinnorica.entity.projectiles;

import io.github.trinnorica.utils.Velocity;
import res.ExternalFile;

public class Arrow extends Projectile {

	public Arrow(int x, int y, Velocity vec) {
		super(x, y, vec);
		init();
	}
	
	public void init(){
		loadImage(ExternalFile.loadTexture("entity/projectiles/arrow.gif"));
		setImageDimensions(30, 30);
	}
	
	

}
