package io.github.trinnorica.objects;

import java.awt.Color;

import io.github.trinnorica.utils.Images;
import io.github.trinnorica.utils.Utils;
import io.github.trinnorica.utils.sprites.Collidable;
import io.github.trinnorica.utils.sprites.Sprite;
import res.ExternalFile;

public class Door extends Collidable {
	
	private int id = 0;

	public Door(int x, int y, int id) {
		super(x, y);
		init(id);
	}

	private void init(int id) {
		this.id = id;
		switch(id){
		case 1:
			loadImage(Images.replaceColor(Images.toBufferedImage(ExternalFile.loadTexture("objects/door.png")), Color.decode("#C4C400"), Color.RED));
			break;
		case 2:
			loadImage(Images.replaceColor(Images.toBufferedImage(ExternalFile.loadTexture("objects/door.png")), Color.decode("#C4C400"), Color.BLUE));
			break;
		case 3:
			loadImage(Images.replaceColor(Images.toBufferedImage(ExternalFile.loadTexture("objects/door.png")), Color.decode("#C4C400"), Color.GREEN));
			break;
		case 4:
			loadImage(Images.replaceColor(Images.toBufferedImage(ExternalFile.loadTexture("objects/door.png")), Color.decode("#C4C400"), Color.YELLOW));
			break;
		}
		setImageDimensions(30, 45);
	}
	
	public int getID(){
		return id;
	}

	public void open() {
		Utils.swapObjects(this, new Sprite(this.x,this.y,ExternalFile.loadTexture("objects/door-open.png"),this.getWidth(),this.height));
	}
	
	

}
