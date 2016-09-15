package io.github.trinnorica.utils;

public enum Direction {
	LEFT("left"),
	RIGHT("right"),
	NONE("none"),
	DOWN("down"),
	UP("up");
	
	String direction;
	
	Direction(String direction) {
		this.direction = direction;
	}
	
	public double getAngle(){
		if(this.equals(Direction.LEFT)) return 180;
		if(this.equals(Direction.RIGHT)) return 0;
		if(this.equals(Direction.UP)) return 270;
		if(this.equals(Direction.DOWN)) return 90;
		return 0;
	}
	

}
