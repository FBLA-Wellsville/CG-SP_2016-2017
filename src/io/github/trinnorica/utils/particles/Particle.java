package io.github.trinnorica.utils.particles;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import io.github.trinnorica.Main;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.sprites.Moveable;
import io.github.trinnorica.utils.sprites.Sprite;
import res.ExternalFile;

public class Particle extends Sprite implements Moveable {
	
	ParticleType type;
	int lifetime;
	Velocity v;
	
	public Particle(Point p, ParticleType t, Velocity v) {
		super(p.x, p.y);
		type = t;
		init();
		this.v = v;
	}
	
	public void init(){
		lifetime = new Random().nextInt(100);
		loadImage(ExternalFile.loadTexture("particles/" + type.getString() + ".png"));
		setImageDimensions(15, 15);
	}
	
	public void draw(Graphics g){
		g.drawImage(getImage(), x, y, getWidth(), getHeight(), null);
		lifetime = lifetime-1;
	}

	public int getLifetime() {
		return lifetime;
	}

	@Override
	public void move() {
//		y=y-1;
		v.y = v.y + Main.gravity;
		v.x = v.x/2;
		x = (int) (x + v.x);
		y = (int) (y + v.y);
		
	}
	

	
	

}
