package io.github.trinnorica.utils.sprites;

public enum SpriteType {

	GRASS, STONE, FALLING_FLOOR, COMPETITOR, GATE, PLAYER, LADDER, WALL, GOLD, ARROW, BOW, NINJA_CLOAK, FALLING_WALL, SWITCH, TRIGGERED_SWITCH, KEY, DOOR, OPEN_DOOR, SPIKE, BOSS, BOOTS, BOX, CLOUD_BEGIN, CLOUD_MIDDLE, CLOUD_END, AIR, DIRT, FLOOR, CLOUD, DIRT_ARCH_DOWN, DYNAMIC_DIRT, TEST_ENTITY, OGRE, KNIGHT, DARK_KNIGHT, WIZARD, TOOL, STONE_SWORD, DARK_SWORD, STICK, SKELETON, ARMOUR, ICE_DAGGER, FIRE_DAGGER, CASTLE_BLOCK, EVIL_FLAG, CASTLE_BLOCK_VINES, CASTLE_BLOCK_BACKGROUND, CASTLE_BLOCK_FLOOR;

	SpriteType() {

	}

	public SpriteSubType getSubType() {
		if (this == GRASS)
			return SpriteSubType.PARTIAL_COLLIDEABLE;
		if (this == FALLING_FLOOR)
			return SpriteSubType.PARTIAL_COLLIDEABLE;
		if (this == TEST_ENTITY)
			return SpriteSubType.ENEMY;
		if (this == BOSS)
			return SpriteSubType.ENEMY;
		if (this == SPIKE)
			return SpriteSubType.BAD_THINGS;
		if (this == GATE)
			return SpriteSubType.NON_COLLIDEABLE;
		if (this == LADDER)
			return SpriteSubType.CLIMABLE;
		if (this == WALL)
			return SpriteSubType.COLLIDEABLE;
		if (this == GOLD)
			return SpriteSubType.MONEY;
		if (this == ARROW)
			return SpriteSubType.PROJECTILE;
		if (this == BOW)
			return SpriteSubType.WEAPON;
		if (this == NINJA_CLOAK)
			return SpriteSubType.TOOL;
		if (this == BOOTS)
			return SpriteSubType.TOOL;
		if (this == KEY)
			return SpriteSubType.TOOL;
		if (this == DOOR)
			return SpriteSubType.INTERACTABLE;
		if (this == OPEN_DOOR)
			return SpriteSubType.PARTIAL_COLLIDEABLE;
		if (this == SWITCH)
			return SpriteSubType.INTERACTABLE;
		if (this == TRIGGERED_SWITCH)
			return SpriteSubType.INTERACTABLE;
		if (this == FALLING_WALL)
			return SpriteSubType.COLLIDEABLE;
		if (this == BOX)
			return SpriteSubType.COLLIDEABLE;
		else
			return null;
	}
}