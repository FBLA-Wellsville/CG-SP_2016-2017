package io.github.trinnorica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TimerTask;
import java.util.regex.Pattern;

import javax.swing.JPanel;
import javax.swing.Timer;

import io.github.trinnorica.entity.Player;
import io.github.trinnorica.objects.tools.Armour;
import io.github.trinnorica.objects.tools.Bow;
import io.github.trinnorica.objects.tools.FireDagger;
import io.github.trinnorica.objects.tools.FireStaff;
import io.github.trinnorica.objects.tools.IceDagger;
import io.github.trinnorica.objects.tools.IceStaff;
import io.github.trinnorica.objects.tools.Stick;
import io.github.trinnorica.objects.tools.Sword;
import io.github.trinnorica.utils.Backgrounds;
import io.github.trinnorica.utils.Board;
import io.github.trinnorica.utils.Images;
import io.github.trinnorica.utils.Utils;
import io.github.trinnorica.utils.levels.LevelBuilder;
import io.github.trinnorica.utils.levels.LevelUtils;
import io.github.trinnorica.utils.particles.Particle;
import io.github.trinnorica.utils.sprites.Empty;
import io.github.trinnorica.utils.sprites.Keyable;
import io.github.trinnorica.utils.sprites.Moveable;
import io.github.trinnorica.utils.sprites.Sprite;
import io.github.trinnorica.utils.sprites.ToolType;
import io.github.trinnorica.utils.ui.Message;
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
	private Image DARK = Images.makeImageTranslucent(Images.toBufferedImage(Images.createColorImage(Color.decode("#000000"))), 0.5);
	private boolean playing = false;
	private Pattern alphanumeric = Pattern.compile("[^a-zA-Z0-9]");
	private String name = "___";
	private boolean typing = false;
	private boolean pseudopause = false;
	private int s = 0;
	private boolean help = false;
	private Image SWORD = ExternalFile.loadTexture("objects/tools/sword.png");
	private Image ENEMY1 = ExternalFile.loadTexture("entity/knight/walk.gif");
	private Image ENEMY2 = ExternalFile.loadTexture("entity/knight/dark/walk.gif");
	private Image ENEMY3 = ExternalFile.loadTexture("entity/skeleton/walk.gif");
	private Image ENEMY4 = ExternalFile.loadTexture("entity/ogre/walk.gif");
