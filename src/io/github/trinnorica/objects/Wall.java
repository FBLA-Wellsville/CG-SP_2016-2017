package io.github.trinnorica.objects;

import java.awt.Color;
import java.awt.Image;

import io.github.trinnorica.utils.Images;
import io.github.trinnorica.utils.sprites.Collidable;

public class Wall extends Collidable {

	
	public Wall(int x, int y) {
		super(x, y);
		init();
	}
	
	public Wall(int x, int y, Color color) {
		super(x, y);
		init(color);
	}
	
	public Wall(int x, int y, Image image, int width, int height) {
		super(x, y);
		init(image,width,height);
	}

	private void init() {
		setImageDimensions(30, 30);
	}
	
	private void init(Color color) {
		loadImage(Images.createColorImage(color));
		setImageDimensions(30, 30);
	}
	
	private void init(Image image, int width, int height) {
		loadImage(image);
		setImageDimensions(height, width);
	}
	

}
