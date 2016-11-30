package io.github.trinnorica.entity;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ConcurrentModificationException;

import io.github.trinnorica.Main;
import io.github.trinnorica.objects.Collidable;
import io.github.trinnorica.objects.Flag;
import io.github.trinnorica.objects.Ladder;
import io.github.trinnorica.objects.tools.Bow;
import io.github.trinnorica.objects.tools.DarkSword;
import io.github.trinnorica.objects.tools.FireDagger;
import io.github.trinnorica.objects.tools.FireStaff;
import io.github.trinnorica.objects.tools.IceDagger;
import io.github.trinnorica.utils.Board;
import io.github.trinnorica.utils.DamageReason;
import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.Utils;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.Particle;
import io.github.trinnorica.utils.sprites.EntityType;
import io.github.trinnorica.utils.sprites.Keyable;
import io.github.trinnorica.utils.sprites.Moveable;
import io.github.trinnorica.utils.sprites.Projectile;
import io.github.trinnorica.utils.sprites.Sprite;
import io.github.trinnorica.utils.sprites.Tool;
import res.ExternalFile;

public class Player extends Entity implements Moveable, Keyable {

	double dx = 0;
	double dy = 0;
	boolean falling = false;
	public boolean onground = false;
	public boolean jumping = false;
	public boolean flying = false;
	public boolean climbing = false;
	private Polygon xbounds;
	private Rectangle sbounds;
	private Tool tool;
	int s = 1;
	private boolean utool = false;
	private int utoolt = 0;
	private int cooldown = 0;
	public boolean left = false;
	public boolean right = false;
	private int MAXLIVES = 5;
	private int lives = MAXLIVES;
	private boolean sprint = false;
	private boolean tooling = false;

	public Player(int x, int y) {
		super(x, y);
		initPlayer();
		maxhealth = 20;
		health = maxhealth;
		// TODO Auto-generated constructor stub
	}

	private void initPlayer() {
		loadImage(ExternalFile.loadTexture("entity/player/player.png"));
		setImageDimensions(27 + s, 30 + s);
		xbounds = new Polygon(
				new int[] { (int) (bounds.getBounds().getX() - 1),
						(int) ((int) bounds.getBounds().getX() + (bounds.getBounds().getWidth() + 2)),
						(int) ((int) bounds.getBounds().getX() + (bounds.getBounds().getWidth() + 2)),
						(int) (bounds.getBounds().getX() - 1) },
				new int[] { (int) (bounds.getBounds().getY() - 1), (int) (bounds.getBounds().getY() - 1),
						(int) ((bounds.getBounds().getY() - 1) + bounds.getBounds().getHeight() + 2),
						(int) ((int) ((bounds.getBounds().getY() - 1)) + bounds.getBounds().getHeight() + 2) },
				4);
	}

	
	public void kill(DamageReason reason){
		if(damaged){
			setVelocity(0,0);
		}
		damaged = false;
		x=0;
		y=0;
		lives = lives-1;
		health = 20;
		if(lives == 0){
			Main.deathmessage = reason.getDeathLine();
			Main.setBoard(Board.GAME_OVER);
		}
		setVelocity(0,0);
	}
	
	public void jump(){
		jumping = true;
		onground = false;
		setVelocity("", -5 - (s / 10));
	}
	public void toss(Direction direction){
		jumping = true;
		onground = false;
		if(direction.equals(Direction.LEFT)){
			setVelocity(-2, -5 - (s / 10));
		}
		if(direction.equals(Direction.RIGHT)){
			setVelocity(2, -5 - (s / 10));
		}
		
	}

