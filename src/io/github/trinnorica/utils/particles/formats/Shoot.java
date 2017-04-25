package io.github.trinnorica.utils.particles.formats;

import java.awt.Point;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.Particle;
import io.github.trinnorica.utils.particles.ParticleFormat;
import io.github.trinnorica.utils.particles.ParticleType;

public class Shoot implements ParticleFormat {

	@Override
	public void run(Point p, ParticleType t, Direction d, Entity shooter) {
		int a = p.x;
		int b = p.y;
		int r = new java.util.Random().nextInt(40)+30;
		double g = 0;
		double h = 5;
		
		for(int i=0;i!=r;i++){
			boolean f = new java.util.Random().nextBoolean();
			if(f)g=-new java.util.Random().nextDouble();
			else g=new java.util.Random().nextDouble();
			
			
			
			if(d.equals(Direction.LEFT)) {
				h = -new java.util.Random().nextInt(5)-new java.util.Random().nextDouble()-2;
			} else {
				h = new java.util.Random().nextInt(5)+new java.util.Random().nextDouble()+2;
			}
			
			Main.addSprite(new Particle(new Point(a,b),t,new Velocity(h, g/2),false,10,true,shooter));
		}
	}

	@Override
	public void run(Point p, ParticleType t, Direction d,int i) {
		run(p,t,d);
	}

	@Override
	public void run(Point p, ParticleType t, Direction d) {
		// TODO Auto-generated method stub
		
	}

}
