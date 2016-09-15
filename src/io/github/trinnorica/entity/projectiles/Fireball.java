package io.github.trinnorica.entity.projectiles;

import io.github.trinnorica.utils.Velocity;
import res.ExternalFile;

public class Fireball extends Projectile {

	public Fireball(int x, int y, Velocity vec) {
		super(x, y, vec);
		init();
	}
	
	public void init(){
		loadImage(ExternalFile.loadTexture("entity/projectiles/fireball.gif"));
		setImageDimensions(30, 30);
	}
	
	

}
