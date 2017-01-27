package io.github.trinnorica.objects.tools;

import io.github.trinnorica.utils.sprites.Tool;
import io.github.trinnorica.utils.sprites.ToolType;

public class DarkSword extends Tool {

	public DarkSword(int x, int y, ToolType type) {
		super(x, y, type);
		initSword();
	}
	
	private void initSword(){
		loadImage("objects/tools/darksword.png");
		setImageDimensions(15, 15);
		power = 5;
		registerXBounds();
	}
	
	public int getWidth(){
		return (int) (16*1.5);
	}
	public int getHeight(){
		return (int) (16*1.5);
		
	}

}
