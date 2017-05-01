package io.github.trinnorica.objects.tools;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.entity.projectiles.IceSpike;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.sprites.Tool;
import io.github.trinnorica.utils.sprites.ToolType;

public class IceStaff extends Tool {

	public IceStaff(int x, int y, ToolType type) {
		super(x, y, type);
		init();
		cooldown = 30;
	}
	
	private void init(){
		loadImage("objects/tools/elementals/staff-ice.png");
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
		super.use(x,y);
		Main.addSprite(new IceSpike((int)x,(int)y,velocity, shooter));
	}

}
