package io.github.trinnorica.entity;

import java.awt.Graphics;
import java.util.Random;

import io.github.trinnorica.Main;
import io.github.trinnorica.objects.Flag;
import io.github.trinnorica.objects.tools.Armour;
import io.github.trinnorica.objects.tools.Bow;
import io.github.trinnorica.objects.tools.DarkSword;
import io.github.trinnorica.objects.tools.FireStaff;
import io.github.trinnorica.objects.tools.Stick;
import io.github.trinnorica.objects.tools.Sword;
import io.github.trinnorica.utils.DamageReason;
import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.sprites.Collidable;
import io.github.trinnorica.utils.sprites.EntityType;
import io.github.trinnorica.utils.sprites.Moveable;
import io.github.trinnorica.utils.sprites.PartialCollidable;
import io.github.trinnorica.utils.sprites.Sprite;
import io.github.trinnorica.utils.sprites.SpriteType;
import io.github.trinnorica.utils.sprites.ToolType;
import io.github.trinnorica.utils.tasks.AsyncAttack;
import res.ExternalFile;

public class Enemy extends Entity implements Moveable {

	double dx = 0;
	double dy = 0;
	boolean falling = false;
	public boolean onground = false;
	
	private int s = 1;
	private EntityType type;
	public boolean cooldown = false;
	private Random random = new Random();
	private boolean follow = true;
	private boolean walk = true;

	public Enemy(int x, int y, EntityType type) {
		super(x, y);
		initEntity();
		this.type = type;
		switch (type) {
		case WIZARD:
			walking = ExternalFile.loadTexture("entity/wizard/walking.gif");
			standing = ExternalFile.loadTexture("entity/wizard/standing.png");
			maxhealth = 100;
			setTool(new FireStaff(0, 0, ToolType.PROJECTILE));
			break;
		case KNIGHT:
			walking = ExternalFile.loadTexture("entity/knight/walk.gif");
			standing = ExternalFile.loadTexture("entity/knight/bobbing.gif");
			maxhealth = 10;
			setTool(new Sword(0, 0, ToolType.MELEE));
			break;
		case DARK_KNIGHT:
			walking = ExternalFile.loadTexture("entity/knight/dark/walk.gif");
			standing = ExternalFile.loadTexture("entity/knight/dark/bobbing.gif");
			maxhealth = 100;
			setTool(new DarkSword(0, 0, ToolType.MELEE));
			break;
		case OGRE:
			follow = false;
			direction = Direction.LEFT;
			walking = ExternalFile.loadTexture("entity/ogre/walk.gif");
			standing = ExternalFile.loadTexture("entity/ogre/bobbing.gif");
			maxhealth = 5;
			setTool(new Stick(0, 0, ToolType.MELEE));
			break;
		case MEGA_OGRE:
			follow = false;
			direction = Direction.LEFT;
			walking = ExternalFile.loadTexture("entity/ogre/mega/stand.png");
			standing = ExternalFile.loadTexture("entity/ogre/mega/stand.png");
			maxhealth = 10;
			setTool(new Sword(0, 0, ToolType.MELEE));
			break;
		case SKELETON:
			walk = false;
			walking = ExternalFile.loadTexture("entity/skeleton/walk.gif");
			standing = ExternalFile.loadTexture("entity/skeleton/bobbing.gif");
			maxhealth = 1;
			setTool(new Bow(0, 0, ToolType.PROJECTILE));
			break;
		default:
			walking = ExternalFile.loadTexture("entity/knight/walk.gif");
			standing = ExternalFile.loadTexture("entity/knight/bobbing.gif");
			maxhealth = 10;
			setTool(new Sword(0, 0, ToolType.MELEE));
			break;

		}
		health = maxhealth;
		
		attack(Main.getPlayer());
	}

	private void initEntity() {
		loadImage(standing);
		setImageDimensions(27 + s, 30 + s);
		doFireTicks();

	}

