package io.github.trinnorica.objects.tools;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import io.github.trinnorica.Main;
import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.utils.Enchantment;
import io.github.trinnorica.utils.EnchantmentEnum;
import io.github.trinnorica.utils.Velocity;
import io.github.trinnorica.utils.particles.Particle;
import io.github.trinnorica.utils.particles.ParticleType;
import io.github.trinnorica.utils.sprites.Tool;
import io.github.trinnorica.utils.sprites.ToolType;
import res.ExternalFile;

public class Armour extends Tool {
	
	public static final int IRON = 0;
	public static final int GOLD = 1;
	public static final int DARK = 2;
	public static final int FIRE = 3;
	
	private int id;
	private int protection;

	public Armour(int x, int y, ToolType type, int id) {
		super(x, y, type);
		this.id = id;
		init();
	}
	
	private void init(){
		switch(id){
		case IRON:
			loadImage(ExternalFile.loadTexture("objects/tools/armour/iron-armour.png"));
			protection = 2;
			break;
		case GOLD:
			loadImage(ExternalFile.loadTexture("objects/tools/armour/gold-armour.png"));
			protection = 5;
			break;
		case DARK:
			loadImage(ExternalFile.loadTexture("objects/tools/armour/dark-armour.png"));
			protection = 10;
			break;
		case FIRE:
			loadImage(ExternalFile.loadTexture("objects/tools/armour/fire-armour.png"));
			addEnchantment(EnchantmentEnum.FLAME, 1);
			protection = 5;
			break;
		}
		
		
		setImageDimensions(30, 30);
	}
	
	public int getWidth(){
		return 27;
	}
	public int getHeight(){
		return 27;
		
	}
	
	@Override
	public void draw(Graphics g){
		super.draw(g);
		
		for(Enchantment ench : getEnchantments()){
			if(ench.getType().equals(EnchantmentEnum.FLAME)){
				if(new Random().nextInt(100) < 5){
					Main.addSprite(new Particle(new Point((((int)x) + new Random().nextInt(width)), ((int)y)+new Random().nextInt(height)), ParticleType.FIRE, new Velocity(0, -1), false));
				}
			}
		}
		
	}
	
	public int getProtection(){
		return protection;
	}
	
	public int protect(int damage, Entity damager){
		damage = damage/protection;
		for(Enchantment ench : getEnchantments()){
			if(ench.getType().equals(EnchantmentEnum.FLAME)){
				if(damager!=null)damager.fireTicks = ench.getStrength()*2;
			}
		}
		return damage;
	}
	
	

	public int getID() {
		return id;
	}

}
