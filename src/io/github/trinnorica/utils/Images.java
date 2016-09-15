package io.github.trinnorica.utils;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;

public class Images {
	
	public static Image toImage(BufferedImage bimage){
        // Casting is enough to convert from BufferedImage to Image
        Image img = (Image) bimage;
        return img;
    }
	
	public static Image getEmptyImage(int width, int height){
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        return toImage(img);
    }

	public static Image rotate(Image img, double angle) {
		double sin = Math.abs(Math.sin(Math.toRadians(angle))),
				cos = Math.abs(Math.cos(Math.toRadians(angle)));

		int w = img.getWidth(null), h = img.getHeight(null);

		int neww = (int) Math.floor(w*cos + h*sin),
				newh = (int) Math.floor(h*cos + w*sin);

		BufferedImage bimg = toBufferedImage(getEmptyImage(neww, newh));
		Graphics2D g = bimg.createGraphics();

		g.translate((neww-w)/2, (newh-h)/2);
		g.rotate(Math.toRadians(angle), w/2, h/2);
		g.drawRenderedImage(toBufferedImage(img), null);
		g.dispose();

		return toImage(bimg);
	}

	public static Image makeColorTransparent(Image im, final Color color) {
		ImageFilter filter = new RGBImageFilter() {
			// the color we are looking for... Alpha bits are set to opaque
			public int markerRGB = color.getRGB() | 0xFF000000;

			@Override
			public final int filterRGB(int x, int y, int rgb) {
				if ((rgb | 0xFF000000) == markerRGB) {
					// Mark the alpha bits as zero - transparent
					return 0x00FFFFFF & rgb;
				} else {
					// nothing to do
					return rgb;
				}
			}
		};

		ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
		return Toolkit.getDefaultToolkit().createImage(ip);
	}

	public static Image makeImageTranslucent(BufferedImage source, double alpha) {
		BufferedImage target = new BufferedImage(source.getWidth(), source.getHeight(), Transparency.TRANSLUCENT);
		Graphics2D g = target.createGraphics();
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) alpha));
		g.drawImage(source, null, 0, 0);
		g.dispose();
		source = null;
		return target;
	}

	public static BufferedImage toBufferedImage(Image img) {
		if (img instanceof BufferedImage) {
			return (BufferedImage) img;
		}

		// Create a buffered image with transparency
		BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		// Draw the image on to the buffered image
		Graphics2D bGr = bimage.createGraphics();
		bGr.drawImage(img, 0, 0, null);
		bGr.dispose();

		// Return the buffered image
		return bimage;
	}

	
	
	
//	public static void colorSprite(BufferedImage image, Sprite tool, int id) {
//		
//		
//		int r=255;
//		int g=255;
//		int b=255;
//		switch(id){
//		case 1:
//			r=234;
//			g=59;
//			b=27;
//			break;
//		case 2:
//			r=8;
//			g=199;
//			b=84;
//			break;
//		case 3:
//			r=239;
//			g=142;
//			b=20;
//			break;
//		case 4:
//			r=244;
//			g=244;
//			b=244;
//			break;
//		default:
//			break;
//		}
//		
//		Color color = new Color(r,g,b);
//		
//		
//		
//		
//		for(int x=0;x!=image.getWidth();x++){
//			for(int y=0;y!=image.getHeight();y++){
//				if(image.getRGB(x, y) == Color.decode("#C4C400").getRGB())
//					image.setRGB(x, y, color.getRGB());
//				if(image.getRGB(x, y) == Color.decode("#484800").getRGB())
//					image.setRGB(x, y, Color.BLACK.getRGB());
//				if(image.getRGB(x, y) == Color.decode("#939300").getRGB())
//					image.setRGB(x, y, Color.BLACK.getRGB()/*color.brighter().darker().getRGB()*/);
//				
//			}
//		}
//		
//		tool.loadImage(image);
//		
//	}
	
	

	public static Image createColorImage(String string) {
		BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		image.setRGB(0, 0, Color.decode(string).getRGB());
		return image;
		
	}

	public static Image createRGBAImage(float r, float g, float b, float d) {
		BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		
		image.setRGB(0, 0, new Color(r, g, b).getRGB());
		return image;
	}
	
//	public static void setPolygon(Polygon p, Image image){
//		BufferedImage i = toBufferedImage(image);
//		for(int x=0;x!=i.getWidth();x++){
//			for(int y=0;y!=i.getHeight();y++){
//				if(i.getTransparency() == BufferedImage.TRANSLUCENT){
//					i.setRGB(x, y, Color.RED.getRGB());
//				}
//			}
//		}
//	}
}