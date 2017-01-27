package io.github.trinnorica.utils.sprites;

import java.awt.Graphics;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Enemy;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.entity.Player;
import io.github.trinnorica.utils.DamageReason;
import io.github.trinnorica.utils.Images;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.Particle;

public class Projectile extends Entity implements Moveable{
	
	protected Velocity vector;
	protected Entity shooter;
	protected int power = 10;

	public Projectile(int x, int y, Velocity vec, Entity shooter) {
		super(x, y);
		vector = vec;
		this.shooter = shooter;
	}
	
	@Override
	public void move(){
		x=(int) (x+vector.x);
		y=(int) (y+vector.y);
		vector.y = vector.y+Main.gravity;
		vector.x = vector.x-Main.wind;
		
		for(Sprite s : Main.getScreen().objects){
			if(!bounds.intersects(s.getPolygon().getBounds())) continue;
			if(s instanceof Projectile || s instanceof Particle) continue;
			if(shooter instanceof Player && s instanceof Player) continue;
			if(shooter instanceof Enemy && s instanceof Enemy) continue;
				
			
			if(s instanceof Entity)
				((Entity)s).damage(power,DamageReason.PROJECTILE, this, new Velocity(vector.x/3,-3));
					
				
			
			Main.removeSprite(this);
			
		}
		
	}
	
	public Entity getShooter(){
		return shooter;
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
