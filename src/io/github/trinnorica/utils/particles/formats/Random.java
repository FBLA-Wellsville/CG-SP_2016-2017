package io.github.trinnorica.utils.particles.formats;

import java.awt.Point;

import io.github.trinnorica.Main;
import io.github.trinnorica.utils.particles.Particle;
import io.github.trinnorica.utils.particles.ParticleFormat;
import io.github.trinnorica.utils.particles.ParticleType;

public class Random implements ParticleFormat {

	@Override
	public void run(Point p, ParticleType t) {
		int a = p.x;
		int b = p.y;
		int r = new java.util.Random().nextInt(10)+10;
		
		for(int i=0;i!=r;i++){
			boolean d = new java.util.Random().nextBoolean();
			boolean e = new java.util.Random().nextBoolean();
			if(d)a=p.x-new java.util.Random().nextInt(40)+10;
			else a=p.x+new java.util.Random().nextInt(40)+10;
			if(e)b=p.y-new java.util.Random().nextInt(40)+10;
			else b=p.y+new java.util.Random().nextInt(40)+10;
			
			Main.addSprite(new Particle(new Point(a,b),t));
		}
	}

	

}
