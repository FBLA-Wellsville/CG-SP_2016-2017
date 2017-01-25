package io.github.trinnorica.utils.sprites;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;

import io.github.trinnorica.utils.Direction;
import io.github.trinnorica.utils.Utils;
import res.ExternalFile;

public class Sprite {

    public int x;
    public int y;
    public int bw=0;
    public int bh=0;
    public int width;
    public int height;
    protected boolean vis;
    private Image image;
    public String imagePath = "";
    @SuppressWarnings("unused")
	private Sprite sprite;
    public Polygon bounds;
    protected boolean exists = false;
    protected Direction direction = Direction.RIGHT;

    public Sprite(int x, int y) {
    	this.sprite = this;
        this.x = x;
        this.y = y;
        vis = true;
        exists = true;
       
        
        
    }
    
    public Sprite(int x, int y, Image image, int width, int height) {
    	this.sprite = this;
        this.x = x;
        this.y = y;
        vis = true;
        exists = true;
        loadImage(image);
        setImageDimensions(width, height);
       
        
        
    }
    

    
    

	public SpriteType getType(){return null;}
    
    

    protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
        
        getPolygon();
    }
    
    protected void setImageDimensions(int width, int height, int bw, int bh) {

        this.width = width;
        this.height = height;
        this.bw = bw;
        this.bh = bh;
        
        getPolygon();
        
        
    }
    
    protected void setImageDimensions(int width, int height) {

        this.width = width;
        this.height = height;
        
        getPolygon();
        
        
    }

    protected void loadImage(String imageName) {
    	
    	imagePath = imageName;
    	
    	image = ExternalFile.loadTexture(imageName);
    	

    	
    }
    
    public Direction getIntercectingDirection(Rectangle r, Rectangle rr){
    	
    	
    	if (r.getBounds().getMaxY() - rr.getY() >= 0 && r.getBounds().getMaxY() - rr.getY() <= 10) {
    		return Direction.DOWN;
    	}
    	
    	if(r.getBounds().getMaxX() - rr.getX() >= 1.0 && r.getBounds().getMaxX() - rr.getX() <= 17.0){
    		return Direction.RIGHT;
    	}
    	if(r.getBounds().getX() - rr.getMaxX() <= -1.0 && bounds.getBounds().getX() - rr.getMaxX() >= -17.0){
    		return Direction.LEFT;
    	}
    	if(r.getBounds().getY() - rr.getMaxY() <= -1.0){
    		return Direction.UP;
    	}
    	return null;
    }
    
    public void loadImage(Image image){
    	this.image = image;
    }
    
    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return vis;
    }

    public void setVisible(Boolean visible) {
        vis = visible;
    }

    public Polygon getPolygon() {
    	bounds = new Polygon(new int[] {x,x+width,x+width,x}, new int[] {y+height,y+height,y,y}, 4);
    	return bounds;
    }
    
    public String getLocation(){
    	return x+":"+y;
    }

	public SpriteSubType getSubType() {
		return getType().getSubType();
	}


	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public boolean exists(){
		return exists;
	}


	public void draw(Graphics g) {
		if(direction == Direction.RIGHT){
			g.drawImage(getImage(), x, y, width, height, null);
		} else {
			g.drawImage(getImage(), x + width, y,-(width), height, null);
		}
	}

	

	

}