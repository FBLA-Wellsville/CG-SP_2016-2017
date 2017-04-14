package io.github.trinnorica.objects;

import java.awt.Color;

import io.github.trinnorica.utils.Images;
import io.github.trinnorica.utils.sprites.Sprite;
import res.ExternalFile;

public class Flag extends Sprite {
	
	public static final int CAVE = 0;
	public static final int POLE = 1;
	public static final int FLAG = 2;
	
	int type; 
	
	public Flag(int x, int y, int type){
		super(x,y);
		this.type = type;
		init();
	}
	private void init(){
		if(type == POLE) loadImage(ExternalFile.loadTexture("objects/gates/pole.png"));
		if(type == FLAG) loadImage(ExternalFile.loadTexture("objects/gates/flag.png"));
		if(type == CAVE) loadImage(Images.createColorImage(Color.BLACK));
		setImageDimensions(30, 30);
	}
	

}
