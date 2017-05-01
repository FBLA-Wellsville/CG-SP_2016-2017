
package io.github.trinnorica.objects;

import io.github.trinnorica.utils.sprites.Climbable;
import io.github.trinnorica.utils.sprites.Sprite;
import io.github.trinnorica.utils.sprites.SpriteType;

public class Ladder extends Climbable {
	
	public static final int LADDER = 0;
	public static final int VINE = 1;
	
	private int type;

    public Ladder(int x, int y, int type) {
        super(x, y);
        this.type = type;
        initLadder();
    }
    
    @Override
    public SpriteType getType(){
    	return SpriteType.LADDER;
    }

    private void initLadder() {
        switch(type){
        case LADDER:
        	loadImage("objects/ladder.png");
        	break;
        case VINE:
        	loadImage("objects/castle_block_vine.png");
        	break;
        }
        
        getImageDimensions();
    }
}