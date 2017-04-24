package io.github.trinnorica.utils.sprites;

public enum EntityType {
	
	KNIGHT,
	DARK_KNIGHT,
	OGRE,
	SKELETON, WIZARD, MEGA_OGRE;

	public SpriteType getSpriteType() {
		
		return SpriteType.valueOf(this.toString());
	}

}
