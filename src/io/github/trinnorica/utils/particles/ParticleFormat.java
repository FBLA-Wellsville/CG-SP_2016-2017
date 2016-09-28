package io.github.trinnorica.utils.particles;

import java.awt.Point;

import io.github.trinnorica.utils.Direction;

public interface ParticleFormat {
	
	public void run(Point p, ParticleType t, Direction d);

}
