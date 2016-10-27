package io.github.trinnorica.utils.particles;

import java.util.Random;

public enum ParticleType {
	
	ICE("ice"),
	FIRE("fire"), 
	BLOOD("blood-1:blood-2");
	
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
	

}
