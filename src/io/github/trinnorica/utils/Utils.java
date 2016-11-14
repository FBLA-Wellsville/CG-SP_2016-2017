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
	private static int level = 0;
	
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


	


	public static void runParticles(Point point, ParticleFormat format, ParticleType type, Direction d) {
		format.run(point, type, d);
	}


	//Level Key:
	/*
	 * X = Empty
	 * A = Cloud (Must have at least 2)
	 * B = Dirt background
	 * C = Top Dirt Arch
	 * D = 
	 * 
	 */
	public static char[] getLevelBlueprint(int level) {
		System.out.println("2");
		switch(level){
		case 1:
			return new char[]{
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','A','A','A','A','X','X','X','X','X','X','A','A','A','X','X','X','X','A','A','A','A','A','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','A','A','A','X','X','X','X','X','X','X','A','A','X','X','X','X','X','X','X','X','X','X','X','X','k',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','K',
					'X','X','X','X','X','A','A','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','K',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','G','G','G','G','G','G','G','G','X','X','X','X','X','K',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','G','G','G','G','G','G','G','G','G','G','G','X','X','X','X','K',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','G','G','G','G','G','G','G','G','G','G','G','G','G','X','X','X','K',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','G','X','K',
					'E','E','E','E','E','E','E','E','E','E','E','E','X','G','G','G','E','E','G','G','G','G','E','E','E','G','G','G','G','E','E','E',
					'B','B','B','B','B','B','B','B','B','B','B','B','E','G','G','G','B','B','G','G','G','G','B','B','B','G','G','G','G','B','B','B',
					'B','B','B','B','B','B','B','B','B','B','B','B','B','E','G','G','B','B','G','G','G','G','B','B','B','G','G','G','G','B','B','B',
					'B','B','F','C','C','C','F','B','B','B','B','B','B','B','E','G','G','B','G','G','G','G','B','B','B','G','G','G','G','B','B','G',
					'B','B','F','X','X','X','F','B','B','B','B','B','B','B','B','E','G','G','G','G','G','G','B','B','B','G','G','G','G','B','B','G',
					'B','B','F','X','X','X','F','B','B','B','B','B','B','B','B','B','E','G','G','G','G','G','B','B','B','G','G','G','G','B','B','G',
					'B','B','F','X','X','X','F','B','B','B','B','B','B','B','B','B','B','E','E','E','E','E','E','E','E','E','E','E','E','E','E','E',
			};
		case 2:
			return new char[]{
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','A','A','A','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','A','A','A','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','X','X','A','A','A','A','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','A','A','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','A','A','X','X','A','A','A','A','X','X','X','X','X','A','A','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','K',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','M','X','X','X','X','X','X','X','X','X','K',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','M','E','E','E','E','E','E','E','E','E','E',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','M','X','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','M','X','X','X','X','X','X','X','X','X','X',
					'E','E','E','E','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','M','X','X','X','X','X','X','X','X','X','X',
					'B','B','B','B','E','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','M','X','X','X','X','X','X','X','X','X','X',
					'B','B','B','B','B','E','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','M','X','X','X','X','X','X','X','X','X','X',
					'B','B','B','B','B','B','E','X','X','X','X','X','X','X','X','X','X','X','X','X','X','M','X','X','X','X','X','X','X','X','X','X',
					'D','D','D','D','D','D','D','E','X','X','X','X','X','X','X','X','X','X','X','X','X','M','X','X','X','X','X','X','X','X','X','X',
					'D','D','D','D','D','D','D','D','E','X','X','X','X','X','X','X','X','X','X','X','X','M','X','X','X','X','X','X','X','X','X','X',
					'D','D','D','D','D','D','D','D','D','E','E','E','E','E','E','E','E','E','E','E','E','E','X','X','X','X','X','X','X','X','X','X',
					'D','D','D','D','D','D','D','D','D','D','D','D','D','D','D','D','D','D','D','D','D','D','X','X','X','X','X','X','X','X','X','X',
			};
		case 3:

			return new char[]{
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','M',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','K','X','X','X','M',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','E','E','E','E','M',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','B','B','B','B','M',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','B','B','B','B','M',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','B','B','B','B','M',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','B','B','B','B','M',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','B','B','B','B','M',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','B','B','B','B','M',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','B','B','B','B','M',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','B','B','B','B','M',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','E','E','E','X','X','X','E','E','E','E','E','E','E','E','E','E',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','E','B','B','C','X','X','X','C','B','B','B','B','B','B','B','B','B',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','E','B','B','B','X','X','X','X','X','B','B','B','B','B','B','B','B','B',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','E','B','B','B','B','X','X','X','X','X','B','B','B','B','B','B','B','B','B',
					'X','X','X','X','X','X','X','X','X','X','X','X','E','B','B','B','B','B','X','X','X','X','X','B','B','B','B','B','B','B','B','B',
					'X','X','X','X','X','X','X','X','X','X','X','E','B','B','B','B','B','B','X','X','X','X','X','B','B','B','B','B','B','B','B','B',
					'E','E','E','E','E','E','E','E','E','E','E','B','B','B','B','B','B','B','X','X','X','X','X','B','B','B','B','B','B','B','B','B',
			};
		case 4:
			return new char[]{
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','K',
					'A','A','A','A','A','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','K',
					'X','X','X','X','X','A','A','X','A','A','A','X','A','A','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','A','A',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','A','A','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','A','A','A','X','X','X','X','X','X','X','X','A','A','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','A','A','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','A','A','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','A','A','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
			};
		case 5:
			return new char[]{
					'X','X','X','X','X','X','X','X','X','X','X','D','D','D','D','D','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','D','D','D','D','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','D','D','D','D','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','D','D','D','D','X','X','X','X','X','X','X','X','B','B','B','X','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','X','X','D','D','D','X','X','X','X','X','X','X','X','B','E','E','E','B','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','X','E','X','X','D','D','X','X','X','X','X','X','X','X','B','B','B','B','B','X','X','X','X',
					'X','X','X','X','X','X','X','X','X','E','D','X','X','D','D','X','X','X','X','X','X','X','B','E','B','B','B','B','X','X','X','X',
					'X','X','X','X','X','X','X','X','E','D','D','X','X','D','X','X','X','X','X','X','X','X','B','B','B','B','B','B','X','X','X','X',
					'X','X','X','X','X','X','X','E','D','D','D','X','X','D','X','X','X','X','X','X','X','B','E','B','B','B','B','B','X','X','X','X',
					'X','X','X','X','X','X','E','D','D','D','D','X','X','D','X','X','X','X','X','X','X','B','B','B','B','B','B','B','X','X','X','X',
					'X','X','X','X','X','E','D','D','D','D','D','X','X','D','X','X','X','X','X','X','B','E','B','B','B','B','B','B','B','X','X','X',
					'X','X','X','X','E','D','D','D','D','D','D','X','X','D','X','X','X','X','X','X','B','B','B','B','B','B','B','B','B','X','X','X',
					'X','X','X','E','D','D','D','D','D','D','D','X','X','X','X','X','X','X','X','B','E','B','B','B','B','B','B','B','B','X','X','K',
					'X','X','E','D','D','D','D','D','D','D','D','X','X','X','X','B','B','B','B','B','B','B','B','B','B','B','B','B','B','X','X','K',
					'X','E','D','D','D','D','D','D','D','D','D','X','X','X','X','E','E','E','E','E','B','B','B','B','B','B','B','B','B','B','X','K',
					'E','D','D','D','D','D','D','D','D','D','D','X','X','X','X','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','X','E',
					'D','D','D','D','D','D','D','D','D','D','D','X','X','X','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','X','X',
			};
		default: return null;
		
		}
	}


	public static int getLevelWidth(int level) {
		switch(level){
		case 1: return 32;
		case 2: return 32;
		case 3: return 32;
		default: return 32;
		}
	}
	
	public static int getLevelHeight(int level) {
		switch(level){
		case 1: return 17;
		case 2: return 17;
		case 3: return 17;
		default: return 17;
		}
	}


	public static int getLevel() {
		return level;
	}
	public static void setLevel(int level){
		Utils.level = level;
	}


	public static void debug(String message) {
		System.out.print("DEBUG:\n" + message + "\n");
	}


	

	

}
