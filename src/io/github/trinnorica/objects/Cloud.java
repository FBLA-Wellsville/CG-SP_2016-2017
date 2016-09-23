package io.github.trinnorica.objects;

import io.github.trinnorica.utils.Sprite;
import io.github.trinnorica.utils.SpriteType;
import res.ExternalFile;

public class Cloud extends Sprite {
	
	SpriteType type;
	public Cloud(int x, int y,SpriteType cloudtype){
		super(x,y);
		if(!(cloudtype.equals(SpriteType.CLOUD_BEGIN) || cloudtype.equals(SpriteType.CLOUD_MIDDLE) || cloudtype.equals(SpriteType.CLOUD_END)))
			cloudtype = SpriteType.CLOUD_BEGIN;
		type = cloudtype;
		init();
	}
	
	private void init(){
		switch(type){
		case CLOUD_BEGIN:
			loadImage(ExternalFile.loadTexture("clouds/begin.png"));
			break;
		case CLOUD_MIDDLE:
			loadImage(ExternalFile.loadTexture("clouds/middle.png"));
			break;
		case CLOUD_END:
			loadImage(ExternalFile.loadTexture("clouds/end.png"));
			break;
		default:
			
			loadImage(ExternalFile.loadTexture("clouds/begin.png"));
			break;
		}
		setImageDimensions(30, 30);
	}

}
