package io.github.trinnorica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TimerTask;
import java.util.regex.Pattern;

import javax.swing.JPanel;
import javax.swing.Timer;

import io.github.trinnorica.entity.Player;
import io.github.trinnorica.objects.tools.Bow;
import io.github.trinnorica.objects.tools.FireDagger;
import io.github.trinnorica.objects.tools.FireStaff;
import io.github.trinnorica.objects.tools.IceDagger;
import io.github.trinnorica.objects.tools.Sword;
import io.github.trinnorica.utils.Backgrounds;
import io.github.trinnorica.utils.Board;
import io.github.trinnorica.utils.Clickable;
import io.github.trinnorica.utils.Images;
import io.github.trinnorica.utils.Sound;
import io.github.trinnorica.utils.Utils;
import io.github.trinnorica.utils.levels.LevelBuilder;
import io.github.trinnorica.utils.particles.Particle;
import io.github.trinnorica.utils.sprites.Empty;
import io.github.trinnorica.utils.sprites.Keyable;
import io.github.trinnorica.utils.sprites.Moveable;
import io.github.trinnorica.utils.sprites.Sprite;
import res.Audio;
import res.ExternalFile;

public class Screen extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Timer timer;
	// java.util.Timer t;
	int DELAY = 15;
	int INITIALDELAY = 200;
	public boolean debug = false;
	int board = 0;
	int totalFrameCount = 0;
	double menuvar = 0;
	int creditvar = 0;
	static Graphics graphics;
	public List<Sprite> objects = new ArrayList<>();
	public List<Sprite> objects_temp = new ArrayList<>();
	public List<Sprite> objects_remove = new ArrayList<>();
	boolean adding = false;
	boolean test = false;
	private int timeri = 0;
	private int timeril = 1;
	private boolean loading = true;
	private boolean paused = false;
	private Image DIRT = ExternalFile.loadTexture("objects/background/dirt.png");
	private Image DARK = Images.makeImageTranslucent(Images.toBufferedImage(Images.createColorImage("#000000")), 0.5);
	private boolean playing = false;
	private Pattern alphanumeric = Pattern.compile("[^a-zA-Z0-9]");
	private String name = "___";
	private boolean typing = false;
	private int s = 0;

	private boolean leaderboard= true;

	public Screen() {
		init();
	}
	
	public String getName(){
		return name;
	}

	public void init() {

		
		timer = new Timer(INITIALDELAY, this);
		timer.start();

		addKeyListener(new TAdapter());
		addMouseMotionListener(new MMListener());
		addMouseListener(new MListener());

		setLayout(null);

		setFocusable(true);

		setPreferredSize(new Dimension(1920, 1080));

		setSize(new Dimension(1920, 1080));
		setMinimumSize(new Dimension(1920, 1080));

		
		java.util.Timer t = new java.util.Timer();
		t.schedule(new TimerTask() {
			public void run() {
				Main.setBoard(Board.NAME);
			}
		}, 500);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (!paused)
			drawMenu(g);
		else {
			drawPaused(g);
		}
		Toolkit.getDefaultToolkit().sync();
	}

	public void drawPaused(Graphics g) {

		g.setFont(Main.getFont().deriveFont(20f));
		for (int x = 0; x != 32; x++) {
			for (int y = 0; y != 18; y++) {
				g.drawImage(DIRT, x * 30, y * 30, 30, 30, this);
			}
		}
		g.drawImage(DARK, 0, 0, getWidth(), getHeight(), this);

		Utils.drawOutlineString(g, "Press ESC to resume.",
				getWidth() / 2 - (g.getFontMetrics().stringWidth("Press ESC to resume.") / 2), getHeight() / 2,
				Color.decode("#99DB45"), Color.decode("#FFFFFF"), 1);
	}

	// this is where EVERYTHING happens.
	public void drawMenu(Graphics g) {
		graphics = g;

		g.setFont(Main.getFont().deriveFont((float) 20.0));

		if (loading) {
			if (timeril == 1) {
				Utils.drawOutlineString(g, "Loading.",
						getWidth() / 2 - g.getFontMetrics().stringWidth("Loading...") / 2, getHeight() / 2, Color.RED,
						Color.BLACK, 1);
			}
			if (timeril == 2) {
				Utils.drawOutlineString(g, "Loading..",
						getWidth() / 2 - g.getFontMetrics().stringWidth("Loading...") / 2, getHeight() / 2, Color.RED,
						Color.BLACK, 1);
			}
			if (timeril == 3) {
				Utils.drawOutlineString(g, "Loading...",
						getWidth() / 2 - g.getFontMetrics().stringWidth("Loading...") / 2, getHeight() / 2, Color.RED,
						Color.BLACK, 1);
			}

			timeril += 1;
			if (timeril > 3) {
				timeril = 1;
			}
			if (timeri <= new Random().nextInt(20)) {
				timeri += 1;
				return;
			}

			timer.setDelay(DELAY);
			loading = false;

		}

		// Main Menu
		if (board == Board.MAIN) {
			menuvar = Utils.drawScrollingImage(g, Backgrounds.MAIN.getImage(), menuvar, (int) 0, this.getWidth(),
					this.getHeight(), 1);
			Utils.drawOutlineString(g, "Press P to play!",
					getWidth() / 3 - (g.getFontMetrics().stringWidth("Press P to play!") / 2),
					getHeight() / 4 + getHeight() / 2, Color.decode("#99db45"), Color.WHITE, 1);

			Utils.drawOutlineString(g, "Press C for credits!",
					(((getWidth()) + (getWidth() / 2)) / 2)
							- (g.getFontMetrics().stringWidth("Press C for credits!") / 2),
					getHeight() / 4 + getHeight() / 2, Color.decode("#99db45"), Color.WHITE, 1);

			g.drawImage(ExternalFile.loadTexture("entity/knight/dark/standing.png"), getWidth() / 4, getHeight() / 2,
					60, 60, this);
			g.drawImage(ExternalFile.loadTexture("entity/knight/standing.png"), (getWidth() / 4 + getWidth() / 2) + 0,
					getHeight() / 2, -60, 60, this);
			Image logo = ExternalFile.loadTexture("logos/logo-title.png");
			g.drawImage(Images.makeImageTranslucent(Images.toBufferedImage(logo), 0.9),
					this.getWidth() / 2 - logo.getWidth(this) / 2, this.getHeight() / 2 - logo.getHeight(this) / 2,
					this);

		}

		// Credits! :D
		if (board == Board.CREDITS) {
			Utils.drawScrollingImage(g, Backgrounds.MAIN.getImage(), menuvar, (int) 0, this.getWidth(),
					this.getHeight(), 1);

			g.drawImage(DARK, 0, 0, getWidth(), getHeight(), this);
			g.setFont(new Font("Helvetica", Font.BOLD, getWidth() / 50));
			Utils.drawCredit(g, "Author & Developers:", creditvar, 1, Color.BLACK, Color.WHITE, 1);
			g.setFont(new Font("Helvetica", Font.PLAIN, getWidth() / 50));
			Utils.drawCredit(g, "Cameron Witcher", creditvar, 2, Color.BLACK, Color.WHITE, 1);
			Utils.drawCredit(g, "Blake Ohlmeier", creditvar, 3, Color.BLACK, Color.WHITE, 1);

			g.setFont(new Font("Helvetica", Font.BOLD, getWidth() / 50));
			Utils.drawCredit(g, "Artists and Concept designers:", creditvar, 5, Color.BLACK, Color.WHITE, 1);
			g.setFont(new Font("Helvetica", Font.PLAIN, getWidth() / 50));
			Utils.drawCredit(g, "Herb Yeliab (Head Artist)", creditvar, 6, Color.BLACK, Color.WHITE, 1);
			Utils.drawCredit(g, "Blake Ohlmeier", creditvar, 7, Color.BLACK, Color.WHITE, 1);

			g.setFont(new Font("Helvetica", Font.BOLD, getWidth() / 50));
			Utils.drawCredit(g, "Beta Testers:", creditvar, 9, Color.BLACK, Color.WHITE, 1);
			g.setFont(new Font("Helvetica", Font.PLAIN, getWidth() / 50));
			Utils.drawCredit(g, "Sean Becker", creditvar, 10, Color.BLACK, Color.WHITE, 1);
			Utils.drawCredit(g, "Joey Phillips", creditvar, 11, Color.BLACK, Color.WHITE, 1);
			Utils.drawCredit(g, "Carsyn Stephenson", creditvar, 12, Color.BLACK, Color.WHITE, 1);
			Utils.drawCredit(g, "Chris Green", creditvar, 13, Color.BLACK, Color.WHITE, 1);
			Utils.drawCredit(g, "Chad Guthrie", creditvar, 14, Color.BLACK, Color.WHITE, 1);

			Image logo = ExternalFile.loadTexture("logos/logo-title.png");

			Utils.drawCreditImage(g, logo, creditvar, 17);

			creditvar -= 1;

			if (Utils.creditsOver(g, creditvar, 21)) {
				Main.setBoard(Board.MAIN);
			}

		}

		// This is where all the fun happens! :)
		if (board == Board.GAME) {
			g.drawImage(Backgrounds.SKY.getImage(), 0, 0, getWidth(), getHeight(), this);

			for (Sprite sprite : objects_temp) {
				objects.add(sprite);
			}
			objects_temp.clear();

			try {
				for (Sprite sprite : objects) {

					if (sprite instanceof Player) {
						objects_remove.add(sprite);
					}
					if (sprite instanceof Empty) {
						objects_remove.add(sprite);
						continue;
					}
					if (sprite instanceof Moveable) {
						((Moveable) sprite).move();
					}
					if (!(sprite instanceof Particle))
						sprite.draw(g);

					if (sprite.x < -100 || sprite.x > 2000) {
						objects_remove.add(sprite);
					}
					if (sprite.y > 600)
						objects_remove.add(sprite);

					if (sprite instanceof Particle) {
						Particle p = (Particle) sprite;
						p.draw(g);
						if (p.getLifetime() <= 0) {
							objects_remove.add(p);
						}
					}
				}
			} catch (ConcurrentModificationException ex) {
				Utils.debug("ConcurrentModificationException 2 (Screen)");
			}

			Main.getPlayer().getPolygon();
			Main.getPlayer().move();
			Main.getPlayer().draw(g);

			try {
				for (int i = 0; i != Main.getPlayer().getMaxLives(); i++) {
					if (i < Main.getPlayer().getLives()) {
						g.drawImage(ExternalFile.loadTexture("heart.png"), i * 30, 0, 30, 30, this);
					} else {
						g.drawImage(ExternalFile.loadTexture("broken-heart.png"), i * 30, 0, 30, 30, this);
					}
				}
			} catch (NullPointerException ex) {
			}

			for (Sprite sprite : objects_remove) {
				objects.remove(sprite);
			}

			objects_remove.clear();

			// Draw Info
			g.setFont(Main.getFont().deriveFont(15f));
			Utils.drawOutlineString(g, "Level: " + Utils.getLevel(),
					getWidth() - (g.getFontMetrics().stringWidth("Level: " + Utils.getLevel())), 20,
					Color.decode("#99db45"), Color.WHITE, 1);
			Utils.drawOutlineString(g, "Score: " + Main.score, getWidth() - (g.getFontMetrics().stringWidth("Score: " + Main.score)), 42, Color.decode("#99db45"), Color.white, 1);

			// Draw Leaderboard
			
			if(leaderboard){
				g.drawImage(Images.makeImageTranslucent(Images.toBufferedImage(Images.createColorImage("#000000")), 0.5),
						getWidth() - 200, getHeight() / 3, 200, 110, this);
				g.setFont(Main.getFont().deriveFont(10f));

				Utils.drawOutlineString(g, "Leaderboard",
						(getWidth() - 100) - (g.getFontMetrics().stringWidth("Leaderboard") / 2),
						getHeight() / 3 + (Main.getFont().getSize() * 12), Color.YELLOW, Color.WHITE, 0);
				
				
				for(Entry<String,Integer> entry : Utils.getHighScores().entrySet()){
					
					Utils.drawOutlineString(g, entry.getKey(), (getWidth() - 100) - (g.getFontMetrics().stringWidth(entry.getKey())),
							(getHeight() / 3 + (Main.getFont().getSize() * 12))+ (((Main.getFont().getSize() * 12) * (s + 1)) + (s * 4)), Color.WHITE, Color.black, 1);
					Utils.drawOutlineString(g, entry.getValue()+"", getWidth() - g.getFontMetrics().stringWidth(entry.getValue()+""), ((getHeight() / 3 + (Main.getFont().getSize() * 12))+ (((Main.getFont().getSize() * 12) * (s + 1)) + (s * 4))), Color.WHITE, Color.BLACK, 1);
					
					
					s=s+1;
				}
				s=0;
//				for(int i=0;i!=Utils.getHighScores().size();i++){
//					Utils.drawOutlineString(g, Utils.getHighScores(),(getWidth() - 100) - (g.getFontMetrics().stringWidth(highscores[l]) / 2),(getHeight() / 3 + (Main.getFont().getSize() * 12))+ (((Main.getFont().getSize() * 12) * (l + 1)) + (l * 4)),
//							Color.WHITE, Color.WHITE, 0);
//				}
				
			

			

			}

		}

		// This is what shows when the player loses all of their lives.
		if (board == Board.GAME_OVER) {
			g.drawImage(Backgrounds.MAIN.getImage(), 0, 0, getWidth(), getHeight(), this);
			Utils.drawOutlineString(g, "GAME OVER", getWidth() / 2 - (g.getFontMetrics().stringWidth("GAME OVER") / 2),
					getHeight() / 3, Color.WHITE, Color.RED, 1);
			Utils.drawOutlineString(g, Main.deathmessage + "\nPress R to restart.", getWidth() / 2, getHeight() / 2,
					Color.decode("#99DB45"), Color.WHITE, 1);
		}

		if (board == Board.LEVELUP) {
			g.drawImage(Backgrounds.MAIN.getImage(), 0, 0, getWidth(), getHeight(), this);

			Utils.drawOutlineString(g, "You won level " + Utils.getLevel() + "!",
					getWidth() / 2 - (g.getFontMetrics().stringWidth("You won level " + Utils.getLevel() + "!") / 2),
					getHeight() / 3, Color.decode("#99db45"), Color.WHITE, 1);
			Utils.drawOutlineString(g, "Press P to play!",
					getWidth() / 2 - (g.getFontMetrics().stringWidth("Press P to play!") / 2), getHeight() / 2,
					Color.decode("#99db45"), Color.WHITE, 1);

		}
		if (board == Board.WIN) {
			g.drawImage(Backgrounds.MAIN.getImage(), 0, 0, getWidth(), getHeight(), this);
			playing = false;
			g.setFont(Main.getFont().deriveFont(Font.BOLD, 20));
			Utils.drawOutlineString(g, "YOU WON!", getWidth() / 2 - (g.getFontMetrics().stringWidth("YOU WON!") / 2),
					getHeight() / 3, Color.decode("#99db45"), Color.WHITE, 1);
			g.setFont(Main.getFont().deriveFont(Font.PLAIN, 15));

			Utils.drawOutlineString(g, "Press C for credits.\nPress ESC to go back to the main menu.", getWidth() / 2,
					getHeight() / 2, Color.decode("#99db45"), Color.BLACK, 1);
		}
		if (board == Board.NAME) {
			g.drawImage(Backgrounds.MAIN.getImage(), 0, 0, getWidth(), getHeight(), this);
			playing = false;
			typing = true;
			Utils.drawOutlineString(g, "Type your name.",
					(getWidth() / 2) - ((g.getFontMetrics().stringWidth("Type your name.")) / 2), getHeight() / 3,
					Color.decode("#99db45"), Color.WHITE, 1);
			Utils.drawOutlineString(g, name, (getWidth() / 2) - ((g.getFontMetrics().stringWidth(name)) / 2),
					getHeight() / 2, Color.decode("#99db45"), Color.WHITE, 1);

		}

		for (Clickable c : Main.getClickables()) {
			c.drawPolygon(g);
		}

		// Debug overlay
		if (debug) {
			g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
			Utils.drawOutlineString(g, "Version: " + Utils.getVersion(), 0, 20, Color.WHITE, Color.BLACK, 1);
			Utils.drawOutlineString(g, "Clickables: " + Main.getClickables().size(), 0, 40, Color.WHITE, Color.BLACK,
					1);
			Utils.drawOutlineString(g, "Objects: " + objects.size(), 0, 60, Color.WHITE, Color.BLACK, 1);
			Utils.drawOutlineString(g, "Playing: " + playing, 0, 80, Color.WHITE, Color.BLACK, 1);
			try {
				Utils.drawOutlineString(g, "Flying: " + Main.getPlayer().flying, 0, 100, Color.WHITE, Color.BLACK, 1);
				Utils.drawOutlineString(g, "Jumping: " + Main.getPlayer().jumping, 0, 120, Color.WHITE, Color.BLACK, 1);
				Utils.drawOutlineString(g, "Onground: " + Main.getPlayer().onground, 0, 140, Color.WHITE, Color.BLACK,
						1);

				Utils.drawOutlineString(g, "Climbing: " + Main.getPlayer().climbing, 0, 160, Color.WHITE, Color.BLACK,
						1);
				if (Main.getPlayer().getTool() != null)
					Utils.drawOutlineString(g, "Tool: " + Main.getPlayer().getTool().getClass().getSimpleName(), 0, 180,
							Color.WHITE, Color.BLACK, 1);
				else
					Utils.drawOutlineString(g, "Tool: null", 0, 180, Color.WHITE, Color.BLACK, 1);
				Utils.drawOutlineString(g, "Left: " + Main.getPlayer().left, 0, 200, Color.WHITE, Color.BLACK, 1);
				Utils.drawOutlineString(g, "Right: " + Main.getPlayer().right, 0, 220, Color.WHITE, Color.BLACK, 1);
				Utils.drawOutlineString(g, "Location: " + Main.getPlayer().getLocation(), 0, 240, Color.WHITE,
						Color.BLACK, 1);
				g.drawRect((int)Main.getPlayer().getPolygon().getBounds().getX(),(int)Main.getPlayer().getPolygon().getBounds().getY(),(int)Main.getPlayer().getPolygon().getBounds().getWidth(),(int)Main.getPlayer().getPolygon().getBounds().getHeight());
				g.drawRect((int)Main.getPlayer().getXBounds().getX(),(int)Main.getPlayer().getXBounds().getY(),(int)Main.getPlayer().getXBounds().getWidth(),(int)Main.getPlayer().getXBounds().getHeight());

			} catch (IndexOutOfBoundsException ex) {

			}

			for (Sprite s : objects) {
				g.drawRect((int) s.getPolygon().getBounds().getX(), (int) s.getPolygon().getBounds().getY(),
						(int) s.getPolygon().getBounds().getWidth(), (int) s.getPolygon().getBounds().getHeight());
			}
			
			

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	private class MMListener extends MouseMotionAdapter {

	}

	private class MListener extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			try {
				Main.getPlayer().x = e.getX();
				Main.getPlayer().y = e.getY();
			} catch (NullPointerException ex) {
				// This just means the player hasn't been set. Not a big deal.
			}
		}

	}

	private class TAdapter extends KeyAdapter {

		@Override
		public void keyReleased(KeyEvent e) {
			try {
				Main.getPlayer().keyReleased(e);
			} catch (NullPointerException ex) {
			}
			for (Sprite sprite : objects) {
				if (sprite instanceof Keyable)
					((Keyable) sprite).keyReleased(e);
			}

		}

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();

			if (typing) {
				if(key == KeyEvent.VK_ENTER){
					if(!name.contains("_")){
						typing = false;
						Utils.createScore(name);
						Main.setBoard(Board.MAIN);
					}
				}
				if (key == KeyEvent.VK_BACK_SPACE) {
					int i = name.indexOf("_");
					if (i == -1) {
						i = 3;
					}
					if (i == 0)
						return;
					name = name.substring(0, i - 1) + '_' + name.substring(i);
					return;
				}
				if (key == KeyEvent.VK_SHIFT || alphanumeric.matcher(e.getKeyChar() + "").find()) {
					return;
				}

				if (name.contains("_")) {
					name = name.replaceFirst("_", e.getKeyChar() + "");
				}
				return;

			}
			
			if(key == KeyEvent.VK_T){
				leaderboard= !leaderboard;
			}

			if (key == KeyEvent.VK_5) {
				for (Sprite sprite : objects) {

					if (sprite instanceof Player) {
						Player player = (Player) sprite;
						player.setTool(new Sword(0, 0));
					}
				}
			}

			if (key == KeyEvent.VK_ESCAPE) {
				if (playing)
					paused = !paused;
				else {
					Main.setBoard(Board.MAIN);
				}
			}
			if (key == KeyEvent.VK_P) {
				if (Main.getBoard() == Board.WIN) {
					Main.setBoard(Board.GAME);
					Utils.setLevel(0);
				} else if (!(Main.getBoard() == Board.GAME)) {
					Utils.setLevel(Utils.getLevel() + 1);
					Main.setBoard(Board.GAME);
					Audio.playBackground(Sound.BACKGROUND_GRASS);
					playing = true;
				}

			}

			if (key == KeyEvent.VK_C) {
				if (playing)
					return;
				objects.clear();
				Main.setBoard(Board.CREDITS);

			}

			if (key == KeyEvent.VK_6) {
				for (Sprite sprite : objects) {

					if (sprite instanceof Player) {
						Player player = (Player) sprite;
						player.setTool(new FireStaff(0, 0));
					}
				}
			}

			if (key == KeyEvent.VK_7) {
				for (Sprite sprite : objects) {

					if (sprite instanceof Player) {
						Player player = (Player) sprite;
						player.setTool(new Bow(0, 0));
					}
				}
			}
			if (key == KeyEvent.VK_8) {
				for (Sprite sprite : objects) {

					if (sprite instanceof Player) {
						Player player = (Player) sprite;
						player.setTool(new IceDagger(0, 0));
					}
				}
			}

			if (key == KeyEvent.VK_9) {
				for (Sprite sprite : objects) {

					if (sprite instanceof Player) {
						Player player = (Player) sprite;
						player.setTool(new FireDagger(0, 0));
					}
				}
			}
			if (key == KeyEvent.VK_0) {
				Main.clearObjects();
				LevelBuilder l = new LevelBuilder();
				l.buildLevel(new char[] { 'A', 'B', 'B', 'C', 'X', 'A', 'C', 'X', 'A', 'C', }, 10, 1);
			}

			if (key == KeyEvent.VK_F3) {
				debug = !debug;
			}
			if (key == KeyEvent.VK_R) {
				Main.setBoard(Board.MAIN);
				Utils.setLevel(0);
			}
			if (key == KeyEvent.VK_F5) {
				Main.setBoard(Board.WIN);
			}

			try {
				Main.getPlayer().keyPressed(e);
				for (Sprite sprite : objects) {
					if (sprite instanceof Keyable)
						((Keyable) sprite).keyPressed(e);
				}

			} catch (Exception ex) {
			}

		}
	}

	public void addSprites(Sprite sprite) {
		objects_temp.add(sprite);
	}

}
