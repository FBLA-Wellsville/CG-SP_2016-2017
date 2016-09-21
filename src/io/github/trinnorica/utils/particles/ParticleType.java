package io.github.trinnorica.utils.particles;

public enum ParticleType {
	
	ICE("ice"),
	FIRE("fire");
	
	String particle;
	
	ParticleType(String particle){
		this.particle = particle;
	}
	
	public String getString(){
		return particle;
	}
	

}
