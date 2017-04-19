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

public class Armour extends Tool {
	
	public static final int IRON = 0;
	public static final int GOLD = 1;
	
	private int id;
	private int protection;

	public Armour(int x, int y, ToolType type, int id) {
		super(x, y, type);
		this.id = id;
		init();
	}
	
	private void init(){
		switch(id){
		case 0:
			loadImage(ExternalFile.loadTexture("objects/tools/armour/iron-armour.png"));
			protection = 2;
			break;
		case 1:
			loadImage(ExternalFile.loadTexture("objects/tools/armour/gold-armour.png"));
			protection = 5;
			break;
		}
		
		
		setImageDimensions(30, 30);
	}
	
	public int getWidth(){
		return 27;
	}
	public int getHeight(){
		return 27;
		
	}
	
	public int getProtection(){
		return protection;
	}
	
	

	public int getID() {
		return id;
	}

}
