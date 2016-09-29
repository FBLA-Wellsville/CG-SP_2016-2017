
package io.github.trinnorica.objects;

import io.github.trinnorica.utils.sprites.Sprite;
import io.github.trinnorica.utils.sprites.SpriteType;

public class Ladder extends Sprite {

    public Ladder(int x, int y) {
        super(x, y);
        
        initLadder();
    }
    
    @Override
    public SpriteType getType(){
    	return SpriteType.LADDER;
    }

    private void initLadder() {
        
        loadImage("objects/ladder.png");
        getImageDimensions();
    }
}