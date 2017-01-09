
package io.github.trinnorica.objects;

import io.github.trinnorica.Main;
import io.github.trinnorica.utils.Sound;
import io.github.trinnorica.utils.sprites.Sprite;
import io.github.trinnorica.utils.sprites.SpriteType;
import res.Audio;

public class TestingObject extends Sprite {

    public TestingObject(int x, int y) {
        super(x, y);
        init();
    }
    
    @Override
    public SpriteType getType(){
    	return SpriteType.GOLD;
    	
    }

    private void init() {
        loadImage("objects/img.png");
        getImageDimensions();
    }
    
    
}