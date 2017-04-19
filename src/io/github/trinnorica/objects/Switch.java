package io.github.trinnorica.objects;

import java.awt.Color;
import java.awt.Image;

import io.github.trinnorica.Main;
import io.github.trinnorica.objects.doors.Door;
import io.github.trinnorica.objects.doors.DoorOpen;
import io.github.trinnorica.utils.Images;
import io.github.trinnorica.utils.Rotation;
import io.github.trinnorica.utils.sprites.Collidable;
import io.github.trinnorica.utils.sprites.Sprite;
import res.ExternalFile;

public class Switch extends Collidable {
	
	private int id = 0;
	private int status = 0;
	private Rotation rot;

	public Switch(int x, int y, int id, Rotation rot) {
		super(x, y);
		this.rot = rot;
		init(id);
	}

	private void init(int id) {
		this.id = id;
		loadImage(color(ExternalFile.loadTexture("objects/switch-off.png"), id));
		setImageDimensions(15, 15);
	}
	
	private Image color(Image img, int id){
		switch(id){
		case 1:
			return Images.rotate(Images.replaceColor(Images.toBufferedImage(Images.replaceColor(Images.toBufferedImage(img), Color.decode("#C4C400"), Color.RED)),Color.decode("#898900"),Color.RED.darker().darker()),rot.getAngle());
		case 2:
			return Images.rotate(Images.replaceColor(Images.toBufferedImage(Images.replaceColor(Images.toBufferedImage(img), Color.decode("#C4C400"), Color.BLUE)),Color.decode("#898900"),Color.BLUE.darker().darker()),rot.getAngle());
		case 3:
			return Images.rotate(Images.replaceColor(Images.toBufferedImage(Images.replaceColor(Images.toBufferedImage(img), Color.decode("#C4C400"), Color.GREEN)),Color.decode("#898900"),Color.GREEN.darker().darker()),rot.getAngle());
		case 4:
			return Images.rotate(Images.replaceColor(Images.toBufferedImage(Images.replaceColor(Images.toBufferedImage(img), Color.decode("#C4C400"), Color.YELLOW)),Color.decode("#898900"),Color.YELLOW.darker().darker()),rot.getAngle());
		default:
			return img;
		}
		
	}
	
	public int getID(){
		return id;
	}

	public void toggle() {
		if(status == 0){
			status = 1;
			loadImage(color(ExternalFile.loadTexture("objects/switch-on.png"), id));
			for(Sprite s : Main.getScreen().objects){
				if(s instanceof Door){
					((Door)s).open();
					return;
				}
			}
			return;
		}
		if(status == 1){
			status = 0;
			loadImage(color(ExternalFile.loadTexture("objects/switch-off.png"), id));
			for(Sprite s : Main.getScreen().objects){
				if(s instanceof DoorOpen){
					((DoorOpen)s).close();
					return;
				}
			}
			return;
		}
	}
	
	

}
