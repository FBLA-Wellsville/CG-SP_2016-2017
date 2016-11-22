package io.github.trinnorica;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.github.trinnorica.entity.Player;
import io.github.trinnorica.objects.Floor;
import io.github.trinnorica.utils.Board;
import io.github.trinnorica.utils.Button;
import io.github.trinnorica.utils.Clickable;
import io.github.trinnorica.utils.Utils;
import io.github.trinnorica.utils.levels.LevelBuilder;
import io.github.trinnorica.utils.sprites.Projectile;
import io.github.trinnorica.utils.sprites.Sprite;
import res.ExternalFile;

public class Main {
	
	public static double gravity = 0.2;
	public static double wind = 0.0;
	private static List<Clickable> clickables = new ArrayList<>();
	protected static List<Clickable> clickables_t = new ArrayList<>();
	private static Screen screen;
	private static Font pixel;
	private static Player player;
	private static int board;
	
	
	public static void main(String[] args){
		try {
		     GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     pixel = Font.createFont(Font.TRUETYPE_FONT, ExternalFile.loadFont("pixeled.ttf"));
		     
		     ge.registerFont(pixel);
		} catch (Exception ex) {
		     //Handle exception
		}
		Utils.start();
		new Window();
		
	}
	public static Font getFont(){
		return pixel;
	}
	
	public static void setScreen(Screen screen){
		Main.screen = screen;
	}
	public static Screen getScreen(){
		return screen;
	}
	
	public static void setBoard(int board){
		clickables.clear();
		Main.board = board;
		screen.board = board;
		screen.objects.clear();
		if(board == Board.MAIN){
			screen.menuvar = 0;
			screen.objects.clear();
			
			
		}
		
		if(board == Board.GAME){
			try{
				Main.clearObjects();

				LevelBuilder l = new LevelBuilder();
				int level = Utils.getLevel();
				l.buildLevel(Utils.getLevelBlueprint(level),Utils.getLevelWidth(level),Utils.getLevelHeight(level));
			} catch(NullPointerException ex){
				setBoard(Board.WIN);
			}
			
			
			
		}
		if(board == Board.CREDITS){
			screen.creditvar = 0;
		}
	}
	public static List<Clickable> getClickables(){
		return clickables;
		
	}

	public static void addSprite(Sprite s) {
		screen.addSprites(s);
	}
	public static void clearObjects(){
		for(Sprite s : screen.objects)
			screen.objects_remove.add(s);
	}

	public static Player getPlayer() {
		if(player == null){
			for(Sprite sprite : screen.objects)
				if(sprite instanceof Player) return ((Player) sprite);
		}
		return player;
	
	}
	public static void removeSprite(Sprite s) {
		if(screen.objects.contains(s))
				screen.objects_remove.add(s);
		
	}
	
	
	public static int getBoard() {
		return board;
	}
	public static Graphics getGraphics() {
		return Screen.graphics;
	}
	
}
