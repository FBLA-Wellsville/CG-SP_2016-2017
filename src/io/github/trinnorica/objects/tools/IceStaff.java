package io.github.trinnorica.objects.tools;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.entity.projectiles.IceSpike;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.sprites.Tool;

public class IceStaff extends Tool {

	public IceStaff(int x, int y) {
		super(x, y);
		init();
	}
	
	private void init(){
		loadImage("objects/tools/elementals/staff-fire.png");
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
