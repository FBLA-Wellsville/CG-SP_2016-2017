package io.github.trinnorica.objects.tools;

import io.github.trinnorica.utils.sprites.Tool;

public class Sword extends Tool {

	public Sword(int x, int y) {
		super(x, y);
		initSword();
	}
	
	private void initSword(){
		loadImage("objects/tools/sword.png");
		setImageDimensions(15, 15);
		power = 1;
		registerXBounds();
	}
	
	public int getWidth(){
		return (int) (16*1.5);
	}
	public int getHeight(){
		return (int) (16*1.5);
		
	}

}
