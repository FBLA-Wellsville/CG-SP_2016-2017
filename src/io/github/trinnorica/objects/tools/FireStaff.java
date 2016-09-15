package io.github.trinnorica.objects.tools;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.projectiles.Fireball;
import io.github.trinnorica.utils.Tool;
import io.github.trinnorica.utils.Velocity;

public class FireStaff extends Tool {

	public FireStaff(int x, int y) {
		super(x, y);
		init();
	}
	
	private void init(){
		loadImage("objects/tools/fsword.png");
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
		System.out.println("1");
		Main.addProjectile(new Fireball((int)x,(int)y,velocity));
	}

}
