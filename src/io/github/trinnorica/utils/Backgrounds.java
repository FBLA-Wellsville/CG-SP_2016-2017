package io.github.trinnorica.utils;

import java.awt.Image;

import res.ExternalFile;

public enum Backgrounds {
	
	MAIN("backgrounds/menu-background.png"),
	CREDITS("backgrounds/credit-background.png"),
	GRASS("backgrounds/grass-background.png"), 
	HELL("backgrounds/hell-background.png"), 
	CAVE("backgrounds/cave-background.png"), 
	BOSS("backgrounds/boss-background.png"), 
	SKY("backgrounds/sky-background.png");
	
	String image;
	
	Backgrounds(String image){
		this.image = image;
	}
	
	public Image getImage(){
		return ExternalFile.loadTexture(image);
	}

}
