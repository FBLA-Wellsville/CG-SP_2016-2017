package io.github.trinnorica.utils;

public class Enchantment {
	
	
	EnchantmentEnum ench;
	int strength;
	
	public Enchantment(EnchantmentEnum ench, int strength){
		this.ench = ench;
		this.strength = strength;
	}
	
	public EnchantmentEnum getType(){
		return ench;
	}
	public int getStrength(){
		return strength;
	}

}
