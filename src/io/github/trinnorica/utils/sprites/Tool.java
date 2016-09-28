package io.github.trinnorica.utils.sprites;

import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.ParticleFormat;

public class Tool extends Sprite {
	
	protected int power = 5;
	protected int cooldown = 1;

	public Tool(int x, int y) {
		super(x, y);
	}

	
//	public void use() {
//		// TODO Auto-generated method stub
//		
//	}

	public void use(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	public void use(int x, int y, Velocity velocity, Entity shooter) {
		// TODO Auto-generated method stub
		
	}
	public void use(int x, int y, Direction d, ParticleFormat f) {
		// TODO Auto-generated method stub
		
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


	
	
	

}
