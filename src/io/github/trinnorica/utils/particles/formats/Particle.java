package io.github.trinnorica.utils.particles.formats;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import io.github.trinnorica.utils.Sprite;
import io.github.trinnorica.utils.particles.ParticleType;
import res.ExternalFile;

public class Particle extends Sprite {
	
	ParticleType type;
	int lifetime;
	
	public Particle(Point p, ParticleType t) {
		super(p.x, p.y);
		type = t;
		init();
	}
	
	public void init(){
		lifetime = new Random().nextInt(100);
		loadImage(ExternalFile.loadTexture("particles/ice.png"));
		setImageDimensions(15, 15);
	}
	
	public void draw(Graphics g){
		g.drawImage(getImage(), x, y, getWidth(), getHeight(), null);
		lifetime = lifetime-1;
	}

	public int getLifetime() {
		return lifetime;
	}
	

	
	

}
