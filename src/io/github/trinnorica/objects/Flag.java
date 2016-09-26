package io.github.trinnorica.objects;

import io.github.trinnorica.utils.sprites.Sprite;
import res.ExternalFile;

public class Flag extends Sprite {
	
	public static int POLE = 1;
	public static int FLAG = 2;
	
	int type; 
	
	public Flag(int x, int y, int type){
		super(x,y);
		this.type = type;
		init();
	}
	private void init(){
		if(type == POLE) loadImage(ExternalFile.loadTexture("objects/gates/pole.png"));
		if(type == FLAG) loadImage(ExternalFile.loadTexture("objects/gates/flag.png"));
		setImageDimensions(30, 30);
	}
	

}
