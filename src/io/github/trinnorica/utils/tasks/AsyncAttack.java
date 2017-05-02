package io.github.trinnorica.utils.tasks;

import java.awt.Color;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Enemy;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.utils.DamageReason;
import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.Utils;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.formats.Shoot;
import io.github.trinnorica.utils.sprites.Sprite;
import io.github.trinnorica.utils.sprites.ToolType;

public class AsyncAttack implements Runnable {

	Entity attacker;
	Entity entity;

	public AsyncAttack(Entity attacker, Entity entity) {
		this.attacker = attacker;
		this.entity = entity;
	}

	@Override
	public void run() {

		if (attacker.getTool().getToolType().equals(ToolType.MELEE)) {
			if (attacker.tool.getStrikeRange().intersects(entity.getPolygon().getBounds())) {
				attacker.tool.use((int) attacker.x, (int) attacker.y);
				((Enemy) attacker).cooldown = true;

			}

			return;
		}

		if (hasLineOfSight(attacker, entity)) {
			if (attacker.getTool().getToolType().equals(ToolType.DIRECTIONAL)) {
				((Enemy) attacker).cooldown = true;

				if (attacker.direction.equals(Direction.LEFT))
					attacker.getTool().use((int) attacker.x, (int) attacker.y, attacker.direction, new Shoot(),
							attacker);
				if (attacker.direction.equals(Direction.RIGHT))
					attacker.getTool().use((int) attacker.x, (int) attacker.y, attacker.direction, new Shoot(),
							attacker);

				return;
			}
		}
		if (attacker.getTool().getToolType().equals(ToolType.PROJECTILE)) {
			((Enemy) attacker).cooldown = true;
			if (attacker.direction.equals(Direction.LEFT))
				attacker.getTool().use((int) attacker.x, (int) attacker.y, new Velocity(-10, -5), attacker);
			if (attacker.direction.equals(Direction.RIGHT))
				attacker.getTool().use((int) attacker.x, (int) attacker.y, new Velocity(10, -5), attacker);

			return;
		}
		// }

	}

	public boolean hasLineOfSight(Entity a, Entity entity) {

		int s = (int) attacker.x;
		if (attacker.direction.equals(Direction.LEFT)) {
			while (s > 0) {
				s = s - 1;
				// Main.getScreen().getGraphics().drawRect(s, attacker.y, 1, 1);
				if (entity.getPolygon().getBounds().contains(s, attacker.y))
					return true;
			}
			return false;

		}
		if (attacker.direction.equals(Direction.RIGHT)) {
			while (s < Main.getScreen().getWidth()) {
				s = s + 1;
				// Main.getScreen().getGraphics().drawRect(s, attacker.y, 1, 1);
				try {
					if (entity.getPolygon().getBounds().contains(s, attacker.y))
						return true;
				} catch (NullPointerException ex) {
					return false;
				}

			}
			return false;

		}
		return false;
	}

}
