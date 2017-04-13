package io.github.trinnorica.utils.ui;

import java.awt.Color;
import java.awt.Graphics;

import io.github.trinnorica.utils.Utils;

public class Message {
	
	String message;
	int x;
	int y;
	Color text;
	Color outline;
	int thickness;
	
	public Message(String message, int x, int y, Color text, Color outline, int thickness){
		this.message = message;
		this.x = x;
		this.y = y;
		this.text = text;
		this.outline = outline;
		this.thickness = thickness;
	}
	
	public void draw(Graphics g){
		Utils.drawOutlineString(g, message, x, y, text, outline, thickness);
	}

}
