package io.github.trinnorica.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ConcurrentModificationException;
import java.util.Timer;
import java.util.TimerTask;

import io.github.trinnorica.Main;
import io.github.trinnorica.objects.FallingFloor;
import io.github.trinnorica.objects.Flag;
import io.github.trinnorica.objects.GoldCoin;
import io.github.trinnorica.objects.Ladder;
import io.github.trinnorica.objects.Switch;
import io.github.trinnorica.objects.doors.Door;
import io.github.trinnorica.objects.tools.Armour;
import io.github.trinnorica.objects.tools.Key;
import io.github.trinnorica.utils.Board;
import io.github.trinnorica.utils.DamageReason;
import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.Sound;
import io.github.trinnorica.utils.Utils;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.formats.Shoot;
import io.github.trinnorica.utils.sprites.Collidable;
import io.github.trinnorica.utils.sprites.Keyable;
import io.github.trinnorica.utils.sprites.Moveable;
import io.github.trinnorica.utils.sprites.PartialCollidable;
import io.github.trinnorica.utils.sprites.Sprite;
import io.github.trinnorica.utils.sprites.SpriteType;
import io.github.trinnorica.utils.sprites.Tool;
import io.github.trinnorica.utils.sprites.ToolType;
import res.Audio;
import res.ExternalFile;

public class Player extends Entity implements Moveable, Keyable {

	double dx = 0;
	double dy = 0;
	public boolean falling = false;
	public boolean onground = false;
	public boolean flying = false;
	public boolean climbing = false;
	private Polygon xbounds;
	private Rectangle sbounds;
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
	private int b = 5;
	int spawnx = 0;
	int spawny = 0;
	Key key = null;
	Armour armour = null;

	public Player(int x, int y) {
		super(x, y);
		this.spawnx = x;
		this.spawny = y;
		this.x = spawnx;
		this.y = spawny;

		initPlayer();
		maxhealth = 20;
		health = maxhealth;
		// TODO Auto-generated constructor stub
	}

	private void initPlayer() {
		loadImage(standing);
		setImageDimensions(27 + s, 30 + s);

	}

	public Polygon getXBounds() {
		xbounds = new Polygon(
				new int[] { ((int) (getPolygon().getBounds().getX() - b)),
						(int) (getPolygon().getBounds().getX() + getPolygon().getBounds().getWidth() + b),
						(int) (getPolygon().getBounds().getX() + getPolygon().getBounds().getWidth() + b),
						(int) (getPolygon().getBounds().getX() - b) },
				new int[] { (int) (getPolygon().getBounds().getY()), (int) (getPolygon().getBounds().getY()),
						(int) (getPolygon().getBounds().getY() + getPolygon().getBounds().getHeight()),
						(int) (getPolygon().getBounds().getY() + getPolygon().getBounds().getHeight()) },
				4);
		// xbounds = new Rectangle((int)getPolygon().getBounds().getX()-1,
		// (int)getPolygon().getBounds().getY()+1, 29, 32);
		return xbounds;
	}

	@Override
	public void kill(DamageReason reason) {
		if (damaged) {
			setVelocity(0, 0);
		}
		damaged = false;
		x = spawnx;
		y = spawny;
		lives = lives - 1;
		health = maxhealth;
		if (lives == 0) {
			Main.deathmessage = reason.getDeathLine();
			Main.setBoard(Board.GAME_OVER);
		}
		setVelocity(0, 0);
		
	}

	public void jump() {
		jumping = true;
		onground = false;
		setVelocity("", -5 - (s / 10));
	}

	public void toss(Direction direction) {
		jumping = true;
		onground = false;
		if (direction.equals(Direction.LEFT)) {
			setVelocity(-2, -5 - (s / 10));
		}
		if (direction.equals(Direction.RIGHT)) {
			setVelocity(2, -5 - (s / 10));
		}

	}

