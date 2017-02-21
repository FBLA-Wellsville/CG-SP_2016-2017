package io.github.trinnorica.entity.projectiles;

import java.awt.Point;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.entity.Player;
import io.github.trinnorica.objects.Collidable;
import io.github.trinnorica.utils.DamageReason;
import io.github.trinnorica.utils.Utils;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.Particle;
import io.github.trinnorica.utils.particles.ParticleType;
import io.github.trinnorica.utils.particles.formats.Stay;
import io.github.trinnorica.utils.sprites.Projectile;
import io.github.trinnorica.utils.sprites.Sprite;
import io.github.trinnorica.utils.sprites.Tool;
import res.ExternalFile;

public class Fireball extends Projectile {

	public Fireball(int x, int y, Velocity vec, Entity shooter) {
		super(x, y, vec, shooter);
		init();
	}
	
	public void init(){
		loadImage(ExternalFile.loadTexture("entity/projectiles/fireball.gif"));
		setImageDimensions(30, 30);
	}
	
	
	

}