//	private Image ENEMY5 = ExternalFile.loadTexture("entity/knight/walk.gif");
	private Image LOGO = ExternalFile.loadTexture("logos/logo-title.png");
	private Image FBLA = ExternalFile.loadTexture("logos/fbla-logo.png");
	
	private Map<Rectangle, Integer> rectangles = new HashMap<>();
	private List<Rectangle> rectangles_remove = new ArrayList<>();
	
	
	
	private boolean level = false;
	public boolean confirm;

	private boolean leaderboard = true;

	public Screen() {
		init();
	}

	public String getName() {
		return name;
	}

	public void init() {

		timer = new Timer(INITIALDELAY, this);
		timer.start();

		addKeyListener(new TAdapter());

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
		
		if(level){
			drawLevelDebug(g);
			return;
		}
		if (!paused && !help && !confirm)
			drawMenu(g);
		else {
			if (paused)
				drawPaused(g);
			if (help)
				drawHelp(g);
			if (confirm)
				drawConfirm(g);

		}
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void drawLevelDebug(Graphics g) {
		
		if(Utils.getLevel() == 0){
			Utils.setLevel(1);
		}
		
		if(Utils.getLevel() > Utils.getLevels()){
			Utils.setLevel(Utils.getLevels());
		}
		
		

		Utils.removeLevelMessages();
		Main.clearObjects();
		objects_temp.clear();
		LevelBuilder l = new LevelBuilder();
		switch(Utils.getLevelType(Utils.getLevel())){
		case GROUND:
			g.drawImage(Backgrounds.GRASS.getImage(), 0, 0, getWidth(), getHeight(), this);
			break;
		case HELL:
			g.drawImage(Backgrounds.HELL.getImage(), 0, 0, getWidth(), getHeight(), this);
			break;
		case CAVE:
			g.drawImage(Backgrounds.CAVE.getImage(), 0, 0, getWidth(), getHeight(), this);
			break;
		case SKY:
			g.drawImage(Backgrounds.SKY.getImage(), 0, 0, getWidth(), getHeight(), this);
			break;
		case BOSS:
			g.drawImage(Backgrounds.BOSS.getImage(), 0, 0, getWidth(), getHeight(), this);
			break;
		
		}
		
		int level = Utils.getLevel();
		if(level == 1){
			Utils.addStaticLevelMessage("Your son has been taken by the Dark Knight of Eldiseth!\nYou must travel away from your village and\nsave your son from the Dark Castle.\nYou have never left your\nvillage before, and you do not know what to expect!",
					getWidth()/2,
					70, 
					Color.BLACK,
					Color.WHITE, 
					1);
		}
		if(level == 6){
			Utils.addStaticLevelMessage("This is your first enemy! Grab that sword to defend yourself.\nIf you have forgotten how to use weapons, press F1!",
					getWidth()/2,
					70, 
					Color.decode("#99db45"), 
					Color.WHITE, 
					1);
		}
		if(level == 7){
			Utils.addStaticLevelMessage("Don not forget you can sprint!\nIf you ever get stuck on a level, try pressing F1.",
					getWidth()/2,
					70, 
					Color.decode("#99db45"), 
					Color.WHITE, 
					1);
		}
		if(level == 10){
			Utils.addStaticLevelMessage("Keys work like weapons. They can be used by pressing SHIFT.\nKeys and doors are color coded.",
					getWidth()/2,
					70, 
					Color.decode("#99db45"), 
					Color.WHITE, 
					1);
		}
		l.buildLevel(LevelUtils.getLevelBlueprint(level),LevelUtils.getLevelWidth(level),LevelUtils.getLevelHeight(level));
		
		for(Sprite sprite : objects_temp){
			sprite.draw(g);
		}
		
		g.setFont(new Font("Helvetica", Font.PLAIN, 25));
		g.setColor(Color.WHITE);
		g.drawString("Level: " + Utils.getLevel(), getWidth()/2 - g.getFontMetrics().stringWidth("Level: " + Utils.getLevel()), 30);
	
	}

	public void drawHelp(Graphics g) {
		g.drawImage(Backgrounds.SKY.getImage(), 0, 0, getWidth(), getHeight(), this);
		g.drawImage(DARK, 0, 0, getWidth(), getHeight(), this);
		g.setFont(Main.getFont().deriveFont(15.0F));
		Utils.drawOutlineString(g, "It looks like  you have not played before. Here is a quick run through.",
				(getWidth() / 2) - g.getFontMetrics()
						.stringWidth("It looks like  you have not played before. Here is a quick run through.") / 2,
				20, Utils.getGreenColor(), Color.WHITE, 1);

		g.setFont(Main.getFont().deriveFont(10.0F));
		Utils.drawOutlineString(g, "This is a tool or item.\n\nYou can pick it up by running into it.", 200, 50,
				Utils.getGreenColor(), Color.WHITE, 0);
		g.drawImage(SWORD, 200, 50, 30, 30, this);

		Utils.drawOutlineString(g, "This is an enemy.\n\nThe only way to damage them is with a weapon.",
				getWidth() - 200, 50, Utils.getGreenColor(), Color.WHITE, 0);
		g.drawImage(ENEMY1, getWidth() - (200-30*1), 50, 30, 30, this);
		g.drawImage(ENEMY2, getWidth() - (200-30*0), 50, 30, 30, this);
		g.drawImage(ENEMY3, getWidth() - (200+30*1), 50, 30, 30, this);
		g.drawImage(ENEMY4, getWidth() - (200+30*2), 50, 30, 30, this);
//		g.drawImage(ENEMY5, getWidth() - (200+30*2), 50, 30, 30, this);
		g.setFont(new Font("Helvetica", Font.PLAIN, 14));
		Utils.drawOutlineString(g,
				"Controls\n" + "W or Up Arrow - Climb up\n" + "A or Left Arrow - Move Left\n"
						+ "S or Down Arrow - Climb down\n" + "D or Right Arrow - Move Right\n" + "SPACE - Jump\n"
						+ "T - Toggle leaderboard\n" + "Ctrl - Sprint\n" + "Shift - Use item\n" + "Esc - Pause menu\n"
						+ "F1 - Show this menu\n" + "R - Go to main menu\n\n"
						+ "The files that contain the scores is located at C:/KANSAS_WELLSVILLE_HIGHSCHOOL/Eldiseth/\n\n"
						+ "Press Esc to close this page.",
				getWidth() / 2, getHeight() / 3, Utils.getGreenColor(), Color.WHITE, 0);

	}

	public void drawConfirm(Graphics g) {
		g.drawImage(Backgrounds.MAIN.getImage(), 0, 0, getWidth(), getHeight(), this);
		g.drawImage(DARK, 0, 0, getWidth(), getHeight(), this);
		g.setFont(Main.getFont().deriveFont(20.0F));
		Utils.drawOutlineString(g, "Would you really like to restart? [y|n]",
				(getWidth() / 2) - g.getFontMetrics().stringWidth("Would you really like to restart?") / 2,
				getHeight() / 2, Utils.getGreenColor(), Color.WHITE, 1);

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

			Utils.drawCreditImage(g, LOGO, creditvar, 17);

			g.setFont(new Font("Helvetica", Font.BOLD, getWidth() / 50));
			Utils.drawCredit(g, "And a big thanks to FBLA for giving us the chance to create this game!", creditvar, 25,
					Color.BLACK, Color.WHITE, 1);
			Utils.drawCreditImage(g, FBLA, creditvar, 29);

			creditvar -= 1;

			if (Utils.creditsOver(g, creditvar, 40)) {
				Main.setBoard(Board.MAIN);
			}

		}

		// This is where all the fun happens! :)
		if (board == Board.GAME) {
			if (!Utils.hasPlayedBefore()) {
				help = true;
				drawHelp(g);
				return;
			}
			switch(Utils.getLevelType(Utils.getLevel())){
			case GROUND:
				g.drawImage(Backgrounds.GRASS.getImage(), 0, 0, getWidth(), getHeight(), this);
				break;
			case HELL:
				g.drawImage(Backgrounds.HELL.getImage(), 0, 0, getWidth(), getHeight(), this);
				break;
			case CAVE:
				g.drawImage(Backgrounds.CAVE.getImage(), 0, 0, getWidth(), getHeight(), this);
				break;
			case SKY:
				g.drawImage(Backgrounds.SKY.getImage(), 0, 0, getWidth(), getHeight(), this);
				break;
			case BOSS:
				g.drawImage(Backgrounds.BOSS.getImage(), 0, 0, getWidth(), getHeight(), this);
				break;
			
			}
			

			

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
			Utils.drawOutlineString(g, "Score: " + Main.score,
					getWidth() - (g.getFontMetrics().stringWidth("Score: " + Main.score)), 42, Color.decode("#99db45"),
					Color.white, 1);
			try{
				if(Main.getPlayer().hasKey()){
					Utils.drawOutlineString(g, "Key: ",
							getWidth() - (g.getFontMetrics().stringWidth("Key: "))-40, 64, Color.decode("#99db45"),
							Color.white, 1);
					g.drawImage(Main.getPlayer().getKey().getImage(), getWidth()-35, 64-15, this);
				}
			} catch (NullPointerException ex){}
			
			
			//Draw messages
			
			for(Entry<Integer,Message> entry : Utils.getMessages().entrySet()){
				entry.getValue().draw(g);
			}
			for(Message message : Utils.getLevelMessages()){
				message.draw(g);
			}
			
			for(Entry<Rectangle,Integer> entry : rectangles.entrySet()){
				entry.setValue(entry.getValue()-1);
				if(entry.getValue() >= 0){
					rectangles_remove.add(entry.getKey());
				}
				g.drawRect(entry.getKey().x, entry.getKey().y, entry.getKey().width, entry.getKey().height);
			}
			
			for(Rectangle rec : rectangles_remove){
				rectangles.remove(rec);
			}
			rectangles_remove.clear();
			

			// Draw Leaderboard

			if (leaderboard) {
				g.drawImage(
						Images.makeImageTranslucent(Images.toBufferedImage(Images.createColorImage(Color.decode("#000000"))), 0.5),
						getWidth() - 200, getHeight() / 3, 200, 110, this);
				g.setFont(Main.getFont().deriveFont(10f));

				Utils.drawOutlineString(g, "Leaderboard",
						(getWidth() - 100) - (g.getFontMetrics().stringWidth("Leaderboard") / 2),
						getHeight() / 3 + (Main.getFont().getSize() * 12), Color.YELLOW, Color.WHITE, 0);

				for (Entry<String, Integer> entry : Utils.getHighScores().entrySet()) {

					if (s > 5)
						continue;

					Utils.drawOutlineString(g, entry.getKey(), (getWidth() - 190),
							(getHeight() / 3 + (Main.getFont().getSize() * 12))
									+ (((Main.getFont().getSize() * 12) * (s + 1)) + (s * 4)),
							Color.WHITE, Color.black, 1);
					Utils.drawOutlineString(g, entry.getValue() + "",
							getWidth() - g.getFontMetrics().stringWidth(entry.getValue() + ""),
							((getHeight() / 3 + (Main.getFont().getSize() * 12))
									+ (((Main.getFont().getSize() * 12) * (s + 1)) + (s * 4))),
							Color.WHITE, Color.BLACK, 1);

					s = s + 1;
				}
				s = 0;
				// for(int i=0;i!=Utils.getHighScores().size();i++){
				// Utils.drawOutlineString(g, Utils.getHighScores(),(getWidth()
				// - 100) - (g.getFontMetrics().stringWidth(highscores[l]) /
				// 2),(getHeight() / 3 + (Main.getFont().getSize() * 12))+
				// (((Main.getFont().getSize() * 12) * (l + 1)) + (l * 4)),
				// Color.WHITE, Color.WHITE, 0);
				// }

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

		// Debug overlay
		if (debug) {
			g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
			Utils.drawOutlineString(g, "FPS: " + Main.getFPS(), 0, 20, Color.WHITE, Color.BLACK, 1);
			Utils.drawOutlineString(g, "Version: " + Utils.getVersion(), 0, 40, Color.WHITE, Color.BLACK, 1);
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
					Utils.drawOutlineString(g, "Tool: None", 0, 180, Color.WHITE, Color.BLACK, 1);
				Utils.drawOutlineString(g, "Left: " + Main.getPlayer().left, 0, 200, Color.WHITE, Color.BLACK, 1);
				Utils.drawOutlineString(g, "Right: " + Main.getPlayer().right, 0, 220, Color.WHITE, Color.BLACK, 1);
				Utils.drawOutlineString(g, "Location: " + Main.getPlayer().getLocation(), 0, 240, Color.WHITE,
						Color.BLACK, 1);
				g.drawRect((int) Main.getPlayer().getPolygon().getBounds().getX(),
						(int) Main.getPlayer().getPolygon().getBounds().getY(),
						(int) Main.getPlayer().getPolygon().getBounds().getWidth(),
						(int) Main.getPlayer().getPolygon().getBounds().getHeight());
				g.drawRect((int) Main.getPlayer().getXBounds().getBounds().getX(),
						(int) Main.getPlayer().getXBounds().getBounds().getY(),
						(int) Main.getPlayer().getXBounds().getBounds().getWidth(),
						(int) Main.getPlayer().getXBounds().getBounds().getHeight());

			} catch (NullPointerException | IndexOutOfBoundsException ex) {

			}

			for (Sprite s : objects) {
				g.drawRect((int) s.getPolygon().getBounds().getX(), (int) s.getPolygon().getBounds().getY(),
						(int) s.getPolygon().getBounds().getWidth(), (int) s.getPolygon().getBounds().getHeight());
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
        long beforeTime = System.nanoTime();
        Main.now=System.currentTimeMillis(); 
        Main.framesCount++; 
        if(Main.now-Main.framesTimer>1000){
        	Main.framesTimer=Main.now; 
        	Main.framesCountAvg=Main.framesCount; 
        	Main.framesCount=0;
        }
        
        
        repaint();
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
			Utils.pressKey(key);
			
			if(board == Board.MAIN){
				if(Utils.codeEquals("level")){
					level = true;
				}
				
			}
			
			if(board == Board.GAME){
				
				//Cheat Codes
				if(Utils.codeEqualsRaw(KeyEvent.VK_UP + "-" + KeyEvent.VK_UP + "-" + KeyEvent.VK_DOWN + "-" + KeyEvent.VK_I)){
					Main.addSprite(new Armour((int)Main.getPlayer().getX(), (int)Main.getPlayer().getY()-10, ToolType.NONE, Armour.IRON));
				}
				if(Utils.codeEqualsRaw(KeyEvent.VK_UP + "-" + KeyEvent.VK_UP + "-" + KeyEvent.VK_DOWN + "-" + KeyEvent.VK_G)){
					Main.addSprite(new Armour((int)Main.getPlayer().getX(), (int)Main.getPlayer().getY()-10, ToolType.NONE, Armour.GOLD));
				}
				if(Utils.codeEqualsRaw(KeyEvent.VK_UP + "-" + KeyEvent.VK_UP + "-" + KeyEvent.VK_DOWN + "-" + KeyEvent.VK_D)){
					Main.addSprite(new Armour((int)Main.getPlayer().getX(), (int)Main.getPlayer().getY()-10, ToolType.NONE, Armour.DARK));
				}
				if(Utils.codeEqualsRaw(KeyEvent.VK_UP + "-" + KeyEvent.VK_UP + "-" + KeyEvent.VK_DOWN + "-" + KeyEvent.VK_F)){
					Main.addSprite(new Armour((int)Main.getPlayer().getX(), (int)Main.getPlayer().getY()-10, ToolType.NONE, Armour.FIRE));
				}
				if(Utils.codeEqualsRaw(KeyEvent.VK_UP + "-" + KeyEvent.VK_UP + "-" + KeyEvent.VK_DOWN + "-" + KeyEvent.VK_DOWN + "-" + KeyEvent.VK_1)){
					Main.addSprite(new Sword((int)Main.getPlayer().getX(), (int)Main.getPlayer().getY(),ToolType.MELEE));
				}
				if(Utils.codeEqualsRaw(KeyEvent.VK_UP + "-" + KeyEvent.VK_UP + "-" + KeyEvent.VK_DOWN + "-" + KeyEvent.VK_DOWN + "-" + KeyEvent.VK_2)){
					Main.addSprite(new Stick((int)Main.getPlayer().getX(), (int)Main.getPlayer().getY(),ToolType.MELEE));
				}
				if(Utils.codeEqualsRaw(KeyEvent.VK_UP + "-" + KeyEvent.VK_UP + "-" + KeyEvent.VK_DOWN + "-" + KeyEvent.VK_DOWN + "-" + KeyEvent.VK_3)){
					Main.addSprite(new Bow((int)Main.getPlayer().getX(), (int)Main.getPlayer().getY(),ToolType.PROJECTILE));
				}
				if(Utils.codeEqualsRaw(KeyEvent.VK_UP + "-" + KeyEvent.VK_UP + "-" + KeyEvent.VK_DOWN + "-" + KeyEvent.VK_DOWN + "-" + KeyEvent.VK_4)){
					Main.addSprite(new FireStaff((int)Main.getPlayer().getX(), (int)Main.getPlayer().getY(),ToolType.PROJECTILE));
				}
				if(Utils.codeEqualsRaw(KeyEvent.VK_UP + "-" + KeyEvent.VK_UP + "-" + KeyEvent.VK_DOWN + "-" + KeyEvent.VK_DOWN + "-" + KeyEvent.VK_5)){
					Main.addSprite(new IceStaff((int)Main.getPlayer().getX(), (int)Main.getPlayer().getY(),ToolType.PROJECTILE));
				}
				if(Utils.codeEqualsRaw(KeyEvent.VK_UP + "-" + KeyEvent.VK_UP + "-" + KeyEvent.VK_DOWN + "-" + KeyEvent.VK_DOWN + "-" + KeyEvent.VK_6)){
					Main.addSprite(new FireDagger((int)Main.getPlayer().getX(), (int)Main.getPlayer().getY(),ToolType.DIRECTIONAL));
				}
				if(Utils.codeEqualsRaw(KeyEvent.VK_UP + "-" + KeyEvent.VK_UP + "-" + KeyEvent.VK_DOWN + "-" + KeyEvent.VK_DOWN + "-" + KeyEvent.VK_7)){
					Main.addSprite(new IceDagger((int)Main.getPlayer().getX(), (int)Main.getPlayer().getY(),ToolType.DIRECTIONAL));
				}
				if(Utils.codeEquals("flyme")){
					Main.getPlayer().flying = true;
				}
				if(Utils.codeEquals("land")){
					Main.getPlayer().flying = false;
				}
				if(Utils.codeEquals("fly")){
					Main.getPlayer().flying = !Main.getPlayer().flying;
				}
			}
			
			if(level){
				if(key == KeyEvent.VK_UP){
					Utils.setLevel(Utils.getLevel()+1);
				}
				if(key == KeyEvent.VK_DOWN){
					Utils.setLevel(Utils.getLevel()-1);
				}
			}
			

			if (key == KeyEvent.VK_ESCAPE) {
				
				if(board == Board.MAIN){
					Main.close();
				}

				if (help) {
					Utils.hasPlayedBefore(true);
					help = false;
					return;
				}

				if (playing)
					paused = !paused;
				else {
					if (board == Board.WIN)
						Utils.setLevel(0);

					Main.setBoard(Board.MAIN);
				}
			}

			if (key == KeyEvent.VK_F1) {
				if (!paused)
					help = !help;
				return;

			}
			if (help)
				return;

			if (typing) {
				if (key == KeyEvent.VK_ENTER) {
					if (!name.contains("_")) {
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

			if (key == KeyEvent.VK_T) {
				leaderboard = !leaderboard;
			}

			if (key == KeyEvent.VK_5) {
				for (Sprite sprite : objects) {

					if (sprite instanceof Player) {
						Player player = (Player) sprite;
						player.setTool(new Sword(0, 0, ToolType.MELEE));
					}
				}
			}

			if (key == KeyEvent.VK_P) {
				if (Main.getBoard() == Board.WIN) {
					Main.setBoard(Board.GAME);
					Utils.setLevel(0);
				}
				if(Main.getBoard() == Board.NAME){
					return;
				}
				if (!(Main.getBoard() == Board.GAME)) {
					Utils.setLevel(Utils.getLevel() + 1);
					Main.setBoard(Board.GAME);
					
					playing = true;
				}

			}

			if (key == KeyEvent.VK_C) {
				if (playing)
					return;
				objects.clear();
				Main.setBoard(Board.CREDITS);

			}

			if (confirm) {
				if (key == KeyEvent.VK_Y) {
					confirm = false;
					Main.setBoard(Board.MAIN);
					Utils.setLevel(0);
				}

				if (key == KeyEvent.VK_N) {
					confirm = false;
					playing = true;
				}
			}

			if (key == KeyEvent.VK_R) {
				if (playing && !confirm) {
					confirm = true;
					playing = false;

				} else {
					Main.setBoard(Board.MAIN);
					playing = false;
					Utils.setLevel(0);
				}

			}

			if (key == KeyEvent.VK_6) {
				for (Sprite sprite : objects) {

					if (sprite instanceof Player) {
						Player player = (Player) sprite;
						player.setTool(new FireStaff(0, 0, ToolType.DIRECTIONAL));
					}
				}
			}

			if (key == KeyEvent.VK_7) {
				for (Sprite sprite : objects) {

					if (sprite instanceof Player) {
						Player player = (Player) sprite;
						player.setTool(new Bow(0, 0, ToolType.DIRECTIONAL));
					}
				}
			}
			if (key == KeyEvent.VK_8) {
				for (Sprite sprite : objects) {

					if (sprite instanceof Player) {
						Player player = (Player) sprite;
						player.setTool(new IceDagger(0, 0, ToolType.DIRECTIONAL));
					}
				}
			}

			if (key == KeyEvent.VK_9) {
				for (Sprite sprite : objects) {

					if (sprite instanceof Player) {
						Player player = (Player) sprite;
						player.setTool(new FireDagger(0, 0, ToolType.DIRECTIONAL));
					}
				}
			}

			if (key == KeyEvent.VK_F3) {
				debug = !debug;
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

	public void addRectangle(Rectangle rectangle) {
		rectangles.put(rectangle, 10000);
	}

}
