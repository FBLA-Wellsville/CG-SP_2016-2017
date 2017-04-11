package io.github.trinnorica.entity;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ConcurrentModificationException;
import java.util.Timer;
import java.util.TimerTask;

import io.github.trinnorica.Main;
import io.github.trinnorica.objects.Collidable;
import io.github.trinnorica.objects.FallingFloor;
import io.github.trinnorica.objects.Flag;
import io.github.trinnorica.objects.GoldCoin;
import io.github.trinnorica.objects.Ladder;
import io.github.trinnorica.utils.Board;
import io.github.trinnorica.utils.DamageReason;
import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.Sound;
import io.github.trinnorica.utils.Utils;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.formats.Shoot;
import io.github.trinnorica.utils.sprites.Keyable;
import io.github.trinnorica.utils.sprites.Moveable;
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
	public boolean jumping = false;
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
		health = 20;
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
		if (y + height + 29 >= 570 & !jumping) {
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
					if (damaged) {
						setVelocity(0, 0);
					}
					damaged = false;
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
					if (!tooling) {
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
				if (s instanceof Collidable) {
					if (damaged && !jumping) {
						setVelocity(0, 0);

					}
					damaged = false;

					switch (getIntercectingDirection(xbounds.getBounds(), s.getPolygon().getBounds())) {
					case DOWN:
						if (!jumping && (bounds.intersects(s.getPolygon().getBounds()))) {
							y = s.getY() - getHeight() + 1;
							onground = true;
						}
						break;
					case LEFT:
						if (left && !falling)
							velocity.x = 0;

						break;
					case RIGHT:
						if (right && !jumping && !falling)
							velocity.x = 0;
						break;
					default:
						break;
					}

				}
			}
		} catch (ConcurrentModificationException ex) {
			Utils.debug("ConcurrentModificationException 1 (Player)");
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

	@Override
	public void draw(Graphics g) {
		drawHealthBar(g, x - (100 / 2) + (width / 2), y - 20, 100, 5);
		if (cooldown > 0)
			cooldown = cooldown - 1;
		if (direction == Direction.RIGHT) {
			g.drawImage(getImage(), x, y, width, height, null);

			if (utool && cooldown == 0) {
				utoolt = utoolt - 1;
				if (utoolt == 0) {
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
				tool.use(x, y, new Velocity(-8, -2), this);
			}
			if (direction.equals(Direction.RIGHT)) {
				tool.use(x, y, new Velocity(8, -2), this);
			}

		}
		if (tool.getToolType().equals(ToolType.DIRECTIONAL)) {
			tool.use(x, y, direction, new Shoot(), this);
		}
		if (tool.getToolType().equals(ToolType.MELEE)) {
			tool.use(x, y);
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
			if (tool != null && !utool) {
				useTool();
			}
		}

		if (key == KeyEvent.VK_SPACE && onground) {
			jumping = true;
			onground = false;
			setVelocity("", -5 - (s / 10));
		}

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
			Utils.debug("TESTIMG");
		}
	}

}