	@Override
	public void move() {
		
//		if(velocity.x != 0){
//			loadImage(ExternalFile.loadTexture("entity/knight/dark/walk.gif"));
//		} else {
//			loadImage(ExternalFile.loadTexture("entity/knight/dark/bobbing.gif"));
//		}
		
		//If flying through air because of enemy, loop through sprites until lands
//		if(damaged){
//			try{
//				for (Sprite s : Main.getScreen().objects) {
//					if(!bounds.intersects(s.getPolygon().getBounds())) continue;
//					if(s instanceof Flag){
//						levelup();
//						setVelocity(0,0);
//						continue;
//					}
//					if(s instanceof Ladder){
//						damaged = false;
//						setVelocity(0,0);
//					}
//					
//					if(s instanceof Collidable){
//						damaged = false;
//						setVelocity(0,0);
//					}
//				}
//			} catch(ConcurrentModificationException ex){
//				Utils.debug("ConcurrentModificationException 1 (Player)");
//			}
//		} else {
			if (y + height + 29 >= 570 & !jumping) {
				kill(DamageReason.VOID);
			} else {
				onground = false;
			}
			getPolygon();
			climbing = false;
			try{
				for (Sprite s : Main.getScreen().objects) {
					if(!bounds.intersects(s.getPolygon().getBounds())) continue;
					if(s instanceof Flag){
						levelup();
						if(damaged){
							setVelocity(0,0);
						}
						damaged = false;
						continue;
					}
					if(s instanceof Ladder){
						climbing = true;
						if(damaged){
							setVelocity(0,0);
						}
						damaged = false;
					}
					if(s instanceof Tool){
						if(!tooling){
							tooling = true;
							try{
								
								getTool().x = x;
								getTool().y = y-30;
								tool.velocity.y = -2;
								if(direction.equals(Direction.LEFT))
									tool.velocity.x = 2;
								else tool.velocity.x = -2;
								Main.addSprite(getTool());
							} catch(NullPointerException ex){
								//This just means that the player doesn't have a tool in their hand.
							}
							setTool((Tool) s);
							
							tooling = false;
						}
						
					}
					if(s instanceof Collidable){
						if(damaged && !jumping){
							setVelocity(0,0);
						}
						damaged = false;
						switch (getIntercectingDirection(s.getPolygon().getBounds())) {
						case DOWN:
							if (!jumping && !climbing) {
								y = s.getY() - getHeight() + 1;
								onground = true;
							}
							break;
						case LEFT:
							if(left)velocity.x = 0;
							break;
						case RIGHT:
							if(right)velocity.x = 0;
							break;
							default:
								break;		
						}	
					}
				}
			} catch(ConcurrentModificationException ex){
				Utils.debug("ConcurrentModificationException 1 (Player)");
			}

		
		// velocity.x = velocity.x*0.2;
		if (!flying && !climbing)
			velocity.y = velocity.y + Main.gravity;
		
		if(flying || climbing){
			dy = velocity.y;
			dx = velocity.x;

			y = (int) (y + dy);
			x = (int) (x + dx);

			dx = 0;
			dy = 0;
		}

		else {
			if(velocity.y < 0){
				jumping = true;
			} else jumping = false;
			if (onground) {
				falling = false;
				setVelocity("", 0);
			}
			dy = velocity.y;
			dx = velocity.x;
			
			if(sprint) dx = dx*1.5;
			y = (int) (y + dy);
			x = (int) (x + dx);

			dx = 0;
			dy = 0;
		}

	}

	@Override
	public void draw(Graphics g) {
		drawHealthBar(g, x-(100/2)+(width/2), y-20, 100, 5);
		if(cooldown > 0) cooldown = cooldown - 1;
		if (direction == Direction.RIGHT) {
			g.drawImage(getImage(), x, y, width, height, null);
			
			if (utool && cooldown == 0) {
				utoolt = utoolt - 1;
				if (utoolt == 0){
					utool = false;
				} else {
					
					if (!tool.getClass().getSimpleName().equalsIgnoreCase("Bow")) 
						g.drawImage(ExternalFile.loadTexture("swipe.gif"), x + 30 + tool.width, y, 7 * 2, 15 * 2, null);
					g.drawImage(tool.getImage(), x + 20, y, tool.getWidth(), tool.getHeight(), null);
				}

			}
			// if(tool != null) g.drawImage(Images.rotate(tool.getImage(), 0.0),
			// x+20, y, tool.getWidth(), tool.getHeight(), null);
		} else {
			g.drawImage(getImage(), x + width, y, -(width), height, null);
			if (utool && cooldown == 0) {
				utoolt = utoolt - 1;
				if (utoolt == 0)
					utool = false;
				else {
					if (!tool.getClass().getSimpleName().equalsIgnoreCase("Bow")) 
						g.drawImage(ExternalFile.loadTexture("swipe.gif"), x + (7 * 2) - 30, y, -(7 * 2), 15 * 2, null);
					g.drawImage(tool.getImage(), x + tool.getWidth() - 20, y, -tool.getWidth(), tool.getHeight(), null);
				}

				// g.drawImage(ExternalFile.loadTexture("swipe.gif"),
				// x+30+tool.width, y, 7*2 * - tool.width, 15*2, null);
			}
			// if(tool != null) g.drawImage(Images.rotate(tool.getImage(), 0.0),
			// x+tool.getWidth()-20, y, - tool.getWidth(), tool.getHeight(),
			// null);
		}
	}

