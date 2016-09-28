package io.github.trinnorica.entity.projectiles;

import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.sprites.Projectile;
import res.ExternalFile;

public class Arrow extends Projectile {

	public Arrow(int x, int y, Velocity vec, Entity shooter) {
		super(x, y, vec, shooter);
		init();
	}
	
	public void init(){
		loadImage(ExternalFile.loadTexture("entity/projectiles/arrow.png"));
		setImageDimensions(30, 30);
	}
}
