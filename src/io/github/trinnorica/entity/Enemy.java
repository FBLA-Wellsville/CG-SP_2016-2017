package io.github.trinnorica.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import io.github.trinnorica.Main;
import io.github.trinnorica.objects.Collidable;
import io.github.trinnorica.objects.tools.DarkSword;
import io.github.trinnorica.utils.DamageReason;
import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.sprites.Moveable;
import io.github.trinnorica.utils.sprites.Sprite;
import io.github.trinnorica.utils.sprites.Tool;
import res.ExternalFile;

public class Enemy extends Entity implements Moveable {

	double dx = 0;
	double dy = 0;
	boolean falling = false;
	public boolean onground = false;
	public boolean jumping = false;
	private Tool tool;
	private int s = 1;
	private Image walking = ExternalFile.loadTexture("entity/knight/walk.gif");
	private Image standing = ExternalFile.loadTexture("entity/knight/bobbing.gif");

	public Enemy(int x, int y) {
		super(x, y);
		initEntity();
		// TODO Auto-generated constructor stub
	}

	private void initEntity() {
		loadImage(standing);
		setImageDimensions(27 + s, 30 + s);
		setTool(new DarkSword(0,0));
		health = 10;
		maxhealth = health;
	}



	@Override
	public void move() {
		onground = false;
		
		if(x > Main.getPlayer().x){
			setVelocity(-2, "");
			direction = Direction.LEFT;
		}
		if(x < Main.getPlayer().x){
			setVelocity(2, "");
			direction = Direction.RIGHT;
		}
		
//		if(velocity.y > 0){
			for(Sprite s : Main.getScreen().objects){
				if(!getPolygon().intersects(s.getPolygon().getBounds())) continue;
			
				if(s instanceof Collidable){
					onground = true;
					y=s.getY()-this.getHeight()+1;
					
				}
			}
//		}
			if(velocity.y <= 0) onground = false;
		
	
		
		dy = velocity.y;
		dx = velocity.x;

		y = (int) (y + dy);
		x = (int) (x + dx);

		dx = 0;
		dy = 0;
		
		if(!onground)velocity.y = velocity.y + 0.2;
		
//		Utils.debug("X: " + velocity.x + "\nY: " + velocity.y);
		if(onground) setVelocity(0, 0);
		
	}
	
	@Override
	public void kill(DamageReason reason){
		if(new Random().nextInt(10) <= 2)Main.addSprite(new DarkSword(x,y));
		Main.removeSprite(this);
	}

	@Override
	public void draw(Graphics g) {
		if(velocity.x != 0) loadImage(walking);
		else loadImage(standing);
		
		if (direction == Direction.RIGHT) {
			
				g.drawImage(getImage(), x, y, width, height, null);
				g.drawImage(tool.getImage(), x + 20, y, tool.getWidth(), tool.getHeight(), null);
			}
		else {
			g.drawImage(getImage(), x + width, y, -(width), height, null);
			g.drawImage(tool.getImage(), x+7, y, -tool.getWidth(), tool.getHeight(), null);
		}
		
		g.drawRect(x-50+(getWidth()/2), y-20, 100, 5);
		
		
		if((int) (health/maxhealth*100) > 66)g.setColor(Color.green);
		if((int) (health/maxhealth*100) < 66 && (int) (health/maxhealth*100) > 33)g.setColor(Color.YELLOW);
		if((int) (health/maxhealth*100) < 33) g.setColor(Color.RED);
		g.fillRect(x-50+(getWidth()/2), y-20, (int) (health/maxhealth*100), 5);
		
		
	}



	public void setTool(Tool tool) {
		this.tool = tool;

	}

	public Sprite getTool() {
		return tool;
	}


	

}
