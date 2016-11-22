package io.github.trinnorica.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ConcurrentModificationException;

import io.github.trinnorica.Main;
import io.github.trinnorica.utils.DamageReason;
import io.github.trinnorica.utils.Utils;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.ParticleType;
import io.github.trinnorica.utils.particles.formats.Explode;
import io.github.trinnorica.utils.particles.formats.Stay;
import io.github.trinnorica.utils.sprites.Moveable;
import io.github.trinnorica.utils.sprites.Sprite;

public class Entity extends Sprite implements Moveable {

	public double health;
	public double maxhealth;
	protected boolean dead = false;
	public boolean invisible = false;
	boolean onground = false;
	boolean falling = false;
	
	double dx = 0;
	double dy = 0;
	
	protected int score;
//	protected Tool tool;
	public boolean walking;
	public Velocity velocity = new Velocity(0,0);
//	protected Direction direction = Direction.RIGHT;
//	protected Direction facing = Direction.RIGHT;
//	protected Interaction interact;

	public Entity(int x, int y) {
		super(x, y);
	}

	public int getHealth() {
		return (int)health;
	}

	public int getMaxHealth() {
		return (int) maxhealth;
	}
	
//	public Direction getFacingDirection(){
//		return facing;
//	}

//	public void damage(int i, Entity damager, DamageReason reason) {
//		health = health - i;
//		setVelocity(new Velocity(0, -1));
////		Utils.displayMessage(new Random().nextInt(), "-" + i, x, y, 100, "#FF0000", 15,Bridge.getGame().getFont());
////		Utils.displayMessage(new Random().nextInt(), getHealth() + "/" + getMaxHealth(), x, y - 15, 100, "#FF0000", 15,Bridge.getGame().getFont());
//		if (health <= 0) {
//			this.kill(reason);
////			if (damager instanceof Player) {
////				((Player) damager).addScore(score);
////			}
//		}
//
//	}

	public void damage(int i, DamageReason reason, Entity damager) {
		health = health - i;
		if(damager.x - x >= 0)
			setVelocity(new Velocity(-2, -3));
		else 
			setVelocity(new Velocity(2, -3));
		
//		Utils.displayMessage(new Random().nextInt(), "-" + i, x, y, 100, "#FF0000", 15,Bridge.getGame().getFont());
//		Utils.displayMessage(new Random().nextInt(), getHealth() + "/" + getMaxHealth(), x, y - 15, 100, "#FF0000", 15,Bridge.getGame().getFont());
//
		if (health <= 0) {
			this.kill(reason);
		}

	}
	public void damage(int i, DamageReason reason, Entity damager, Velocity v) {
		health = health - i;
		setVelocity(v);
//		Utils.displayMessage(new Random().nextInt(), "-" + i, x, y, 100, "#FF0000", 15,Bridge.getGame().getFont());
//		Utils.displayMessage(new Random().nextInt(), getHealth() + "/" + getMaxHealth(), x, y - 15, 100, "#FF0000", 15,Bridge.getGame().getFont());
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
		Utils.runParticles(new Point(x,y), new Explode(2), ParticleType.BLOOD, null);
		Main.removeSprite(this);
//		dead = true;
//		Utils.debug("DEATH");
//		interact();
	}

//	public Tool getTool() {
//		return tool;
//	}

//	public void setTool(Tool tool) {
//		tool.setEntity(this);
//		this.tool = tool;
//
//	}

//	public boolean hasTool() {
//		if (tool == null)
//			return false;
//		else
//			return true;
//	}

//	public void setDirection(Direction d) {
//		direction = d;
//	}

//	public Direction getDirection() {
//		return direction;
//	}

//	public boolean isInvisible() {
//		return invisible;
//	}

//	public void toggleInvisiblility() {
//		if (!invisible) {
//			invisible = true;
//			if (!walking)
//				loadImage(Images.makeImageTranslucent(Images.toBufferedImage(getImage()), 0.5));
//
//		} else {
//			invisible = false;
//			if (!walking) {
//				if (this instanceof Player) {
//
//					loadImage("playermodels/yellow/stand_" + direction.toString().toLowerCase() + ".png");
//				}
//			}
//
//		}
//	}

	public void drawHealthBar(Graphics g, int x, int y, int width, int height) {

		Color c = g.getColor();
		
		double s = (health/maxhealth)*100;

		int a = (int) s;
		

		int bar = (int) (health * (width / maxhealth));
		width =  (int) (maxhealth * (width / maxhealth));

		// g.drawRect(x, y, ((health/2)), 5);
		
		
		
		
		
		g.drawRect(x, y, width, height);
		if (a >= 75)
			g.setColor(Color.GREEN);
		if (a < 75 && health >= 25)
			g.setColor(Color.YELLOW);
		if (a < 25)
			g.setColor(Color.RED);

		g.fillRect(x, y, bar, height);

		g.setColor(c);

	}

	@Override
	public void move() {
		

		onground = false;
		
		
		getPolygon();
		
		try{
			for (Sprite s : Main.getScreen().objects) {
				if(s == this) continue;
				if(!bounds.intersects(s.getPolygon().getBounds())) continue;
				else onground = true;
			}
		} catch(ConcurrentModificationException ex){
			Utils.debug("ConcurrentModificationException 1 (Entity)");
		}

		if (!onground)
			setVelocity("", velocity.y-0.5);
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

	

	
	
//	public void interact(){
//		if(interact != null){
//			interact.run();
//		}
//	}

//	public void removeTool(Tool tool) {
//		tool.setEntity(null);
//		this.tool = null;
//		if(exists) tool.remove();
//		
//		if(this instanceof Player){
//			Bridge.getPlayer().inventory.remove(tool);
//		}
//	}

	
	
	

}
