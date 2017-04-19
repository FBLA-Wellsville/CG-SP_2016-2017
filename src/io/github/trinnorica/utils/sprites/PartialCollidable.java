package io.github.trinnorica.utils.sprites;

import java.util.ArrayList;
import java.util.List;

import io.github.trinnorica.utils.Direction;

public class PartialCollidable extends Sprite {
	
	private List<Direction> directions = new ArrayList<>();

	public PartialCollidable(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void addCollidableDirection(Direction direction){
		directions.add(direction);
	}
	
	public void removeCollidableDirection(Direction direction){
		directions.remove(direction);
	}
	
	public List<Direction> getCollidableDirections(){
		return directions;
	}

}
