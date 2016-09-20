package io.github.trinnorica;

import java.util.ArrayList;
import java.util.List;

import io.github.trinnorica.entity.Player;
import io.github.trinnorica.entity.projectiles.Projectile;
import io.github.trinnorica.objects.Floor;
import io.github.trinnorica.utils.Board;
import io.github.trinnorica.utils.Button;
import io.github.trinnorica.utils.Clickable;
import io.github.trinnorica.utils.Utils;

public class Main {
	
	public static double gravity = 0.2;
	public static double wind = 0.0;
	private static List<Clickable> clickables = new ArrayList<>();
	protected static List<Clickable> clickables_t = new ArrayList<>();
	private static Screen screen;
	
	
	public static void main(String[] args){
		Utils.start();
		new Window();
		
	}
	
	public static void setScreen(Screen screen){
		Main.screen = screen;
	}
	public static Screen getScreen(){
		return screen;
	}
	
	public static void setBoard(int board){
		clickables.clear();
		screen.board = board;
		
		if(board == Board.MAIN){
			screen.menuvar = 0;
			screen.objects.clear();
			screen.objects.add(new Floor(30*1,500));
			screen.objects.add(new Floor(30*2,500-(7*1)));
			screen.objects.add(new Floor(30*3,500-(7*2)));
			screen.objects.add(new Floor(30*4,500-(7*3)));
			screen.objects.add(new Floor(30*5,500-(7*4)));
			screen.objects.add(new Floor(30*6,500-(7*5)));
			screen.objects.add(new Floor(30*7,500-(7*6)));
			screen.objects.add(new Floor(30*8,500-(7*7)));
			
			screen.objects.add(new Player(50,50));
			
			
//			Button b = new Button(screen.getWidth()/4, screen.getHeight()/4 + screen.getHeight()/2, screen.getWidth()/8, 40, "Play", new Runnable(){
//				
//				@Override
//				public void run(){
//					screen.objects.clear();
//					screen.objects.add(new Floor(50,500));
//					screen.objects.add(new Player(50,50));
//					
//				}
//			});
//			b.select();d
//			clickables.add(b);
//
//
//			clickables.add(new Button(screen.getWidth()/4 + screen.getWidth()/2, screen.getHeight()/4 + screen.getHeight()/2, screen.getWidth()/8, 40, "Credits", new Runnable(){	
//				@Override
//				public void run(){
//					screen.objects.clear();
//					setBoard(Board.CREDITS);	
//				}
//			}));
		}
		if(board == Board.CREDITS){
			screen.creditvar = 0;
		}
	}
	public static List<Clickable> getClickables(){
		return clickables;
		
	}

	public static void addProjectile(Projectile pro) {
		screen.addSprites(pro);
	}

}
