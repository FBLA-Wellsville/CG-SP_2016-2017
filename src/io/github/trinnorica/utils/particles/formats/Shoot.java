package io.github.trinnorica.utils.particles.formats;

import java.awt.Point;

import io.github.trinnorica.Main;
import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.Particle;
import io.github.trinnorica.utils.particles.ParticleFormat;
import io.github.trinnorica.utils.particles.ParticleType;

public class Shoot implements ParticleFormat {

	@Override
	public void run(Point p, ParticleType t, Direction d) {
		int a = p.x;
		int b = p.y;
		int r = new java.util.Random().nextInt(20)+10;
		int g = 10;
		
		for(int i=0;i!=r;i++){
			boolean f = new java.util.Random().nextBoolean();
			boolean e = new java.util.Random().nextBoolean();
			if(f)a=p.x-new java.util.Random().nextInt(40)+10;
			else a=p.x+new java.util.Random().nextInt(40)+10;
			if(e)b=p.y-new java.util.Random().nextInt(40)+10;
			else b=p.y+new java.util.Random().nextInt(40)+10;
			
			if(d.equals(Direction.LEFT)) {
				if(g>0)g=-g;
			}
			
			Main.addSprite(new Particle(new Point(a,b),t,new Velocity(g, 0)));
		}
	}

	

}
