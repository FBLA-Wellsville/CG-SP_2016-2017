package io.github.trinnorica.utils.sprites;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.Enchantment;
import io.github.trinnorica.utils.EnchantmentEnum;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.ParticleFormat;

public class Tool extends Entity implements Moveable{
	
	protected int power = 5;
	protected int cooldown = 1;
	private Rectangle xbounds;
	private ToolType tooltype;
	protected Entity user = null;
	private List<Enchantment> enchantments = new ArrayList<>();
	

	public Tool(int x, int y, ToolType type) {
		super(x, y);
		this.tooltype = type;
		xbounds = new Rectangle(x, y, width, height+2);
		health = Integer.MAX_VALUE;
	}
	
	public void addEnchantment(EnchantmentEnum enchantment, int strength){
		enchantments.add(new Enchantment(enchantment, strength));
	}
	public List<Enchantment> getEnchantments(){
		return enchantments;
	}

	public void registerXBounds(){
		xbounds = new Rectangle((int)x, (int)y, width, height+2);
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
		use(x,y);
	}
	public void use(int x, int y, Direction d, ParticleFormat f, Entity shooter) {
		use(x,y);
		
	}
	
	public Rectangle getStrikeRange() {
		
		this.x = user.x;
		this.y = user.y;

		if (user.direction == Direction.LEFT) {
			return new Rectangle((int)x-30, (int)y, 45, 30);
		}
		if (user.direction == Direction.RIGHT) {
			return new Rectangle((int)x,(int) y, 45, 30);
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
