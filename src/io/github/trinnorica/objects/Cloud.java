package io.github.trinnorica.objects;

import io.github.trinnorica.utils.sprites.PartialCollidable;
import res.ExternalFile;

public class Cloud extends PartialCollidable {
	
	public static final int BEGIN = 0;
	public static final int MIDDLE = 1;
	public static final int END = 2;
	int type;
	public Cloud(int x, int y, int cloudtype){
		super(x,y);
		
		type = cloudtype;
		init();
	}
	
	private void init(){
		switch(type){
		case 0:
			loadImage(ExternalFile.loadTexture("clouds/begin.png"));
			break;
		case 1:
			loadImage(ExternalFile.loadTexture("clouds/middle.png"));
			break;
		case 2:
			loadImage(ExternalFile.loadTexture("clouds/end.png"));
			break;
		default:
			
			loadImage(ExternalFile.loadTexture("clouds/begin.png"));
			break;
		}
		setImageDimensions(30, 30);
	}

}
