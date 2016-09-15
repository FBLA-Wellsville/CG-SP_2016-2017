package io.github.trinnorica.entity;

import java.awt.Color;
import java.awt.Graphics;

import io.github.trinnorica.utils.Sprite;

public class Entity extends Sprite {

	public double health;
	public double maxhealth;
	protected boolean dead = false;
	public boolean invisible = false;
	protected int score;
//	protected Tool tool;
	public boolean walking;
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
//		Utils.displayMessage(new Random().nextInt(), "-" + i, x, y, 100, "#FF0000", 15,Bridge.getGame().getFont());
//		Utils.displayMessage(new Random().nextInt(), getHealth() + "/" + getMaxHealth(), x, y - 15, 100, "#FF0000", 15,Bridge.getGame().getFont());
//		if (health <= 0) {
//			this.kill(reason);
//			if (damager instanceof Player) {
//				((Player) damager).addScore(score);
//			}
//		}
//
//	}

//	public void damage(int i, DamageReason reason) {
//		health = health - i;
//		Utils.displayMessage(new Random().nextInt(), "-" + i, x, y, 100, "#FF0000", 15,Bridge.getGame().getFont());
//		Utils.displayMessage(new Random().nextInt(), getHealth() + "/" + getMaxHealth(), x, y - 15, 100, "#FF0000", 15,Bridge.getGame().getFont());
//
//		if (health <= 0) {
//			this.kill(reason);
//		}
//
//	}

//	public void kill(DamageReason reason) {
//		this.remove();
//		dead = true;
//		interact();
//	}

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
