package io.github.trinnorica.utils;

import java.awt.Image;

import res.ExternalFile;

public enum Backgrounds {
	
	MAIN("backgrounds/menu-background.png"),
	CREDITS("backgrounds/credits-background.png"),
	GRASS("backgrounds/grass-background.png");
	
	String image;
	
	Backgrounds(String image){
		this.image = image;
	}
	
	public Image getImage(){
		return ExternalFile.loadTexture(image);
	}

}
