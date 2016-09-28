package io.github.trinnorica.objects.tools;

import java.awt.Point;

import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.Utils;
import io.github.trinnorica.utils.particles.ParticleFormat;
import io.github.trinnorica.utils.particles.ParticleType;
import io.github.trinnorica.utils.particles.formats.Random;
import io.github.trinnorica.utils.sprites.Tool;

public class FireDagger extends Tool {

	public FireDagger(int x, int y) {
		super(x, y);
		initSword();
	}
	
	private void initSword(){
		loadImage("objects/tools/elementals/dagger-fire.png");
		setImageDimensions(15, 15);
	}
	
	public int getWidth(){
		return (int) (16*1.5);
	}
	public int getHeight(){
		return (int) (16*1.5);
		
	}
	
	@Override
	public void use(int x, int y, Direction d, ParticleFormat f){
		Utils.runParticles(new Point(x,y), f, ParticleType.FIRE,d);
	}

}

