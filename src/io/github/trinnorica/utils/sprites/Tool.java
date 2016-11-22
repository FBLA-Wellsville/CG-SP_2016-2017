package io.github.trinnorica.utils.sprites;

import java.awt.Rectangle;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.objects.Collidable;
import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.ParticleFormat;

public class Tool extends Entity implements Moveable{
	
	protected int power = 5;
	protected int cooldown = 1;
	private Rectangle xbounds;

	public Tool(int x, int y) {
		super(x, y);
		xbounds = new Rectangle(x, y, width, height+2);
	}

	public void registerXBounds(){
		xbounds = new Rectangle(x, y, width, height+2);
	}
	

	public void use(int x, int y) {
		//Different in each tool class
		
	}
	public void use(int x, int y, Velocity velocity, Entity shooter) {
		//Different in each tool class
		
	}
	public void use(int x, int y, Direction d, ParticleFormat f) {
		//Different in each tool class
		
	}
	
	public int getPower(){
		return power;
	}
	public void setPower(int power){
		this.power = power;
	}
	public int getCooldown(){
		return cooldown;
	}



	@Override
	public void move() {
		
		registerXBounds();
		x=(int) (x+velocity.x);
		y=(int) (y+velocity.y);
		velocity.y = velocity.y+Main.gravity;
		velocity.x = velocity.x-Main.wind;
		
		for(Sprite s : Main.getScreen().objects){
			if(!xbounds.intersects(s.getPolygon().getBounds())) continue;
					
			if(s instanceof Collidable){
				velocity.x=0;
				velocity.y=0;
				y = s.y-height;
				
			}
			
			
			
		}
		
	}


	
	
	

}
