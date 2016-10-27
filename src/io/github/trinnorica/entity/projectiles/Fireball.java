package io.github.trinnorica.entity.projectiles;

import java.awt.Point;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.entity.Player;
import io.github.trinnorica.utils.DamageReason;
import io.github.trinnorica.utils.Utils;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.Particle;
import io.github.trinnorica.utils.particles.ParticleType;
import io.github.trinnorica.utils.particles.formats.Stay;
import io.github.trinnorica.utils.sprites.Projectile;
import io.github.trinnorica.utils.sprites.Sprite;
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
	
	@Override
	public void move(){
		Utils.runParticles(new Point(x,y), new Stay(), ParticleType.FIRE, null);
		x=(int) (x+vector.x);
		y=(int) (y+vector.y);
		vector.y = vector.y+Main.gravity;
		vector.x = vector.x-Main.wind;
		
		for(Sprite s : Main.getScreen().objects){
			if(!bounds.intersects(s.getPolygon().getBounds())) continue;
			if(s instanceof Projectile || s instanceof Particle) continue;
			if(shooter instanceof Player && s instanceof Player) continue;
				
			
			if(s instanceof Entity)
				((Entity)s).damage(power,DamageReason.PROJECTILE, this, new Velocity(vector.x/3,-3));
					
				
			
			Main.removeSprite(this);
			
		}
		
	}
	
	

}
