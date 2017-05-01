package io.github.trinnorica.entity.projectiles;

import java.awt.Point;
import java.util.Random;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.entity.Player;
import io.github.trinnorica.objects.Cloud;
import io.github.trinnorica.utils.DamageReason;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.Particle;
import io.github.trinnorica.utils.particles.ParticleType;
import io.github.trinnorica.utils.sprites.PartialCollidable;
import io.github.trinnorica.utils.sprites.Projectile;
import io.github.trinnorica.utils.sprites.Sprite;
import io.github.trinnorica.utils.sprites.Tool;
import res.ExternalFile;

public class IceSpike extends Projectile {

	public IceSpike(int x, int y, Velocity vec, Entity shooter) {
		super(x, y, vec, shooter);
		init();
	}
	
	public void init(){
		loadImage(ExternalFile.loadTexture("entity/projectiles/ice-spike.png"));
		setImageDimensions(30, 30);
	}
	
	@Override
	public void move(){
		super.move();
		Main.addSprite(new Particle(new Point((int)x + (new Random().nextInt(15)),(int) y + (new Random().nextInt(15))), ParticleType.ICE, new Velocity(0, 1), false));
		
	}
	
	

}
