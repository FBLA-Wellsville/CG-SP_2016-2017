package io.github.trinnorica.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import io.github.trinnorica.Main;
import io.github.trinnorica.objects.Collidable;
import io.github.trinnorica.objects.tools.Bow;
import io.github.trinnorica.objects.tools.DarkSword;
import io.github.trinnorica.objects.tools.Stick;
import io.github.trinnorica.objects.tools.Sword;
import io.github.trinnorica.utils.DamageReason;
import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.sprites.EntityType;
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
	private Image walking;
	
	private Image standing;
	private EntityType type;

	public Enemy(int x, int y,EntityType type) {
		super(x, y);
		initEntity();
		this.type = type;
		switch(type){
		case KNIGHT:
			walking = ExternalFile.loadTexture("entity/knight/walk.gif");
			standing = ExternalFile.loadTexture("entity/knight/bobbing.gif");
			maxhealth = 10;
			tool = new Sword(0,0);
			break;
		case DARK_KNIGHT:
			walking = ExternalFile.loadTexture("entity/knight/dark/walk.gif");
			standing = ExternalFile.loadTexture("entity/knight/dark/bobbing.gif");
			maxhealth = 10;
			tool = new DarkSword(0,0);
			break;
		case OGRE:
			walking = ExternalFile.loadTexture("entity/ogre/walk.gif");
			standing = ExternalFile.loadTexture("entity/ogre/bobbing.gif");
			maxhealth = 10;
			tool = new Stick(0,0);
			break;
		case SKELETON:
			walking = ExternalFile.loadTexture("entity/skeleton/walk.gif");
			standing = ExternalFile.loadTexture("entity/skeleton/bobbing.gif");
			maxhealth = 10;
			tool = new Bow(0,0);
			break;
		default:
			walking = ExternalFile.loadTexture("entity/knight/walk.gif");
			standing = ExternalFile.loadTexture("entity/knight/bobbing.gif");
			maxhealth = 10;
			tool = new Sword(0,0);
			break;
			
		}
	}

	private void initEntity() {
		loadImage(standing);
		setImageDimensions(27 + s, 30 + s);
		
		health = maxhealth;
	}

	@Override
	public void move() {
		onground = false;

		for (Sprite s : Main.getScreen().objects) {
			if (!getPolygon().intersects(s.getPolygon().getBounds()))
				continue;

			if((s instanceof Entity && !(s instanceof Enemy))){
				attack((Entity) s);
			}
			if (s instanceof Collidable) {
				onground = true;
				y = s.getY() - this.getHeight() + 1;

			}
		}
		if (velocity.y <= 0)
			onground = false;

		if (onground) {
			if (x > Main.getPlayer().x) {
				setVelocity(-2, "");
				direction = Direction.LEFT;
			}
			if (x < Main.getPlayer().x) {
				setVelocity(2, "");
				direction = Direction.RIGHT;
			}
		}
		dy = velocity.y;
		dx = velocity.x;

		y = (int) (y + dy);
		x = (int) (x + dx);

		dx = 0;
		dy = 0;

		if (!onground)
			velocity.y = velocity.y + 0.2;

		// Utils.debug("X: " + velocity.x + "\nY: " + velocity.y);
		if (onground)
			setVelocity(0, 0);

	}

	private void attack(Entity e) {
		e.damage(3, DamageReason.ENEMY, this);
		
		
	}

	@Override
	public void kill(DamageReason reason) {
		if (new Random().nextInt(10) <= 2)
			Main.addSprite(new DarkSword(x, y));
		Main.removeSprite(this);
	}

	@Override
	public void draw(Graphics g) {
		if (velocity.x != 0)
			loadImage(walking);
		else
			loadImage(standing);

		if (direction == Direction.RIGHT) {

			g.drawImage(getImage(), x, y, width, height, null);
			g.drawImage(tool.getImage(), x + 20, y, tool.getWidth(), tool.getHeight(), null);
		} else {
			g.drawImage(getImage(), x + width, y, -(width), height, null);
			g.drawImage(tool.getImage(), x + 7, y, -tool.getWidth(), tool.getHeight(), null);
		}
		
		drawHealthBar(g, x-50+(width/2), y-20, 100, 5);

		

	}

	public void setTool(Tool tool) {
		this.tool = tool;

	}

	public Sprite getTool() {
		return tool;
	}

}
