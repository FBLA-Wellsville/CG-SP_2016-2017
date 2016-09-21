package io.github.trinnorica.utils.particles.formats;

import java.awt.Point;

import io.github.trinnorica.Main;
import io.github.trinnorica.utils.ParticleFormat;
import io.github.trinnorica.utils.particles.ParticleType;

public class Testing implements ParticleFormat {

	@Override
	public void run(Point p, ParticleType t) {
		Main.addSprite(new Particle(p, t));
	}

	

}
