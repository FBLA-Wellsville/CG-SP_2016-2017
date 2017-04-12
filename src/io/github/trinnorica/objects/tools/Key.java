package io.github.trinnorica.objects.tools;

import java.awt.Color;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.entity.projectiles.IceSpike;
import io.github.trinnorica.utils.Images;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.sprites.Tool;
import io.github.trinnorica.utils.sprites.ToolType;
import res.ExternalFile;

public class Key extends Tool {
	
	private int id;

	public Key(int x, int y, ToolType type, int id) {
		super(x, y, type);
		this.id = id;
		init();
	}
	
	private void init(){
		switch(id){
		case 1:
			loadImage(Images.replaceColor(Images.toBufferedImage(ExternalFile.loadTexture("objects/tools/key.png")), Color.decode("#C4C400"), Color.RED));
			break;
		case 2:
			loadImage(Images.replaceColor(Images.toBufferedImage(ExternalFile.loadTexture("objects/tools/key.png")), Color.decode("#C4C400"), Color.BLUE));
			break;
		case 3:
			loadImage(Images.replaceColor(Images.toBufferedImage(ExternalFile.loadTexture("objects/tools/key.png")), Color.decode("#C4C400"), Color.GREEN));
			break;
		case 4:
			loadImage(Images.replaceColor(Images.toBufferedImage(ExternalFile.loadTexture("objects/tools/key.png")), Color.decode("#C4C400"), Color.YELLOW));
			break;
		}
		
		
		setImageDimensions(15, 15);
		registerXBounds();
	}
	
	public int getWidth(){
		return 27;
	}
	public int getHeight(){
		return 27;
		
	}
	
	@Override
	public void use(int x, int y, Velocity velocity, Entity shooter){
		Main.addSprite(new IceSpike((int)x,(int)y,velocity, shooter));
	}

}
