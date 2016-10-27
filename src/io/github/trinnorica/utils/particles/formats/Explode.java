package io.github.trinnorica.utils.particles.formats;

import java.awt.Point;

import io.github.trinnorica.Main;
import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.Particle;
import io.github.trinnorica.utils.particles.ParticleFormat;
import io.github.trinnorica.utils.particles.ParticleType;

public class Explode implements ParticleFormat {

	int power;

	public Explode() {
		power = 1;
	}

	public Explode(int power) {
		this.power = power;
	}

	@Override
	public void run(Point p, ParticleType t, Direction d) {
		int r = new java.util.Random().nextInt(10) + 5;

		for (int i = 0; i != r; i++) {
			boolean f = new java.util.Random().nextBoolean();
			int e=0;
			if (f)
				e = - new java.util.Random().nextInt(5*power) + 5;
			else
				e = new java.util.Random().nextInt(5*power) + 5;
			

			Main.addSprite(new Particle(new Point(p.x, p.y), t, new Velocity(e, -2),true));
		}
	}

}
