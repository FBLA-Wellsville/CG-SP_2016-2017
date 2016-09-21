package io.github.trinnorica.objects.tools;

import java.awt.Point;

import io.github.trinnorica.utils.Tool;
import io.github.trinnorica.utils.Utils;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.ParticleType;
import io.github.trinnorica.utils.particles.formats.Random;

public class IceDagger extends Tool {

	public IceDagger(int x, int y) {
		super(x, y);
		initSword();
	}
	
	private void initSword(){
		loadImage("objects/tools/elementals/dagger-ice.png");
		setImageDimensions(15, 15);
	}
	
	public int getWidth(){
		return (int) (16*1.5);
	}
	public int getHeight(){
		return (int) (16*1.5);
		
	}
	
	@Override
	public void use(int x, int y, Velocity velocity){
		Utils.runParticles(new Point(x,y), new Random(), ParticleType.ICE);
	}

}
