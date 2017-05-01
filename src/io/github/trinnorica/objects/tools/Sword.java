package io.github.trinnorica.objects.tools;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.entity.Player;
import io.github.trinnorica.utils.DamageReason;
import io.github.trinnorica.utils.Utils;
import io.github.trinnorica.utils.particles.Particle;
import io.github.trinnorica.utils.sprites.Projectile;
import io.github.trinnorica.utils.sprites.Sprite;
import io.github.trinnorica.utils.sprites.Tool;
import io.github.trinnorica.utils.sprites.ToolType;

public class Sword extends Tool {

	public Sword(int x, int y, ToolType type) {
		super(x, y, type);
		initSword();
		cooldown = 3;
	}

	private void initSword() {
		loadImage("objects/tools/sword.png");
		setImageDimensions(15, 15);
		power = 1;
		registerXBounds();
	}

	public int getWidth() {
		return (int) (16 * 1.5);
	}

	public int getHeight() {
		return (int) (16 * 1.5);

	}

	public void use(int x, int y) {
		super.use(x, y);
		if(getUser() instanceof Player){
			for (Sprite s : Main.getScreen().objects) {
				if (!(s instanceof Particle || s instanceof Projectile))
					if (getStrikeRange().getBounds().intersects(s.getPolygon().getBounds())) {
						if (s instanceof Entity)
							((Entity) s).damage(getPower(), DamageReason.ENEMY, getUser(), true, false);
					}
			}
		}
		else {
			if (getStrikeRange().getBounds().intersects(Main.getPlayer().getPolygon().getBounds())) {
				Main.getPlayer().damage(getPower(), DamageReason.ENEMY, getUser(), false, true);
			}
		}
		
		
		
	}

	

}
