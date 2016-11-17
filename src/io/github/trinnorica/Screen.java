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
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;

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
import io.github.trinnorica.utils.Utils;
import io.github.trinnorica.utils.particles.Particle;
import io.github.trinnorica.utils.sprites.Empty;
import io.github.trinnorica.utils.sprites.Keyable;
import io.github.trinnorica.utils.sprites.Moveable;
import io.github.trinnorica.utils.sprites.Sprite;
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
	boolean debug = false;
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
	private int timeri=0;
	private int timeril=1;
	private boolean loading = true;

	public Screen() {
		init();
	}

	public void init() {

		timer = new Timer(INITIALDELAY, this);
		timer.start();

		addKeyListener(new TAdapter());
//		addMouseMotionListener(new MMListener()); 
//		addMouseListener(new MListener());

		setLayout(null);

		setFocusable(true);

		setPreferredSize(new Dimension(1920, 1080));

		setSize(new Dimension(1920, 1080));
		setMinimumSize(new Dimension(1920, 1080));
		
		Main.setScreen(this);
		java.util.Timer t = new java.util.Timer();
		t.schedule(new TimerTask() {
			public void run() {
				Main.setBoard(Board.MAIN);
			}
		}, 500);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawMenu(g);
		Toolkit.getDefaultToolkit().sync();
	}

	public void drawMenu(Graphics g) {
		graphics = g;
		
		g.setFont(Main.getFont().deriveFont((float) 20.0));
		
		if(loading){
			if(timeril == 1){
				Utils.drawOutlineString(g, "Loading.", getWidth() / 2 - g.getFontMetrics().stringWidth("Loading...") / 2, getHeight() / 2, Color.RED, Color.BLACK, 1);
			}
			if(timeril == 2){
				Utils.drawOutlineString(g, "Loading..", getWidth() / 2 - g.getFontMetrics().stringWidth("Loading...") / 2, getHeight() / 2, Color.RED, Color.BLACK, 1);
			}
			if(timeril == 3){
				Utils.drawOutlineString(g, "Loading...", getWidth() / 2 - g.getFontMetrics().stringWidth("Loading...") / 2, getHeight() / 2, Color.RED, Color.BLACK, 1);
			}

			timeril+=1;
			if(timeril >3){
				timeril = 1;
			}
			if(timeri <=new Random().nextInt(20)){
				timeri+=1;
				return;
			}
			
			
			timer.setDelay(DELAY);
			loading = false;
			
		}
		
		
		
		
		//Main Menu
		if (board == Board.MAIN) {
			menuvar = Utils.drawScrollingImage(g, Backgrounds.MAIN.getImage(), menuvar, 0, this.getWidth(),
					this.getHeight(), 1);
			Utils.drawOutlineString(g, "Press P to play!", getWidth()/2 - (g.getFontMetrics().stringWidth("Press P to play!")/2), getHeight()/4 + getHeight()/2, Color.decode("#99db45"), Color.WHITE, 1);
			

			g.drawImage(ExternalFile.loadTexture("entity/player/player.png"), getWidth() / 4, getHeight() / 2, 60, 60,
					this);
			g.drawImage(ExternalFile.loadTexture("entity/knight/knight.png"), getWidth() / 4 + getWidth() / 2,
					getHeight() / 2, 60, 60, this);
			Image logo = ExternalFile.loadTexture("logos/logo-title.png");
			g.drawImage(Images.makeImageTranslucent(Images.toBufferedImage(logo), 0.9),
					this.getWidth() / 2 - logo.getWidth(this) / 2, this.getHeight() / 2 - logo.getHeight(this) / 2,
					this);

		}

		
		//Credits! :D
		if (board == Board.CREDITS) {
			g.drawImage(Backgrounds.CREDITS.getImage(), 0, 0, getWidth(), getHeight(), this);
			Image dark = Images.makeImageTranslucent(Images.toBufferedImage(Images.createColorImage("#000000")), 0.5);
			g.drawImage(dark, 0, 0, getWidth(), getHeight(), this);
			dark = null;
			g.setFont(new Font("Helvetica", Font.BOLD, getWidth() / 50));
			Utils.drawCredit(g, "Author & Developers:", creditvar, 1, Color.BLACK, Color.WHITE, 1);
			g.setFont(new Font("Helvetica", Font.PLAIN, getWidth() / 50));
			Utils.drawCredit(g, "Cameron Witcher", creditvar, 2, Color.BLACK, Color.WHITE, 1);
			Utils.drawCredit(g, "Blake Ohlmeier", creditvar, 3, Color.BLACK, Color.WHITE, 1);

			g.setFont(new Font("Helvetica", Font.BOLD, getWidth() / 50));
			Utils.drawCredit(g, "Artists and Concept designers", creditvar, 5, Color.BLACK, Color.WHITE, 1);
			g.setFont(new Font("Helvetica", Font.PLAIN, getWidth() / 50));
			Utils.drawCredit(g, "Herb Yeliab (Head Artist)", creditvar, 6, Color.BLACK, Color.WHITE, 1);

			Image logo = ExternalFile.loadTexture("logos/logo-title.png");

			Utils.drawCreditImage(g, logo, creditvar, 8);

			creditvar -= 1;

			if (Utils.creditsOver(g, creditvar, 8)) {
				Main.setBoard(Board.MAIN);
			}

		}
		
		

		//This is where all the fun happens! :)
		if (board == Board.GAME) {
			g.drawImage(Backgrounds.SKY.getImage(), 0, 0, getWidth(), getHeight(), this);
			
			for(Sprite sprite : objects_temp){
				objects.add(sprite);
			}
			objects_temp.clear();
				
			try{
				for (Sprite sprite : objects) {
					
					if(sprite instanceof Empty){
						objects_remove.add(sprite);
						continue;
					}
					if (sprite instanceof Moveable) {
						((Moveable) sprite).move();
					}
					if(!(sprite instanceof Particle)) sprite.draw(g);
					
					if(sprite.x < -100 || sprite.x > 2000){
						objects_remove.add(sprite);
					}
					
					if(sprite instanceof Particle){
						Particle p = (Particle) sprite;
						p.draw(g);
						if(p.getLifetime() <=0){
							objects_remove.add(p);
						}
					}
				}
			} catch(ConcurrentModificationException ex){
				Utils.debug("ConcurrentModificationException 2 (Screen)");
			}
			
			
			try{
				for(int i=0;i!=Main.getPlayer().getMaxLives();i++){
					if(i<Main.getPlayer().getLives()){
						g.drawImage(ExternalFile.loadTexture("heart.png"), i*30, 0, 30, 30, this);
						} else {
							g.drawImage(ExternalFile.loadTexture("broken-heart.png"), i*30, 0, 30, 30, this);
						}
					}
			} catch(NullPointerException ex){}
			
			for(Sprite sprite : objects_remove){
				objects.remove(sprite);
			}
			
			objects_remove.clear();
			
			//Draw Info
			g.setFont(Main.getFont().deriveFont(15f));
			Utils.drawOutlineString(g, "Level: " + Utils.getLevel(), getWidth()-(g.getFontMetrics().stringWidth("Level: " + Utils.getLevel())), 20, Color.decode("#99db45"), Color.WHITE, 1);
			
			//Draw Leaderboard
			
			g.drawImage(Images.makeImageTranslucent(Images.toBufferedImage(Images.createColorImage("#000000")), 0.5), getWidth()-200, getHeight()/3, 200, 110, this);
			g.setFont(Main.getFont().deriveFont(10f));
			
			Utils.drawOutlineString(g, "Leaderboard", (getWidth()-100)-(g.getFontMetrics().stringWidth("Leaderboard")/2), getHeight()/3+(Main.getFont().getSize()*12), Color.YELLOW, Color.WHITE, 0);
			String[] highscores = new String[]{"1","2","3","4","5","6"};
			for(int l=0;l!=highscores.length;l++){
				Utils.drawOutlineString(g, highscores[l], (getWidth()-100)-(g.getFontMetrics().stringWidth(highscores[l])/2), (getHeight()/3+(Main.getFont().getSize()*12))+(((Main.getFont().getSize()*12)*(l+1))+(l*4)), Color.WHITE, Color.WHITE, 0);
				
			}
			
			
			
		}
		
		
		
		if (board == Board.LEVELUP) {
			g.drawImage(Backgrounds.MAIN.getImage(), 0, 0, getWidth(), getHeight(), this);
			
			Utils.drawOutlineString(g, "You won level " + Utils.getLevel() + "!", getWidth()/2, getHeight()/3, Color.decode("#99db45"), Color.WHITE, 1);
			Utils.drawOutlineString(g, "Press P to play!", getWidth()/2, getHeight()/2, Color.decode("#99db45"), Color.WHITE, 1);
			
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
			try {
				for(Sprite s : objects){
					if(!(s instanceof Player)) continue;
					Utils.drawOutlineString(g, "Flying: " + ((Player)s).flying, 0, 80, Color.WHITE,
							Color.BLACK, 1);
					Utils.drawOutlineString(g, "Jumping: " + ((Player) s).jumping, 0, 100, Color.WHITE,
							Color.BLACK, 1);
					Utils.drawOutlineString(g, "Onground: " + ((Player) s).onground, 0, 120, Color.WHITE,
							Color.BLACK, 1);
					Utils.drawOutlineString(g, "Playing: True", 0, 140, Color.WHITE, Color.BLACK, 1);
					Utils.drawOutlineString(g, "Climbing: " + ((Player) s).climbing, 0, 160, Color.WHITE, Color.BLACK, 1);
					if(((Player)s).getTool() != null)Utils.drawOutlineString(g, "Tool: " + ((Player) s).getTool().getClass().getSimpleName(), 0, 180, Color.WHITE, Color.BLACK, 1);
					else Utils.drawOutlineString(g, "Tool: null", 0, 180, Color.WHITE, Color.BLACK, 1);
					Utils.drawOutlineString(g, "Left: " + ((Player) s).left, 0, 200, Color.WHITE, Color.BLACK, 1);
					Utils.drawOutlineString(g, "Right: " + ((Player) s).right, 0, 220, Color.WHITE, Color.BLACK, 1);
					Utils.drawOutlineString(g, "Location: " + ((Player) s).getLocation(), 0, 240, Color.WHITE, Color.BLACK, 1);
					break;
				}
				
			} catch (IndexOutOfBoundsException ex) {
				Utils.drawOutlineString(g, "Playing: False", 0, 100, Color.WHITE, Color.BLACK, 1);
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

	private class TAdapter extends KeyAdapter {

		@Override
		public void keyReleased(KeyEvent e) {
			for (Sprite sprite : objects) {
				if (sprite instanceof Keyable)
					((Keyable) sprite).keyReleased(e);
			}

		}

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_5) {
				for (Sprite sprite : objects) {

					if (sprite instanceof Player) {
						Player player = (Player) sprite;
						player.setTool(new Sword(0, 0));
					}
				}
			}
			
			if(key == KeyEvent.VK_P){
				if(!(Main.getBoard() == Board.GAME)){
					Utils.setLevel(Utils.getLevel()+1);
				Main.setBoard(Board.GAME);
				}
				
			}
			
			if(key == KeyEvent.VK_C){
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
//				LevelBuilder l = new LevelBuilder();
//				l.buildLevel(new char[]{
//						'A','B','B','C','X','A','C','X','A','C',
//				},10,1);
			}
			
			if (key == KeyEvent.VK_F3) {
				if (debug)
					debug = false;
				else
					debug = true;
			}
			if (key == KeyEvent.VK_R) {
				Main.setBoard(Board.MAIN);
			}
			

		
			for (Sprite sprite : objects) {
				if (sprite instanceof Keyable)
					((Keyable) sprite).keyPressed(e);
			}

		}
	}


	public void addSprites(Sprite sprite) {
		objects_temp.add(sprite);
	}

}
