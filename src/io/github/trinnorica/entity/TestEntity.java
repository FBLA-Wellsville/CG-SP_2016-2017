package io.github.trinnorica.entity;

import io.github.trinnorica.Main;
import io.github.trinnorica.objects.tools.Stick;
import io.github.trinnorica.utils.DamageReason;
import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.Utils;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.sprites.Moveable;
import io.github.trinnorica.utils.sprites.Sprite;
import io.github.trinnorica.utils.sprites.Tool;

import java.awt.Graphics;
import java.util.ConcurrentModificationException;

import res.ExternalFile;

public class TestEntity extends Entity implements Moveable {

	double dx = 0;
	double dy = 0;
	boolean falling = false;
	public boolean onground = false;
	public boolean jumping = false;
	private Tool tool;
	private int s = 1;

	public TestEntity(int x, int y) {
		super(x, y);
		initEntity();
		// TODO Auto-generated constructor stub
	}

	private void initEntity() {
		loadImage(ExternalFile.loadTexture("entity/ogre/ogre.png"));
		setImageDimensions(27 + s, 30 + s);
		setTool(new Stick(0,0));
	}



	@Override
	public void move() {
		
		onground = false;
		
		
		getPolygon();
		
		try{
			for (Sprite s : Main.getScreen().objects) {
				if(s == this) continue;
				if(!bounds.intersects(s.getPolygon().getBounds())) continue;
				else onground = true;
			}
		} catch(ConcurrentModificationException ex){
			Utils.debug("ConcurrentModificationException 1 (TestEntity)");
		}
		
		if(!onground)y=y+1;


	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(getImage(), x, y, width, height, null);
		if (direction == Direction.RIGHT) {
			g.drawImage(getImage(), x, y, width, height, null);
			g.drawImage(tool.getImage(), x + 20, y, tool.getWidth(), tool.getHeight(), null);
				

			}
			
		
	}



	public void setTool(Tool tool) {
		this.tool = tool;

	}

	public Sprite getTool() {
		return tool;
	}


	

}
