package io.github.trinnorica.utils.sprites;

public class Collidable extends Sprite {
	
	private boolean colliding = true;

	public Collidable(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isColliding(){
		return colliding;
	}
	
	public boolean toggleColliding(){
		colliding = !colliding;
		return colliding;
	}
	public void setColliding(boolean collides){
		colliding = collides;
	}

}
