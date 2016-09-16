package io.github.trinnorica.objects.tools;

import io.github.trinnorica.utils.Tool;
import res.ExternalFile;

public class Stick extends Tool{

	public Stick(int x, int y) {
		super(x, y);
		power = 10;
		init();
		
	}
	public void init(){
		loadImage(ExternalFile.loadTexture("objects/tools/stick.png"));
		setImageDimensions(16, 16);
	}
	
	public int getWidth(){
		return 27;
	}
	public int getHeight(){
		return 27;
		
	}

}
