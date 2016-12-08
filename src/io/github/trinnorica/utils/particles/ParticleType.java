package io.github.trinnorica.utils.particles;

import java.util.Random;

public enum ParticleType {
	
	ICE("ice"),
	FIRE("fire"), 
	BLOOD("blood-1:blood-2"),
	HEART("heart"), 
	GHOST("ghost");
	
	String particle;
	
	ParticleType(String particle){
		this.particle = particle;
	}
	
	public String getString(){
		if(particle.contains(":")){

			String[] i = particle.split(":");
			return i[new Random().nextInt(i.length)];
		
		}
		return particle;
	}
	
	public boolean getAnimation(){
		switch(this){
		case ICE:
			return false;
		case FIRE:
			return false;
		case BLOOD:
			return false;
		case HEART:
			return false;
		case GHOST:
			return true;
		default: 
			return true;
		}
	}
	

}
