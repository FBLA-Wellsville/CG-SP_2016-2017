package io.github.trinnorica.utils;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseEvent;

public interface Clickable {

	void select();
	void deselect();
	boolean selected();
	Polygon getPolygon();
	Polygon drawPolygon(Graphics g);

}
