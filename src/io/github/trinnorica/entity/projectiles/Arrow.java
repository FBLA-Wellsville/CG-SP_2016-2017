package io.github.trinnorica.entity.projectiles;

import java.awt.Graphics;

import io.github.trinnorica.utils.Images;
import io.github.trinnorica.utils.Velocity;
import res.ExternalFile;

public class Arrow extends Projectile {

	public Arrow(int x, int y, Velocity vec) {
		super(x, y, vec);
		init();
	}
	
	public void init(){
		loadImage(ExternalFile.loadTexture("entity/projectiles/arrow.png"));
		setImageDimensions(30, 30);
	}
	
	
	
	

}
