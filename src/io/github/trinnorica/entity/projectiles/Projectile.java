package io.github.trinnorica.entity.projectiles;

import java.awt.Graphics;

import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.utils.Moveable;
import io.github.trinnorica.utils.Velocity;
import res.ExternalFile;

public class Projectile extends Entity implements Moveable{
	
	Velocity vector;

	public Projectile(int x, int y, Velocity vec) {
		super(x, y);
		vector = vec;
	}
	
	@Override
	public void move(){
		x=(int) (x+vector.x);
		y=(int) (y+vector.y);
		
	}
	
	public void updateVelocity(Velocity velocity){
		vector = velocity;
	}
	
	@Override
	public void draw(Graphics g){
		if(vector.x > 0){
			g.drawImage(getImage(), x, y, width, height, null);
			
		} else {
			g.drawImage(getImage(), x+getWidth(), y, - getWidth(), getHeight(), null);
		}
	}
	

}
