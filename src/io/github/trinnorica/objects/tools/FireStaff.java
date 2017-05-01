

package io.github.trinnorica.objects.tools;

import java.awt.Color;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.entity.projectiles.Arrow;
import io.github.trinnorica.entity.projectiles.Fireball;
import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.Utils;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.ParticleFormat;
import io.github.trinnorica.utils.particles.ParticleType;
import io.github.trinnorica.utils.sprites.Tool;
import io.github.trinnorica.utils.sprites.ToolType;

public class FireStaff extends Tool {
	
	

	public FireStaff(int x, int y,ToolType type) {
		super(x, y, type);
		init();
	}
	
	private void init(){
		loadImage("objects/tools/elementals/staff-fire.png");
		setImageDimensions(15, 15);
		registerXBounds();
		cooldown = 30;
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
		Main.addSprite(new Fireball(x,y,velocity, shooter));
	}
	

}