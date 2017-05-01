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
		x=(int) (x+vector.x);
		y=(int) (y+vector.y);
		vector.y = vector.y+Main.gravity;
		vector.x = vector.x-Main.wind;
		
		if(!(shooter instanceof Player)){
			if(bounds.intersects(Main.getPlayer().getPolygon().getBounds())){
				Main.getPlayer().damage(power,DamageReason.PROJECTILE, this, new Velocity(vector.x/3,-3));
				Main.removeSprite(this);
			}
		}
		
		else for(Sprite s : Main.getScreen().objects){
			if(!bounds.intersects(s.getPolygon().getBounds())) continue;
			if(s instanceof Projectile || s instanceof Particle || s instanceof Tool || s instanceof Cloud) continue;
			if(shooter instanceof Player && s instanceof Player) continue;
			if(!(shooter instanceof Player) && !(s instanceof Player)) continue;
				
			if(s instanceof Entity){
				((Entity)s).damage(power,DamageReason.PROJECTILE, this, new Velocity(vector.x/3,-3));
				Main.removeSprite(this);
				return;
			}
					
			if(s instanceof PartialCollidable){
				Main.removeSprite(this);
			}
			
			
			
		}
		
		Main.addSprite(new Particle(new Point((int)x + (new Random().nextInt(15)),(int) y + (new Random().nextInt(15))), ParticleType.ICE, new Velocity(0, 0), false));
		
	}
	
	

}
