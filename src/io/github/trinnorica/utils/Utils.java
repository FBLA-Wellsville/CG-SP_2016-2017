package io.github.trinnorica.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.utils.particles.ParticleFormat;
import io.github.trinnorica.utils.particles.ParticleType;
import res.ExternalFile;

public class Utils {

	private static Version version;
	private static int level = 0;
	private static HashMap<String,Integer> highscores = new HashMap<>();
	private static ValueComparator bvc = new ValueComparator(highscores);
	private static TreeMap<String,Integer> thighscores = new TreeMap<>(bvc);
	private static File file = null;
	private static File folder;

	private static boolean hasplayedbefore = true;
	
	public static void start() {
		folder = new File("C:/KANSAS_WELLSVILLE_HIGHSCHOOL/Eldiseth/");
		if (!folder.exists())
			folder.mkdirs();
		
		
		version = ExternalFile.getVersion__BOOT_ONLY__();
		
	}
	
	public static boolean hasPlayedBefore(){
		return hasplayedbefore;
	}

	public static boolean hasPlayedBefore(boolean played){
		hasplayedbefore = played;
		return hasplayedbefore;
	}

	public static void drawOutlineString(Graphics g, String string, int x, int y, Color text, Color outline,
			int thickness) {
		if (string.contains("\n")) {
			String[] a = string.split("\n");
			for (int i = 0; i != a.length; i++) {
				g.setColor(outline);
				for (int ii = 1; ii != thickness + 1; ii++) {
					g.drawString(a[i], x - (g.getFontMetrics().stringWidth(a[i]) / 2) - ii,
							y + (i * g.getFontMetrics().getHeight()) - ii);
					g.drawString(a[i], x - (g.getFontMetrics().stringWidth(a[i]) / 2) - ii,
							y + (i * g.getFontMetrics().getHeight()) + ii);
					g.drawString(a[i], x - (g.getFontMetrics().stringWidth(a[i]) / 2) + ii,
							y + (i * g.getFontMetrics().getHeight()) - ii);
					g.drawString(a[i], x - (g.getFontMetrics().stringWidth(a[i]) / 2) + ii,
							y + (i * g.getFontMetrics().getHeight()) + ii);
				}
				g.setColor(text);
				g.drawString(a[i], x - (g.getFontMetrics().stringWidth(a[i]) / 2),
						y + (i * g.getFontMetrics().getHeight()));
			}
		} else {
			g.setColor(outline);
			for (int i = 1; i != thickness + 1; i++) {
				g.drawString(string, x - i, y - i);
				g.drawString(string, x - i, y + i);
				g.drawString(string, x + i, y - i);
				g.drawString(string, x + i, y + i);
			}

			g.setColor(text);

			g.drawString(string, x, y);
		}

	}

	public static String getVersion() {
		return version.getVersion();
	}

	public static double drawScrollingImage(Graphics g, Image image, double x, int y, int width, int height,
			int speed) {
		g.drawImage(image, (int) x, y, width, height, null);
		g.drawImage(image, (int) (x + width), y, width, height, null);

		x -= speed;

		// Check to see if the image has gone off stage left
		if (x <= -1 * width) {

			// If it has, line it back up so that its left edge is
			// lined up to the right side of the other background image
			x = 0;
		}

		return x;
	}

	public static void drawCredit(Graphics g, String string, int creditvar, int i, Color outlinecolor, Color textcolor,
			int thickness) {
		drawOutlineString(g, string, Main.getScreen().getWidth() / 2 - g.getFontMetrics().stringWidth(string) / 2,
				(((g.getFontMetrics().getHeight()) * i) + creditvar) + Main.getScreen().getHeight(), textcolor,
				outlinecolor, thickness);

	}

	public static void drawCreditImage(Graphics g, Image img, int creditvar, int i) {
		g.drawImage(img, Main.getScreen().getWidth() / 2 - img.getWidth(null) / 2,
				(((g.getFontMetrics().getHeight()) * i) + creditvar) + Main.getScreen().getHeight(), null);
	}

