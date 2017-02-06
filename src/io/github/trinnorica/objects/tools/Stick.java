package io.github.trinnorica.objects.tools;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.utils.DamageReason;
import io.github.trinnorica.utils.Utils;
import io.github.trinnorica.utils.particles.Particle;
import io.github.trinnorica.utils.sprites.Projectile;
import io.github.trinnorica.utils.sprites.Sprite;
import io.github.trinnorica.utils.sprites.Tool;
import io.github.trinnorica.utils.sprites.ToolType;
import res.ExternalFile;

public class Stick extends Tool{

	public Stick(int x, int y, ToolType type) {
		super(x, y, type);
		power = 10;
		init();
		
	}
	public void init(){
		loadImage(ExternalFile.loadTexture("objects/tools/stick.png"));
		setImageDimensions(16, 16);
		registerXBounds();
	}
	
	public int getWidth(){
		return 27;
	}
	public int getHeight(){
		return 27;
		
	}
	
	public void use(int x, int y) {
		super.use(x, y);
		Utils.debug("X:" + x + "\n Y:" + y);
		for (Sprite s : Main.getScreen().objects) {
			if (!(s instanceof Particle || s instanceof Projectile))
				if (getStrikeRange().getBounds().intersects(s.getPolygon().getBounds())) {
					if (s instanceof Entity)
						((Entity) s).damage(getPower(), DamageReason.ENEMY, this);
				}
		}
	}

}
