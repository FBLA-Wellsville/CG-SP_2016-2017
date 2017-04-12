package io.github.trinnorica.utils.sprites;

import java.awt.Rectangle;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.ParticleFormat;

public class Tool extends Entity implements Moveable{
	
	protected int power = 5;
	protected int cooldown = 1;
	private Rectangle xbounds;
	private ToolType tooltype;
	protected Entity user = null;

	public Tool(int x, int y, ToolType type) {
		super(x, y);
		this.tooltype = type;
		xbounds = new Rectangle(x, y, width, height+2);
		health = Integer.MAX_VALUE;
	}

	public void registerXBounds(){
		xbounds = new Rectangle(x, y, width, height+2);
	}
	
	public Entity getUser(){
		return user;
	}
	public void setUser(Entity user){
		this.user = user;
	}

	public void use(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void use(int x, int y, Velocity velocity, Entity shooter) {
		this.x = x;
		this.y = y;
	}
	public void use(int x, int y, Direction d, ParticleFormat f, Entity shooter) {
		this.x = x;
		this.y = y;
	}
	
	public Rectangle getStrikeRange() {

		if (user.direction == Direction.LEFT) {
			return new Rectangle(x-30, y, 60, 30);
		}
		if (user.direction == Direction.RIGHT) {
			return new Rectangle(x, y, 60, 30);
		}
		return null;
	}
	
	public ToolType getToolType(){
		return tooltype;
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
					
			if(s instanceof PartialCollidable){
				velocity.x=0;
				velocity.y=0;
				y = s.y-height;
				
			}
			
			
			
		}
		
	}


	
	
	

}
