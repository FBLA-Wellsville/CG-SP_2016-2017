package io.github.trinnorica.entity;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.KeyEvent;

import io.github.trinnorica.Main;
import io.github.trinnorica.objects.Collidable;
import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.Images;
import io.github.trinnorica.utils.Utils;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.sprites.Keyable;
import io.github.trinnorica.utils.sprites.Moveable;
import io.github.trinnorica.utils.sprites.Sprite;
import io.github.trinnorica.utils.sprites.Tool;
import res.ExternalFile;

public class Player extends Entity implements Moveable, Keyable {

	double dx = 0;
	double dy = 0;
	boolean falling = false;
	public boolean onground = false;
	private Velocity velocity = new Velocity(0, 0);
	public boolean jumping = false;
	public boolean flying = false;
	private boolean climbing = false;
	private Polygon xbounds;
	private Tool tool;
	private int s = 1;
	private boolean utool = false;
	private int utoolt = 0;
	private int cooldown = 0;
	private int level = 1;

	public Player(int x, int y) {
		super(x, y);
		initPlayer();
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

	@Override
	public void move() {
		// if(falling)
		// dy=2;
		
		
		if (y + height + 29 >= 540 & !jumping) {
			onground = true;
			y = 540 - height - 29;

		} else {
			onground = false;
		}
		getPolygon();
		for (Sprite s : Main.getScreen().objects) {
			s.getPolygon();
			if (!(s instanceof Collidable))
				continue;
			if (!bounds.intersects(s.getPolygon().getBounds()))
				continue;
			switch (getIntercectingDirection(s.getPolygon().getBounds())) {
			case DOWN:
				if (!jumping) {
					y = s.getY() - getHeight() + 1;
					onground = true;

				}

				break;
			default:
				break;
			}

		}

		// velocity.x = velocity.x*0.2;
		if (!flying)
			velocity.y = velocity.y + Main.gravity;
		else

		{
//			velocity.y = velocity.y * 0.2;
			// velocity.x = velocity.x*0.02;
		}

		if(velocity.y < 0){
			jumping = true;
		} else jumping = false;
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

	@Override
	public void draw(Graphics g) {
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
		if (direction == Direction.LEFT) {
			tool.use(x, y, new Velocity(-8, -2+velocity.y));
		} else
			tool.use(x, y, new Velocity(8,-2+velocity.y));
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W) {
			if (flying || climbing)
				setVelocity("", -5);
		}

		if (key == KeyEvent.VK_S) {
			if (flying || climbing)
				setVelocity("", 5);
		}

		if (key == KeyEvent.VK_D) {
			direction = Direction.RIGHT;
			setVelocity(3, "");
		}
		if (key == KeyEvent.VK_A) {
			direction = Direction.LEFT;
			setVelocity(-3, "");
		}
		if (key == KeyEvent.VK_SHIFT) {
			if (tool != null && !utool) {
				useTool();
			}
		}

		if (key == KeyEvent.VK_UP) {
			s = s + 1;
			setImageDimensions(27 + s, 30 + s);

		}
		if (key == KeyEvent.VK_DOWN) {
			s = s - 1;
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

		if (key == KeyEvent.VK_1) {
			loadImage(ExternalFile.loadTexture("entity/player/player.png"));
			setImageDimensions(27 + s, 30 + s);
		}

		if (key == KeyEvent.VK_2) {
			loadImage(ExternalFile.loadTexture("entity/player/orge.png"));
			setImageDimensions(27 + s, 30 + s);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_D) {
			setVelocity(0, "");
		}
		if (key == KeyEvent.VK_A) {
			setVelocity(0, "");
		}
		if (key == KeyEvent.VK_W) {
			if(flying)setVelocity("", 0);
		}
		if (key == KeyEvent.VK_S) {
			if(flying)setVelocity("", 0);
		}
	}

	public void setTool(Tool tool) {
		this.tool = tool;

	}

	public Sprite getTool() {
		return tool;
	}

	public int getLevel(){
		return level;
	}
	public void levelup(){
		level = level+1;
	}

}
