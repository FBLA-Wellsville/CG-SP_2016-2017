package io.github.trinnorica.objects.doors;

import java.awt.Color;
import java.awt.Image;

import io.github.trinnorica.utils.Images;
import io.github.trinnorica.utils.Utils;
import io.github.trinnorica.utils.sprites.Collidable;
import io.github.trinnorica.utils.sprites.Sprite;
import res.ExternalFile;

public class DoorOpen extends Sprite {
	
	private int id = 0;

	public DoorOpen(int x, int y, int id) {
		super(x, y);
		init(id);
	}

	private void init(int id) {
		this.id = id;
		loadImage(color(ExternalFile.loadTexture("objects/door-open.png"), id));
		setImageDimensions(30, 45);
	}
	
	private Image color(Image img, int id){
		switch(id){
		case 1:
			return (Images.replaceColor(Images.toBufferedImage(img), Color.decode("#C4C400"), Color.RED));
		case 2:
			return(Images.replaceColor(Images.toBufferedImage(img), Color.decode("#C4C400"), Color.BLUE));
		case 3:
			return(Images.replaceColor(Images.toBufferedImage(img), Color.decode("#C4C400"), Color.GREEN));
		case 4:
			return(Images.replaceColor(Images.toBufferedImage(img), Color.decode("#C4C400"), Color.YELLOW));
		default:
			return img;
		}
		
	}
	
	public int getID(){
		return id;
	}

	public void close() {
		
		Utils.swapObjects(this, new Door(x,y,id));
	}
	
	

}