	@Override
	public void move() {
		if(onground){
			if(damaged && !jumping){
				setVelocity(0,0);
				damaged = false;
			}
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
		if (y + height + 29 >= 650 & !jumping) {
			kill(DamageReason.VOID);
		} else {
			onground = false;
		}
		getPolygon();
		climbing = false;
		try {
			for (final Sprite s : Main.getScreen().objects) {
				if (!getXBounds().intersects(s.getPolygon().getBounds()))
					continue;
				if (s instanceof GoldCoin) {
					Main.removeSprite(s);
					Main.score = Main.score + 10;
					Audio.playSound(Sound.SCORE);
				}
				if (s instanceof FallingFloor) {
					Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							((FallingFloor) s).a();
						}
					}, 500);
				}
				if (s instanceof Flag) {
					// TODO
					Utils.sendScore(Main.score);
					levelup();
					continue;
				}
				if (s instanceof Ladder) {
					climbing = true;
					if (damaged || jumping || falling) {
						setVelocity(0, 0);
						jumping = false;
						falling = false;
					}
					damaged = false;
				}

				if (s instanceof Tool) {
					if(s instanceof Armour){
						if (hasArmour()) {
							Main.addSprite(armour);
							armour.x = x;
							armour.y = y - 30;
							armour.velocity.y = -2;
							if (direction.equals(Direction.LEFT))
								armour.velocity.x = 2;
							else
								armour.velocity.x = -2;

						}
						setArmour(((Armour) s));
						Main.removeSprite(s);
					}
					if (s instanceof Key) {
						if (hasKey()) {
							Main.addSprite(key);
							key.x = x;
							key.y = y - 30;
							key.velocity.y = -2;
							if (direction.equals(Direction.LEFT))
								key.velocity.x = 2;
							else
								key.velocity.x = -2;

						}
						setKey(((Key) s));
						Main.removeSprite(s);
					} else if (!tooling && !(s instanceof Armour) && !(s instanceof Key)) {
						tooling = true;
						try {

							getTool().x = x;
							getTool().y = y - 30;
							tool.velocity.y = -2;
							if (direction.equals(Direction.LEFT))
								tool.velocity.x = 2;
							else
								tool.velocity.x = -2;
							Main.addSprite(getTool());
						} catch (NullPointerException ex) {
						}
						setTool((Tool) s);
						Audio.playSound(Sound.TOOL);
						tooling = false;
					}

				}
				if (s instanceof PartialCollidable) {
					

					switch (getIntercectingDirection(xbounds.getBounds(), s.getPolygon().getBounds())) {
					case DOWN:
						if(!((PartialCollidable)s).getCollidableDirections().contains(Direction.DOWN)) break;
						if (!jumping && (bounds.intersects(s.getPolygon().getBounds()))) {
							y = s.getY() - getHeight() + 1;
							onground = true;
						}
						break;
					case LEFT:
						if(!((PartialCollidable)s).getCollidableDirections().contains(Direction.LEFT)) break;
						if (left)
							velocity.x = 0;
						break;
					case RIGHT:
						if(!((PartialCollidable)s).getCollidableDirections().contains(Direction.RIGHT)) break;
						if (right)
							velocity.x = 0;
						break;
					default:
						break;
					}

				}

				if (s instanceof Collidable && ((Collidable)s).isColliding()) {

					switch (getIntercectingDirection(xbounds.getBounds(), s.getPolygon().getBounds())) {
					case DOWN:
						if (!jumping && (bounds.intersects(s.getPolygon().getBounds()))) {
							y = s.getY() - getHeight() + 1;
							onground = true;
						}
						break;
					case LEFT:
						if (left) {
							velocity.x = 0;
							x = (int) s.getPolygon().getBounds().getMaxX();
						}

						break;
					case RIGHT:
						if (right) {
							velocity.x = 0;
							x = s.x - width;
						}
						break;
					case UP:
						velocity.y = 0;
						break;
					default:
						break;
					}

				}
			}
		} catch (ConcurrentModificationException ex) {
		}

		// velocity.x = velocity.x*0.2;
		if (!flying && !climbing)
			if (!(velocity.y >= 10))
				velocity.y = velocity.y + Main.gravity;

		if (flying || climbing) {

			if (onground) {
				if (velocity.y > 0) {
					dy = 0;
				} else {
					dy = velocity.y;
				}
			} else {
				dy = velocity.y;
			}

			dx = velocity.x;

			// if(x <=0 || x>=(Main.getScreen().getWidth()-getWidth())){
			// dx=0;
			// velocity.x =0;
			// if(x<=0){
			// x=1;
			// }
			// if(x>=(Main.getScreen().getWidth()-getWidth())){
			// x=Main.getScreen().getWidth()-getWidth()-1;
			// }
			// }

			y = (int) (y + dy);
			x = (int) (x + dx);

			dx = 0;
			dy = 0;
		}

		else

		{
			if (velocity.y < 0) {
				// jumping = true;
			} else {
				jumping = false;
				falling = true;
			}
			if (onground) {
				falling = false;
				setVelocity("", 0);
			}
			dy = velocity.y;
			dx = velocity.x;

			if (sprint)
				dx = dx * 1.5;

			if (x <= 0 || x >= (Main.getScreen().getWidth() - getWidth())) {
				dx = 0;
				velocity.x = 0;
				if (x <= 0) {
					x = 1;
				}
				if (x + width >= (Main.getScreen().getWidth())) {
					x = Main.getScreen().getWidth() - width - 3;
				}
			}

			y = (int) (y + dy);
			x = (int) (x + dx);

			dx = 0;
			dy = 0;
		}

	}

	private void setKey(Key key) {
		this.key = key;
		key.setUser(this);
	}
	
	public boolean hasArmour() {
		return armour != null;
	}
	
	public void setArmour(Armour armour) {
		this.armour = armour;
		armour.setUser(this);
	}
	public Armour getArmour() {
		return armour;
	}

	@Override
	public void draw(Graphics g) {
		drawHealthBar(g,(int) x - (100 / 2) + (width / 2), (int)y - 20, 100, 5);
		if (cooldown > 0)
			cooldown = cooldown - 1;
		
		if (direction == Direction.RIGHT) {
			g.drawImage(getImage(), (int)x, (int)y, width, height, null);

			if (utool) {
				utoolt = utoolt - 1;
				if (utoolt == 0) {
					utool = false;
				} else {

					if (!tool.getClass().getSimpleName().equalsIgnoreCase("Bow"))
						g.drawImage(ExternalFile.loadTexture("swipe.gif"),(int) x + 30 + tool.width,(int) y, 7 * 2, 15 * 2, null);
					g.drawImage(tool.getImage(),(int) x + 20,(int) y, tool.getWidth(), tool.getHeight(), null);
				}

			}
			
			// if(tool != null) g.drawImage(Images.rotate(tool.getImage(), 0.0),
			// x+20, y, tool.getWidth(), tool.getHeight(), null);
		} else {
			g.drawImage(getImage(),(int) x + width,(int) y, -(width), height, null);
			if (utool) {
				utoolt = utoolt - 1;
				if (utoolt == 0)
					utool = false;
				else {
					if (!tool.getClass().getSimpleName().equalsIgnoreCase("Bow"))
						g.drawImage(ExternalFile.loadTexture("swipe.gif"),(int) x + (7 * 2) - 30,(int) y, -(7 * 2), 15 * 2, null);
					g.drawImage(tool.getImage(), (int)x + tool.getWidth() - 20, (int)y, -tool.getWidth(), tool.getHeight(), null);
				}

				// g.drawImage(ExternalFile.loadTexture("swipe.gif"),
				// x+30+tool.width, y, 7*2 * - tool.width, 15*2, null);
			}
			
			
			
			// if(tool != null) g.drawImage(Images.rotate(tool.getImage(), 0.0),
			// x+tool.getWidth()-20, y, - tool.getWidth(), tool.getHeight(),
			// null);
		}
		if(hasArmour()){
			armour.width = width;
			armour.x = x;
			armour.y = y;
			armour.height = height;
			armour.direction = direction;
			armour.draw(g);
		}
	}

	void useTool() {
		if(cooldown != 0) return;
		utool = true;
		cooldown = tool.getCooldown();
		utoolt = 10;
		// if (tool instanceof FireDagger || tool instanceof IceDagger) {
		// tool.use(x, y, direction, new
		// io.github.trinnorica.utils.particles.formats.Shoot());
		// return;
		// }
		// if (direction == Direction.LEFT) {
		// if (tool instanceof Bow || tool instanceof FireStaff)
		// tool.use(x, y, new Velocity(-8, -2), this);
		// }

		// } else {

		if (tool.getToolType().equals(ToolType.PROJECTILE)) {
			if (direction.equals(Direction.LEFT)) {
				tool.use((int)x, (int)y, new Velocity(-8, -2), this);
			}
			if (direction.equals(Direction.RIGHT)) {
				tool.use((int)x,(int) y, new Velocity(8, -2), this);
			}

		}
		if (tool.getToolType().equals(ToolType.DIRECTIONAL)) {
			tool.use((int)x,(int) y, direction, new Shoot(), this);
		}
		if (tool.getToolType().equals(ToolType.MELEE)) {
			tool.use((int)x,(int) y);
		}

		// }
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_CONTROL) {
			sprint = true;
		}

		if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
			if (flying || climbing)
				setVelocity("", -2);
		}

		if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
			if (flying || climbing)
				setVelocity("", 2);
		}

		if (!damaged) {
			if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
				direction = Direction.RIGHT;
				right = true;
				setVelocity(3, "");
			}
			if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
				direction = Direction.LEFT;
				left = true;
				setVelocity(-3, "");
			}
		}
		if (key == KeyEvent.VK_SHIFT) {

			for (Sprite s : Main.getScreen().objects) {
				if (!getStrikeRange().getBounds().intersects(s.getPolygon().getBounds()))
					continue;
				
				if(s instanceof Switch){
					((Switch)s).toggle();
					return;
				}
				
				if (hasKey()) {
					getKey().x = x;
					getKey().y = y;

					getKey().registerXBounds();
					if ((s instanceof Door)) {

						if (((Door) s).getID() == getKey().getID()) {
							((Door) s).open();
							removeKey();
							Utils.addStaticMessage("You have opened the door!",
									Main.getScreen().getWidth() / 2 - (Main.getScreen().getGraphics().getFontMetrics()
											.stringWidth("You have opened the door!") / 2),
									Main.getScreen().getHeight() - 50, Color.WHITE, Color.BLACK, 1, 10);

						} else
							Utils.addStaticMessage("You can't open this door!",
									Main.getScreen().getWidth() / 2 - (Main.getScreen().getGraphics().getFontMetrics()
											.stringWidth("You don't have the right key to open this door!") / 2),
									Main.getScreen().getHeight() - 50, Color.WHITE, Color.BLACK, 1, 10);
						return;
					}

				}

			}

			if (tool != null && !utool) {
				useTool();
			}
		}

		if (key == KeyEvent.VK_SPACE && onground) {
			jumping = true;
			onground = false;
			setVelocity("", -5 - (s / 10));
		}

		if (key == KeyEvent.VK_K) {
			levelup();
		}

	}

	public Rectangle getStrikeRange() {

		if (direction == Direction.LEFT) {
			return new Rectangle((int)x - 30,(int) y, 60, 30);
		}
		if (direction == Direction.RIGHT) {
			return new Rectangle((int)x, (int)y, 60, 30);
		}
		return null;
	}

	private void removeKey() {
		key = null;
	}

	@Override
	public SpriteType getType() {
		return SpriteType.PLAYER;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (!damaged) {
			if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
				right = false;
				setVelocity(0, "");
			}
			if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
				left = false;
				setVelocity(0, "");
			}
		}
		if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
			if (flying || climbing)
				setVelocity("", 0);
		}
		if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
			if (flying || climbing)
				setVelocity("", 0);
		}
		if (key == KeyEvent.VK_CONTROL) {
			sprint = false;
		}
	}

	public int getLevel() {
		return Utils.getLevel();
	}

	public void levelup() {
		Main.setBoard(Board.LEVELUP);

	}

	public int getMaxLives() {
		return MAXLIVES;
	}

	public int getLives() {
		return lives;
	}

	public void remove() {
		x = 100000;
		y = 100000;
		try {
			Main.removeSprite(this);
		} catch (NullPointerException ex) {
		}
	}

	public boolean hasKey() {
		return (key != null);
	}

	public Key getKey() {
		return key;
	}

	public void setMaxLives(int i) {
		MAXLIVES = i;
		lives = i;
	}

}