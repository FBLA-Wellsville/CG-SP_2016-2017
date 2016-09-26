package io.github.trinnorica.entity.projectiles;

import java.awt.Graphics;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.utils.Images;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.sprites.Moveable;

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
		vector.y = vector.y+Main.gravity;
		vector.x = vector.x-Main.wind;
		
	}
	
	public void updateVelocity(Velocity velocity){
		vector = velocity;
	}
	
	@Override
	public void draw(Graphics g){
		if(vector.x > 0){
			g.drawImage(Images.rotate(Images.rotate(getImage(), 45), Math.toDegrees(Math.atan(vector.y/vector.x))), x, y, width, height, null);
//			g.drawImage(Images.rotate(Images.rotate(getImage(), 45), Math.toDegrees(Math.atan(vector.y/vector.x))), x, y, getWidth(), getHeight(), null);
			
		} else {
			g.drawImage(Images.rotate(Images.rotate(getImage(), 45), -Math.toDegrees(Math.atan(vector.y/vector.x))), x+getWidth(), y, - getWidth(), getHeight(), null);
		}
	}
	

}
