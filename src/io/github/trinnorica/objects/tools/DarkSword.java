package io.github.trinnorica.objects.tools;

import io.github.trinnorica.utils.sprites.Tool;

public class DarkSword extends Tool {

	public DarkSword(int x, int y) {
		super(x, y);
		initSword();
	}
	
	private void initSword(){
		loadImage("objects/tools/darksword.png");
		setImageDimensions(15, 15);
		power = 5;
	}
	
	public int getWidth(){
		return (int) (16*1.5);
	}
	public int getHeight(){
		return (int) (16*1.5);
		
	}

}
