package io.github.trinnorica.utils;

public enum Rotation {
	
	LEFT(90),
	RIGHT(270),
	UP(0),
	DOWN(180);
	
	double angle;
	
	Rotation(double angle){
		this.angle = angle;
	}
	
	public double getAngle(){
		return angle;
	}

}