	public static boolean creditsOver(Graphics g, int creditvar, int i) {

		if ((((g.getFontMetrics().getHeight()) * i) + creditvar == -540)) {
			return true;
		}
		return false;
	}

	public static void runParticles(Point point, ParticleFormat format, ParticleType type, Direction d) {
		format.run(point, type, d);
	}

	public static void runParticles(Point point, ParticleFormat format, ParticleType type, Direction d,
			int minimumLifetime) {
		format.run(point, type, d, minimumLifetime);
	}
	public static void runParticles(Point point, ParticleFormat format, ParticleType type, Direction d, Entity shooter) {
		format.run(point, type, d, shooter);
	}

	

	public static int getLevel() {
		return level;
	}

	public static void setLevel(int level) {
		Utils.level = level;
	}

	public static void debug(String message) {
		if(Main.getScreen().debug) System.out.print("DEBUG:\n" + message + "\n");
	}

//	public static void sendToConfig(String score) {
//		try {
//			// Create file
//			FileWriter fstream = new FileWriter(config);
//			BufferedWriter out = new BufferedWriter(fstream);
//			out.write(score);
//			// Close the output stream
//			out.close();
//		} catch (Exception e) {// Catch exception if any
//			System.err.println("Error: " + e.getMessage());
//		}
//	}

//	public static String readConfig() throws IOException {
//		byte[] encoded = Files.readAllBytes(Paths.get(config.getPath()));
//		return new String(encoded, Charset.defaultCharset());
//
//	}
	
	public static String readFile(File file) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(file.getPath()));
		return new String(encoded, Charset.defaultCharset());
	}

	public static Map<String, Integer> getHighScores() {
		
		thighscores.clear();
		
		if(highscores.size() == 0){
			for(File file: folder.listFiles()) {
				if(file.getName().contains(".score")){
					try {
						highscores.put(file.getName().replace(".score", ""), Integer.parseInt(readFile(file)));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			
		}
		thighscores.putAll(highscores);
		return thighscores;
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue( Map<K, V> map ) {
		List<Map.Entry<K, V>> list = new LinkedList<>( map.entrySet() );
		Collections.sort( list, new Comparator<Map.Entry<K, V>>(){
			@Override
			public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2 ){
				return ( o1.getValue() ).compareTo( o2.getValue() );
			}
		});
		Map<K, V> result = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : list){
			result.put( entry.getKey(), entry.getValue() );
		}
		return result;
	}

	public static void createScore(String name) {
		file = new File(folder.getPath() + "/" + name + ".score");
		

		if(!file.exists())
			try {
				file.createNewFile();
				sendScore(0);
				hasplayedbefore = false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else {
			try {
				setScore(Integer.parseInt(readFile(file)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void setScore(int score){
		Main.setScore(score);
	}

	public static void sendScore(int score) {
		
		Main.setScore(score);
		
		BufferedWriter writer = null;
        try {
            //create a temporary file

            // This will output the full path where the file will be written to...
//            System.out.println(logFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(file));
            writer.write(score +"");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
		
//		try {
//			// Create file
//			FileWriter fstream = new FileWriter(file);
//			BufferedWriter out = new BufferedWriter(fstream);
//			out.write(score);
//			// Close the output stream
//			out.close();
//			System.out.println("SCORE: " + score);
//		} catch (Exception e) {// Catch exception if any
//			System.err.println("Error: " + e.getMessage());
//		}

	}

	public static Color getGreenColor() {
		return Color.decode("#99db45");
	}

	public static int getDistanceX(Entity attacker, Entity entity) {
		return (int) Math.sqrt(Math.pow(attacker.x - entity.x, 2));
	}
	public static int getDistanceY(Entity attacker, Entity entity) {
		return (int) Math.sqrt(Math.pow(attacker.y - entity.y, 2));
	}
	public static int getDistance(Entity attacker, Entity entity) {
		return (int) Math.sqrt(Math.pow(attacker.x - entity.x, 2) + Math.pow(attacker.y - entity.y, 2));
	}
	
}
