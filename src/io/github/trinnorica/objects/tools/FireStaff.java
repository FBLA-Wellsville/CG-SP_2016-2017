package io.github.trinnorica.objects.tools;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.projectiles.Fireball;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.sprites.Tool;

public class FireStaff extends Tool {

	public FireStaff(int x, int y) {
		super(x, y);
		init();
	}
	
	private void init(){
		loadImage("objects/tools/elementals/staff-fire.png");
		setImageDimensions(15, 15);
	}
	
	public int getWidth(){
		return 27;
	}
	public int getHeight(){
		return 27;
		
	}
	
	@Override
	public void use(int x, int y, Velocity velocity){
		Main.addSprite(new Fireball((int)x,(int)y,velocity));
	}

}
