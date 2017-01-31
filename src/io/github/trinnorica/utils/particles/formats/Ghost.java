package io.github.trinnorica.utils.particles.formats;

import java.awt.Point;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.Particle;
import io.github.trinnorica.utils.particles.ParticleFormat;
import io.github.trinnorica.utils.particles.ParticleType;

public class Ghost implements ParticleFormat {

	@Override
	public void run(Point p, ParticleType t, Direction d) {
		run(p,t,d,100);
		
	}
	
	@Override
	public void run(Point p, ParticleType t, Direction d,int i) {
		Main.addSprite(new Particle(p,t,new Velocity(0, -2),false,i));
	}

	@Override
	public void run(Point p, ParticleType t, Direction d, Entity shooter) {
		// TODO Auto-generated method stub
		
	}

	

}
