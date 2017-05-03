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
	float size;
	
	public Message(String message, int x, int y, Color text, Color outline, int thickness){
		this(message,x,y,text,outline,thickness,20);
	}
	public Message(String message, int x, int y, Color text, Color outline, int thickness,float size){
		this.message = message;
		this.x = x;
		this.y = y;
		this.text = text;
		this.outline = outline;
		this.thickness = thickness;
		this.size = size;
	}
	
	public void draw(Graphics g){
		g.getFont().deriveFont(size);
		Utils.drawOutlineString(g, message, x, y, text, outline, thickness);
	}

}