	@Override
	public void move() {
		
		boolean temp_down = false;

		
		
		
		
		if(jumping && velocity.y <= 0){
			jumping = false;
		}
		
		if(x + width >= Main.getScreen().getWidth()){
			x = (Main.getScreen().getWidth()-width-1);
			velocity.x = 0;
			if(!follow){
				direction = Direction.LEFT;
			}	
		}
		
		if(!walk){
			
			if (velocity.x != 0) {
				if (moving == false) {
					moving = true;
					loadImage(walking);
				}
			} else {
				if (moving) {
					loadImage(standing);
					moving = false;
				}
			}
			

			if(tool.getToolType().equals(ToolType.DIRECTIONAL) || tool.getToolType().equals(ToolType.PROJECTILE))attack(Main.getPlayer());

			
			for (Sprite s : Main.getScreen().objects) {
				if (!getPolygon().intersects(s.getPolygon().getBounds()))
					continue;

				if (s instanceof PartialCollidable) {
					onground = true;
					y = s.getY() - this.getHeight() + 1;
					
					

				}
			}
			if (velocity.y <= 0)
				onground = false;

			if (onground) {
				if(follow){
					if (x > Main.getPlayer().x) {
						direction = Direction.LEFT;	
					}
					if (x < Main.getPlayer().x) {
						direction = Direction.RIGHT;	
					}
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
				setVelocity("", 0);
			
			
			return;
		}
		
		
		if (velocity.x != 0) {
			if (moving == false) {
				moving = true;
				loadImage(walking);
			}
		} else {
			if (moving) {
				loadImage(standing);
				moving = false;
			}
		}
		

		attack(Main.getPlayer());

		
		for (Sprite s : Main.getScreen().objects) {
			if (!getPolygon().intersects(s.getPolygon().getBounds()))
				continue;

			if (s instanceof PartialCollidable) {
				
				
				if (damaged) {
					setVelocity(0, 0);

				}
				damaged = false;
				switch (getIntercectingDirection(bounds.getBounds(), s.getPolygon().getBounds())) {
				
				case DOWN:
					if(!((PartialCollidable)s).getCollidableDirections().contains(Direction.DOWN)) break;
					if (!jumping && (bounds.intersects(s.getPolygon().getBounds()))) {
						y = s.getY() - getHeight() + 1;
						temp_down = true;
					}
					break;
				case LEFT:
					
					if(!((PartialCollidable)s).getCollidableDirections().contains(Direction.LEFT)) break;
					if(follow){
						jump();
					}
					if (direction.equals(Direction.LEFT)){
						velocity.x = 0;
						x=(int) s.getPolygon().getBounds().getMaxX();
						if(!follow){
							direction = Direction.RIGHT;
						}
					}

					break;
				case RIGHT:
					if(!((PartialCollidable)s).getCollidableDirections().contains(Direction.RIGHT)) break;
					if(follow){
						jump();
					}
					if (direction.equals(Direction.RIGHT)){
						velocity.x = 0;
						x=(int) ((int) s.getPolygon().getBounds().getX()-bounds.getBounds().getWidth());
						if(!follow){
							direction = Direction.LEFT;
						}
					}
					break;
				case UP:
					if(!((PartialCollidable)s).getCollidableDirections().contains(Direction.UP)) break;
					velocity.y = 0;
					break;
				default:
					break;
				}

			}
			if (s instanceof Collidable && ((Collidable)s).isColliding()) {
				
				if (damaged) {
					setVelocity(0, 0);

				}
				damaged = false;

				switch (getIntercectingDirection(bounds.getBounds(), s.getPolygon().getBounds())) {
				case DOWN:
					if (!jumping && (bounds.intersects(s.getPolygon().getBounds()))) {
						y = s.getY() - getHeight() + 1;
						onground = true;
					}
					break;
				case LEFT:
					if (direction.equals(Direction.LEFT)){
						velocity.x = 0;
						x=(int) s.getPolygon().getBounds().getMaxX();
						if(!follow){
							direction = Direction.RIGHT;
						}
					}

					break;
				case RIGHT:
					if (direction.equals(Direction.RIGHT)){
						velocity.x = 0;
						x=(int) ((int) s.getPolygon().getBounds().getX()-bounds.getBounds().getWidth());
						if(!follow){
							direction = Direction.LEFT;
						}
					}
					break;
				case UP:
					velocity.y = 0;
					break;
				default:
					break;
				}

			}
			if(s instanceof Player){
				attack(((Player)s));
			}
		}
		if (velocity.y <= 0)
			onground = false;

		if (true) {
			if(follow){
				if (x > Main.getPlayer().x) {
					setVelocity(-1, "");
					direction = Direction.LEFT;
				}
				if (x < Main.getPlayer().x) {
					setVelocity(1, "");
					direction = Direction.RIGHT;
				}
			}
			if(direction.equals(Direction.LEFT)) velocity.x = -1;
			if(direction.equals(Direction.RIGHT)) velocity.x = 1;
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
			setVelocity("", 0);
		
		onground = temp_down;
		
		

	}

	
	private void jump() {
		if(onground){
			onground = false;
			jumping = true;
			velocity.y = -5 - (s / 10);
		}
	}

	private void attack(Entity e) {
		
		
		
		if(Main.getPlayer() == null) return;
		if(!cooldown){
			
			cooldown = true;
			new Thread(new AsyncAttack(this, e)).start();
			new java.util.Timer().schedule(new java.util.TimerTask() {
				@Override
				public void run() {
					cooldown = false;
				}
			}, (random.nextInt(6)+1) * 500);
		}
		

	
	}

	@Override
	public void kill(DamageReason reason) {
		if (new Random().nextInt(10) <= 2) {
			tool.x = x;
			tool.y = y;

			Main.addSprite(tool);
		}
		if (new Random().nextInt(100) <= 10) {
			if(type.equals(EntityType.KNIGHT)){
				Main.addSprite(new Armour((int)x, (int)y, ToolType.NONE, Armour.IRON));
			}
		}
		if(type.equals(EntityType.DARK_KNIGHT)){
			Main.addSprite(new Flag((int)x, (int)y, Flag.FLAG));
		}
		super.kill(reason);
	}

	@Override
	public SpriteType getType(){
		return type.getSpriteType();
	}
	@Override
	public void draw(Graphics g) {
		if (velocity.x != 0)
			loadImage(walking);
		else
			loadImage(standing);
		if (direction == Direction.RIGHT) {

			g.drawImage(getImage(), (int)x,(int) y, width, height, null);
			g.drawImage(tool.getImage(),(int) x + 20, (int)y, tool.getWidth(), tool.getHeight(), null);
		} else {
			g.drawImage(getImage(),(int)x + width, (int)y, -(width), height, null);
			g.drawImage(tool.getImage(),(int) x + 7,(int) y, -tool.getWidth(), tool.getHeight(), null);
		}

		drawHealthBar(g,(int) x - 50 + (width / 2),(int) y - 20, 100, 5);

	}

	public EntityType getEntityType() {return this.type;}

	

	

}
