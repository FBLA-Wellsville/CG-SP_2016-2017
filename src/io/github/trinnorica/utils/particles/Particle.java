package io.github.trinnorica.utils.particles;

import java.awt.Graphics;
import java.awt.Image;
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
	boolean g = false;
	
	public Particle(Point p, ParticleType t, Velocity v, boolean gravity) {
		super(p.x, p.y);
		type = t;
		g = gravity;
		init();
		this.v = v;
		lifetime = new Random().nextInt(100);
	}
	public Particle(Point p, ParticleType t, Velocity v, boolean gravity,int lifetime) {
		super(p.x, p.y);
		type = t;
		g = gravity;
		init();
		this.v = v;
		this.lifetime = new Random().nextInt(100)+lifetime;
	}
	
	public void init(){
		Image image;
		if(type.getAnimation() == true){
			image = ExternalFile.loadTexture("particles/" + type.getString() + ".gif");
		} else {
			image = ExternalFile.loadTexture("particles/" + type.getString() + ".png");
		}
		
		
		loadImage(image);
		setImageDimensions(image.getWidth(null), image.getHeight(null));
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
		if(g)v.y = v.y + Main.gravity;
		if(g) v.x = v.x *0.6;
		x = (int) (x + v.x);
		y = (int) (y + v.y);
		
	}
	

	
	

}
