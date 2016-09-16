package io.github.trinnorica.objects.tools;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.projectiles.Arrow;
import io.github.trinnorica.utils.Tool;
import io.github.trinnorica.utils.Velocity;

public class Bow extends Tool {

	public Bow(int x, int y) {
		super(x, y);
		init();
	}
	
	private void init(){
		loadImage("objects/tools/bow.png");
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
		Main.addProjectile(new Arrow(x,y,velocity));
	}

}