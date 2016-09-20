package io.github.trinnorica.utils;

import java.awt.Graphics;

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

	public void use(int x, int y, Velocity velocity) {
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
