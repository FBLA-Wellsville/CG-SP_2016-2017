package io.github.trinnorica.utils;

import java.util.Random;

public enum DamageReason {
	PROJECTILE("You were shot!:Ouch! Arrow to the face!");
	
	String deathline;
	
	DamageReason(String line){
		this.deathline = line;
	}
	
	public String getDeathLine(){
		if(deathline.contains(":")){
			return deathline.split(":")[new Random().nextInt(deathline.split(":").length)];
		}
		else return deathline;
	}

}
