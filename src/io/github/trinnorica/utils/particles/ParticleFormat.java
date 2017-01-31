package io.github.trinnorica.utils.particles;

import java.awt.Point;

import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.utils.Direction;

public interface ParticleFormat {
	
	public void run(Point p, ParticleType t, Direction d);
	public void run(Point p, ParticleType t, Direction d,int mini);
	public void run(Point p, ParticleType t, Direction d,Entity shooter);

}
