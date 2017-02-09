package io.github.trinnorica.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ConcurrentModificationException;
import java.util.Timer;
import java.util.TimerTask;

import io.github.trinnorica.Main;
import io.github.trinnorica.utils.DamageReason;
import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.Utils;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.Particle;
import io.github.trinnorica.utils.particles.ParticleType;
import io.github.trinnorica.utils.particles.formats.Explode;
import io.github.trinnorica.utils.particles.formats.Ghost;
import io.github.trinnorica.utils.particles.formats.Stay;
import io.github.trinnorica.utils.sprites.Moveable;
import io.github.trinnorica.utils.sprites.Sprite;
import io.github.trinnorica.utils.sprites.Tool;
import io.github.trinnorica.utils.tasks.CheckLanding;
import res.ExternalFile;

public class Entity extends Sprite implements Moveable {

	public double health;
	public double maxhealth;
	protected boolean dead = false;
	public boolean invisible = false;
	boolean onground = false;
	boolean falling = false;
	public boolean damaged = false;
	public Tool tool;
	double dx = 0;
	double dy = 0;

	protected int score;
	// protected Tool tool;
	public boolean walkingb;
	public Velocity velocity = new Velocity(0, 0);
	// protected Direction direction = Direction.RIGHT;
	// protected Direction facing = Direction.RIGHT;
	// protected Interaction interact;
	protected boolean moving = false;
	protected Image standing = ExternalFile.loadTexture("entity/player/player.png");
	protected Image walking = ExternalFile.loadTexture("entity/player/walk.gif");

	public Entity(int x, int y) {
		super(x, y);
	}

	public int getHealth() {
		return (int) health;
	}

	public int getMaxHealth() {
		return (int) maxhealth;
	}

	// public Direction getFacingDirection(){
	// return facing;
	// }

	// public void damage(int i, Entity damager, DamageReason reason) {
	// health = health - i;
	// setVelocity(new Velocity(0, -1));
	//// Utils.displayMessage(new Random().nextInt(), "-" + i, x, y, 100,
	// "#FF0000", 15,Bridge.getGame().getFont());
	//// Utils.displayMessage(new Random().nextInt(), getHealth() + "/" +
	// getMaxHealth(), x, y - 15, 100, "#FF0000",
	// 15,Bridge.getGame().getFont());
	// if (health <= 0) {
	// this.kill(reason);
	//// if (damager instanceof Player) {
	//// ((Player) damager).addScore(score);
	//// }
	// }
	//
	// }

	public void damage(int i, DamageReason reason, Entity damager) {
		
		if(damager instanceof Player && this instanceof Player) {
			Utils.debug("Case 1");
			return;
		}
		if(!(damager instanceof Player) && !(this instanceof Player)){
			Utils.debug("Case 2");
			return;
		}

		if (damager.x - x >= 0)
			if (this instanceof Player) {
				if (damaged)
					return;
				damaged = true;
				((Player) this).toss(Direction.LEFT);
			} else
				setVelocity(new Velocity(-2, -3));
		else if (this instanceof Player) {
			if (damaged)
				return;
			damaged = true;
			((Player) this).toss(Direction.RIGHT);
		} else
			setVelocity(new Velocity(2, -3));

		health = health - i;
		// Utils.displayMessage(new Random().nextInt(), "-" + i, x, y, 100,
		// "#FF0000", 15,Bridge.getGame().getFont());
		// Utils.displayMessage(new Random().nextInt(), getHealth() + "/" +
		// getMaxHealth(), x, y - 15, 100, "#FF0000",
		// 15,Bridge.getGame().getFont());
		//
		if (health <= 0) {
			this.kill(reason);
		}

	}

	public void damage(int i, DamageReason reason, Particle damager) {

		if (damager.x - x >= 0)
			if (this instanceof Player) {
				if (damaged)
					return;
				damaged = true;
				((Player) this).toss(Direction.LEFT);
			} else
				setVelocity(new Velocity(-2, -3));
		else if (this instanceof Player) {
			if (damaged)
				return;
			damaged = true;
			((Player) this).toss(Direction.RIGHT);
		} else
			setVelocity(new Velocity(2, -3));

		health = health - i;
		// Utils.displayMessage(new Random().nextInt(), "-" + i, x, y, 100,
		// "#FF0000", 15,Bridge.getGame().getFont());
		// Utils.displayMessage(new Random().nextInt(), getHealth() + "/" +
		// getMaxHealth(), x, y - 15, 100, "#FF0000",
		// 15,Bridge.getGame().getFont());
		//
		if (health <= 0) {
			this.kill(reason);
		}

	}

