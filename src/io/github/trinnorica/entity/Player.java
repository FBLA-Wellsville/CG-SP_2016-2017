package io.github.trinnorica.entity;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.KeyEvent;

import io.github.trinnorica.Main;
import io.github.trinnorica.objects.Collidable;
import io.github.trinnorica.objects.tools.FireStaff;
import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.Keyable;
import io.github.trinnorica.utils.Moveable;
import io.github.trinnorica.utils.Sprite;
import io.github.trinnorica.utils.Tool;
import io.github.trinnorica.utils.Velocity;
import res.ExternalFile;

public class Player extends Entity implements Moveable,Keyable {
	
	double dx=0;
	double dy=0;
	boolean falling = false;
	public boolean onground = false;
	private Velocity velocity = new Velocity(0,0);
	public boolean jumping = false;
	public boolean flying = false;
	private boolean climbing = false;
	private Polygon xbounds;
	private Tool tool;
	private int s = 1;
	private boolean utool = false;
	private int utoolt = 0;

	public Player(int x, int y) {
		super(x, y);
		initPlayer();
		// TODO Auto-generated constructor stub
	}
	
	private void initPlayer() {
		loadImage(ExternalFile.loadTexture("entity/player/player.png"));
		setImageDimensions(27+s, 30+s);
		xbounds = new Polygon(new int[]{(int) (bounds.getBounds().getX()-1),(int) ((int) bounds.getBounds().getX()+(bounds.getBounds().getWidth()+2)),(int) ((int) bounds.getBounds().getX()+(bounds.getBounds().getWidth()+2)),(int) (bounds.getBounds().getX()-1)}, new int[]{(int) (bounds.getBounds().getY()-1),(int) (bounds.getBounds().getY()-1),(int) ((bounds.getBounds().getY()-1)+bounds.getBounds().getHeight()+2),(int) ((int) ((bounds.getBounds().getY()-1))+bounds.getBounds().getHeight()+2)}, 4);
	}
	
	public void setVelocity(Velocity v){
		velocity = v;
	}
	
	public void setVelocity(double x, double y){
		velocity = new Velocity(x,y);
	}
	
	public void setVelocity(double x, String y){
		velocity = new Velocity(x,velocity.y);
	}
	
	public void setVelocity(String x, double y){
		velocity = new Velocity(velocity.x,y);
	}

	@Override
	public void move() {
//		if(falling) 
//			dy=2;
		if(y+height+29 >= 540 &! jumping){
			onground = true;
			y=540-height-29;
		
		} else {
			onground = false;
		}
		
		for(Sprite s : Main.getScreen().objects){
			if(!(s instanceof Collidable)) continue;
			if(!bounds.intersects(s.getPolygon().getBounds())) continue;
			y = s.getY()-getHeight();
			onground = true;
			
		}
		
		
//		velocity.x = velocity.x*0.2;
		if(!flying)velocity.y = velocity.y+0.2;
		else {
			velocity.y = velocity.y*0.2;
//			velocity.x = velocity.x*0.02;
		}
		
		
		if(velocity.y < 0) jumping = false;
		if(onground){
			falling = false;
			setVelocity("", 0);
		}
		dy = velocity.y;
		dx = velocity.x;
		
		y = (int) (y+dy);
		x = (int) (x+dx);
		
		dx = 0;
		dy=0;
		
	}
	
	@Override
	public void draw(Graphics g){
		if(direction == Direction.RIGHT){
			g.drawImage(getImage(), x, y, width, height, null);
			if(utool){
				utoolt=utoolt-1;
				if(utoolt == 0) utool = false;
				if(utoolt>=90){
					g.drawImage(ExternalFile.loadTexture("swipe.gif"), x+30+tool.width, y, 7*2, 15*2, null);
					g.drawImage(tool.getImage(), x+20, y, tool.getWidth(), tool.getHeight(), null);
				}
				
			}
//			if(tool != null) g.drawImage(Images.rotate(tool.getImage(), 0.0), x+20, y, tool.getWidth(), tool.getHeight(), null);
		} else {
			g.drawImage(getImage(), x + width, y,-(width), height, null);
			if(utool){
				utoolt=utoolt-1;
				if(utoolt == 0) utool = false;
				if(utoolt>=90){
					g.drawImage(ExternalFile.loadTexture("swipe.gif"), x+(7*2)-30, y, -(7*2), 15*2, null);
					g.drawImage(tool.getImage(), x+tool.getWidth()-20, y, - tool.getWidth(), tool.getHeight(), null);
				}
				
				
//				g.drawImage(ExternalFile.loadTexture("swipe.gif"), x+30+tool.width, y, 7*2 * - tool.width, 15*2, null);
			}
//			if(tool != null) g.drawImage(Images.rotate(tool.getImage(), 0.0), x+tool.getWidth()-20, y, - tool.getWidth(), tool.getHeight(), null);
		}
	}
	
	void useTool(){
		utool = true;
		utoolt = 100;
		if(direction == Direction.LEFT){
			tool.use(x,y,new Velocity(-8,0));
		}
		else tool.use(x,y,new Velocity(8,0));
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_W){
			if(flying || climbing) setVelocity("", -5);
		}
		
		if(key == KeyEvent.VK_S){
			if(flying || climbing) setVelocity("", 5);
		}
		
		if(key == KeyEvent.VK_D){
			direction = Direction.RIGHT;
			setVelocity(3, "");
		}
		if(key == KeyEvent.VK_A){
			direction = Direction.LEFT;
			setVelocity(-3, "");
		}
		if(key == KeyEvent.VK_SHIFT){
			if(tool != null && !utool){
				useTool();
			}
		}
		
		if(key == KeyEvent.VK_UP){
			s = s+1;
			setImageDimensions(27+s, 30+s);
			
		}
		if(key == KeyEvent.VK_DOWN){
			s = s-1;
			setImageDimensions(27+s, 30+s);
		}
		
		if(key == KeyEvent.VK_SPACE && onground){
			jumping = true;
			onground = false;
			setVelocity("",-5-(s/10));
		}
		
		if(key == KeyEvent.VK_F){
			if(flying) flying = false;
			else flying = true;
		}
		

		if(key == KeyEvent.VK_1){
			loadImage(ExternalFile.loadTexture("entity/player/player.png"));
			setImageDimensions(27+s, 30+s);
		}

		if(key == KeyEvent.VK_2){
			loadImage(ExternalFile.loadTexture("entity/knight/knight.png"));
			setImageDimensions(27+s, 30+s);
		}
	}

	

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_D){
			setVelocity(0, "");
		}
		if(key == KeyEvent.VK_A){
			setVelocity(0, "");
		}
	}
	
	public void setTool(Tool tool){
		this.tool = tool;
		
	}

	public Sprite getTool() {return tool;}

	public void attack() {
		
	}
	
	

	

}