	void useTool() {
		utool = true;
		cooldown = tool.getCooldown();
		utoolt = 10;
		if(tool instanceof FireDagger || tool instanceof IceDagger){
			tool.use(x, y, direction,  new io.github.trinnorica.utils.particles.formats.Shoot());
			return;
		}
		if (direction == Direction.LEFT) {
			if(tool instanceof Bow||tool instanceof FireStaff)
				tool.use(x, y, new Velocity(-8, -2), this);
			for(Sprite s : Main.getScreen().objects){
				if(!(s instanceof Particle || s instanceof Projectile))
				if(getStrikeRange().getBounds().intersects(s.getPolygon().getBounds())){
					if(s instanceof Entity) ((Entity)s).damage(tool.getPower(), DamageReason.PROJECTILE, this);
				}
			}
			
		} else{
			
			if(tool instanceof Bow||tool instanceof FireStaff)
				tool.use(x, y, new Velocity(8, -2), this);
			for(Sprite s : Main.getScreen().objects){
				if(!(s instanceof Particle || s instanceof Projectile))
				if(getStrikeRange().getBounds().intersects(s.getPolygon().getBounds())){
					if(s instanceof Entity) ((Entity)s).damage(tool.getPower(), DamageReason.PROJECTILE, this);
				}
			}
		}
	}

	private Rectangle getStrikeRange() {
		
		
		if(direction == Direction.LEFT){
			sbounds = new Rectangle(x-30, y, 30, 30);
			return sbounds;
		}
		if(direction == Direction.RIGHT){
			sbounds = new Rectangle(x+30, y, 30, 30);
			return sbounds;
		}
		return null;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_NUMPAD0){
			lives = lives+1;
			if(lives > MAXLIVES){
				MAXLIVES = lives;
			}
			if(lives <=5){
				MAXLIVES = 5;
			}
		}
		if(key == KeyEvent.VK_NUMPAD1){
			kill(DamageReason.VOID);
		}
		if(key == KeyEvent.VK_CONTROL){
			sprint = true;
		}

		if (key == KeyEvent.VK_W) {
			if (flying || climbing)
				setVelocity("", -5);
		}

		if (key == KeyEvent.VK_S) {
			if (flying || climbing)
				setVelocity("", 5);
		}

		if (!damaged) {
			if (key == KeyEvent.VK_D) {
				direction = Direction.RIGHT;
				right = true;
				setVelocity(3, "");
			}
			if (key == KeyEvent.VK_A) {
				direction = Direction.LEFT;
				left = true;
				setVelocity(-3, "");
			} 
		}
		if (key == KeyEvent.VK_SHIFT) {
			if (tool != null && !utool) {
				useTool();
			}
		}

		if (key == KeyEvent.VK_UP) {
			if(!(health+0.5>maxhealth))health = health+0.5;
			setImageDimensions(27 + s, 30 + s);

		}
		if (key == KeyEvent.VK_DOWN) {
			if(!(health-0.5<0))health = health-0.5;
			setImageDimensions(27 + s, 30 + s);
		}

		if (key == KeyEvent.VK_SPACE && onground) {
			jumping = true;
			onground = false;
			setVelocity("", -5 - (s / 10));
		}

		if (key == KeyEvent.VK_F) {
			if (flying)
				flying = false;
			else
				flying = true;
		}

		if(key == KeyEvent.VK_L){
			Main.addSprite(new Enemy(x,y,EntityType.KNIGHT));
		}
		if(key == KeyEvent.VK_K){
			Main.addSprite(new DarkSword(x+100,y));
		}
		if (key == KeyEvent.VK_1) {
			loadImage(ExternalFile.loadTexture("entity/player/player.png"));
			setImageDimensions(27 + s, 30 + s);
		}

		if (key == KeyEvent.VK_2) {
			loadImage(ExternalFile.loadTexture("entity/knight/knight.png"));
			setImageDimensions(27 + s, 30 + s);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (!damaged) {
			if (key == KeyEvent.VK_D) {
				right = false;
				setVelocity(0, "");
			}
			if (key == KeyEvent.VK_A) {
				left = false;
				setVelocity(0, "");
			} 
		}
		if (key == KeyEvent.VK_W) {
			if(flying || climbing)setVelocity("", 0);
		}
		if (key == KeyEvent.VK_S) {
			if(flying || climbing)setVelocity("", 0);
		}
		if(key == KeyEvent.VK_CONTROL){
			sprint = false;
		}
	}

	public void setTool(Tool tool) {
		this.tool = tool;
		Main.removeSprite(tool);

	}

	public Sprite getTool() {
		return tool;
	}

	public int getLevel(){
		return Utils.getLevel();
	}
	public void levelup(){
		Main.setBoard(Board.LEVELUP);
		
	}

	public int getMaxLives() {
		return MAXLIVES;
	}
	public int getLives() {
		return lives;
	}


}
