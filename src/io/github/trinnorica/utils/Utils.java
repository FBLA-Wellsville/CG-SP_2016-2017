package io.github.trinnorica.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import io.github.trinnorica.Main;
import io.github.trinnorica.utils.particles.ParticleFormat;
import io.github.trinnorica.utils.particles.ParticleType;
import res.ExternalFile;

public class Utils {
	
	private static Version version;
	
	public static void start() {
		version = ExternalFile.getVersion__BOOT_ONLY__();
	}


	public static void drawOutlineString(Graphics g, String string, int x, int y, Color text, Color outline, int thickness){
		g.setColor(outline);
		for(int i=1;i!=thickness+1;i++){
			g.drawString(string, x-i, y-i);
			g.drawString(string, x-i, y+i);
			g.drawString(string, x+i, y-i);
			g.drawString(string, x+i, y+i);
		}
		
		g.setColor(text);
		g.drawString(string, x, y);
	}


	public static String getVersion() {
		return version.getVersion();
	}


	public static double drawScrollingImage(Graphics g, Image image, double x, int y, int width, int height, int speed) {
		g.drawImage(image, (int) x, y, width, height, null);
		g.drawImage(image, (int) (x+width), y, width, height, null);
		 
        x -= speed;
 
        // Check to see if the image has gone off stage left
        if (x <= -1 * width) {
 
            // If it has, line it back up so that its left edge is
            // lined up to the right side of the other background image
            x = 0;
        }
        
        return x;
	}


	public static void drawCredit(Graphics g, String string, int creditvar, int i, Color outlinecolor, Color textcolor, int thickness) {
		drawOutlineString(g, string, Main.getScreen().getWidth()/2 - g.getFontMetrics().stringWidth(string)/2, (((g.getFontMetrics().getHeight())*i)+creditvar)+Main.getScreen().getHeight(), textcolor, outlinecolor, thickness);
		
	}


	public static void drawCreditImage(Graphics g, Image img, int creditvar, int i) {
		g.drawImage(img, Main.getScreen().getWidth()/2-img.getWidth(null)/2, (((g.getFontMetrics().getHeight())*i)+creditvar)+Main.getScreen().getHeight(), null);
	}


	public static boolean creditsOver(Graphics g, int creditvar, int i) {

		if((((g.getFontMetrics().getHeight())*i)+creditvar==-540)){
			return true;
		}
		return false;
	}


	public static boolean getIntersectionDirection(Rectangle bounds, Rectangle bounds2) {
		// TODO Auto-generated method stub
		return false;
	}


	public static void runParticles(Point point, ParticleFormat format, ParticleType type) {
		format.run(point, type);
	}


	public static char[] getLevelBlueprint(int level) {
		System.out.println("2");
		switch(level){
		case 1:
			return new char[]{
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','A','A','A','A','X','X','X','X','X','X','A','A','A','X','X','X','X','A','A','A','A','A','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','A','A','A','X','X','X','X','X','X','X','A','A','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','A','A','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','K',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','K',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','K',
					'J','J','J','J','J','J','J','J','J','J','J','J','X','X','X','X','J','J','X','X','X','X','J','J','J','X','X','X','X','J','J','J',
					'D','D','D','D','D','D','D','D','D','D','D','D','J','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'D','D','D','D','D','D','D','D','D','D','D','D','D','J','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'D','D','D','D','D','D','D','D','D','D','D','D','D','D','J','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'D','D','D','X','X','X','D','D','D','D','D','D','D','D','D','J','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'D','D','D','X','X','X','D','D','D','D','D','D','D','D','D','D','J','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'D','D','D','X','X','X','D','D','D','D','D','D','D','D','D','D','D','J','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
			};
		default: return null;
		
		}
	}


	public static int getLevelWidth(int level) {
		switch(level){
		case 1: return 32;
		default: return 1;
		}
	}
	
	public static int getLevelHeight(int level) {
		switch(level){
		case 1: return 17;
		default: return 1;
		}
	}


	public static int getLevel() {
		// TODO Auto-generated method stub
		return 1;
	}


	

	

}