	public void damage(int i, DamageReason reason, Entity damager, Velocity v) {
		health = health - i;
		setVelocity(v);
		// Utils.displayMessage(new Random().nextInt(), "-" + i, x, y, 100,
		// "#FF0000", 15,Bridge.getGame().getFont());
		// Utils.displayMessage(new Random().nextInt(), getHealth() + "/" +
		// getMaxHealth(), x, y - 15, 100, "#FF0000",
		// 15,Bridge.getGame().getFont());
		//
		if (health <= 0) {
			this.kill(reason);
		}

	}

	public void setVelocity(Velocity v) {
		velocity = v;

	}

	public void setVelocity(double x, double y) {
		velocity = new Velocity(x, y);
	}

	public void setVelocity(double x, String y) {
		velocity = new Velocity(x, velocity.y);
	}

	public void setVelocity(String x, double y) {
		velocity = new Velocity(velocity.x, y);
	}

	public void kill(DamageReason reason) {
		// Utils.runParticles(new Point(x,y), new Explode(4),
		// ParticleType.BLOOD, null);
		Utils.runParticles(new Point(x, y), new Ghost(), ParticleType.GHOST, null, 100);
		Main.removeSprite(this);
		// dead = true;
		// Utils.debug("DEATH");
		// interact();
	}

	// public Tool getTool() {
	// return tool;
	// }

	// public void setTool(Tool tool) {
	// tool.setEntity(this);
	// this.tool = tool;
	//
	// }

	// public boolean hasTool() {
	// if (tool == null)
	// return false;
	// else
	// return true;
	// }

	// public void setDirection(Direction d) {
	// direction = d;
	// }

	// public Direction getDirection() {
	// return direction;
	// }

	// public boolean isInvisible() {
	// return invisible;
	// }

	// public void toggleInvisiblility() {
	// if (!invisible) {
	// invisible = true;
	// if (!walking)
	// loadImage(Images.makeImageTranslucent(Images.toBufferedImage(getImage()),
	// 0.5));
	//
	// } else {
	// invisible = false;
	// if (!walking) {
	// if (this instanceof Player) {
	//
	// loadImage("playermodels/yellow/stand_" +
	// direction.toString().toLowerCase() + ".png");
	// }
	// }
	//
	// }
	// }

	public void drawHealthBar(Graphics g, int x, int y, int width, int height) {

		g.setFont(Main.getFont().deriveFont(5f));

		Color c = g.getColor();

		g.setColor(Color.BLACK);
		//
		g.drawRect(x, y, width, height);
		//
		if ((int) (health / maxhealth * 100) > 66)
			g.setColor(Color.green);
		if ((int) (health / maxhealth * 100) < 66 && (int) (health / maxhealth * 100) > 33)
			g.setColor(Color.YELLOW);
		if ((int) (health / maxhealth * 100) < 33)
			g.setColor(Color.RED);
		g.fillRect(x, y, (int) ((health / maxhealth * 100) * ((double) (width / 100))) + 1, height + 1);
		//
		Utils.drawOutlineString(g, "Health:",
				x + (width / 2) - (g.getFontMetrics(Main.getFont().deriveFont(5f)).stringWidth("Health:") / 2), y - 5,
				g.getColor(), Color.BLACK, 1);

		g.setColor(Color.BLACK);
		//
		g.drawRect(x, y, width, height);

		//

		//
		// double s = (health/maxhealth)*100;
		//
		// int a = (int) s;
		//
		//
		// int bar = (int) (health * (width / maxhealth));
		// width = (int) (maxhealth * (width / maxhealth));
		//
		// // g.drawRect(x, y, ((health/2)), 5);
		//
		//
		//
		//
		//
		// if (a >= 75)
		// g.setColor(Color.GREEN);
		// if (a < 75 && health >= 25)
		// g.setColor(Color.YELLOW);
		// if (a < 25)
		// g.setColor(Color.RED);
		//
		// g.fillRect(x, y, bar, height);

		g.setColor(c);

	}

	@Override
	public void move() {

		onground = false;

		getPolygon();

		try {
			for (Sprite s : Main.getScreen().objects) {
				if (s == this)
					continue;
				if (!bounds.intersects(s.getPolygon().getBounds()))
					continue;
				else
					onground = true;
			}
		} catch (ConcurrentModificationException ex) {
			Utils.debug("ConcurrentModificationException 1 (Entity)");
		}

		if (!onground)
			setVelocity("", velocity.y - 0.5);
		if (onground) {
			falling = false;
			setVelocity("", 0);
		}
		dy = velocity.y;
		dx = velocity.x;

		y = (int) (y + dy);
		x = (int) (x + dx);

		dx = 0;
		dy = 0;

	}

	public Tool getTool() {
		return tool;
	}

	// public void interact(){
	// if(interact != null){
	// interact.run();
	// }
	// }

	// public void removeTool(Tool tool) {
	// tool.setEntity(null);
	// this.tool = null;
	// if(exists) tool.remove();
	//
	// if(this instanceof Player){
	// Bridge.getPlayer().inventory.remove(tool);
	// }
	// }

}
