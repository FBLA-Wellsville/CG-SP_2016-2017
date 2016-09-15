package io.github.trinnorica.objects.tools;

import io.github.trinnorica.utils.Tool;

public class Sword extends Tool {

	public Sword(int x, int y) {
		super(x, y);
		initSword();
	}
	
	private void initSword(){
		loadImage("objects/tools/sword.png");
		setImageDimensions(15, 15);
	}
	
	public int getWidth(){
		return 27;
	}
	public int getHeight(){
		return 27;
		
	}

}
