package io.github.trinnorica.utils.particles.formats;

import java.awt.Point;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.Particle;
import io.github.trinnorica.utils.particles.ParticleFormat;
import io.github.trinnorica.utils.particles.ParticleType;

public class Stay implements ParticleFormat {

	@Override
	public void run(Point p, ParticleType t, Direction d) {
		
		int r = new java.util.Random().nextInt(10);
		boolean f = new java.util.Random().nextBoolean();
		
		int a = p.x;
		int b = p.y;
		
		if(f) b=b+r;
		else b=b-r;
		
		Main.addSprite(new Particle(new Point(a,b),t,new Velocity(0, 0),false));
		
	}

	@Override
	public void run(Point p, ParticleType t, Direction d,int i) {
		run(p,t,d);
	}

	@Override
	public void run(Point p, ParticleType t, Direction d, Entity shooter) {
		run(p,t,d);
	}

}
