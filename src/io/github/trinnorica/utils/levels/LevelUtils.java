package io.github.trinnorica.utils.levels;

public class LevelUtils {
	
	public static char[] getLevelBlueprint(int level) {
		switch (level) {
		case 1:
			return new char[] {
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'A', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 'A', 'A', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'X', 'X', 'X', 'X', 'X', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'☺', '○', '♦', 'X', '○', 'X', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'X', 'X', 'X', 'X', 'E', 'E', 'X', 'X', 'X', 'X', 'E', 'E', 'E', 'X', 'X', 'X', 'X', 'E', 'E', 'E', 
					'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'E', 'X', 'X', 'X', 'B', 'B', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 
					'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'E', 'X', 'X', 'B', 'B', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 
					'B', 'B', 'F', 'C', 'C', 'C', 'F', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'E', 'X', 'X', 'B', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 'X', 'X', 'X', 'X', 'B', 'B', 'X', 
					'B', 'B', 'F', 'X', 'X', 'X', 'F', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'E', 'X', 'X', '☻', 'X', 'X', '☻', 'B', 'B', 'B', 'X', 'X', 'X', 'X', 'B', 'B', 'X', 
					'B', 'B', 'F', 'X', 'X', 'X', 'F', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'E', 'X', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 'X', 'X', 'X', 'X', 'B', 'B', 'X', 
					'B', 'B', 'F', 'X', 'X', 'X', 'F', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 
					};
		case 2:
			return new char[] { 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 
					'X', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'A', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'X', 'X', 'A', 'A', 'A', 'A', 'X', '○', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '○', '○', 'X', 'X', 'X', '☻', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'M', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'M', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'M', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'☺', '♦', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'M', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'E', 'E', 'E', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'M', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'B', 'B', 'B', 'B', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'M', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'B', 'B', 'B', 'B', 'B', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'M', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'B', 'B', 'B', 'B', 'B', 'B', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'M', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'D', 'D', 'D', 'D', 'B', 'B', 'B', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '☻', 'X', 'X', '☻', 'X', 'X', 'M', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'D', 'D', 'D', 'D', 'D', 'B', 'B', 'B', 'E', 'X', 'X', 'X', '○', '○', '○', '○', '○', 'X', 'X', 'X', 'X', 'M', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'D', 'D', 'D', 'D', 'D', 'B', 'B', 'B', 'B', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'D', 'D', 'D', 'D', 'D', 'D', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					};
		case 3:

			return new char[] { 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'M', 
					'X', 'X', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 'X', 'X', 'X', 'M', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'E', 'E', 'E', 'M', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '○', 'X', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 'B', 'M', 
					'X', 'X', 'X', '○', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '○', 'X', 'B', 'B', 'B', 'B', 'M', 
					'X', 'X', 'X', '○', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '○', 'X', 'B', 'B', 'B', 'B', 'M', 
					'☺', 'X', 'X', 'A', 'A', 'X', 'X', 'X', 'X', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '○', 'X', 'B', 'B', 'B', 'B', 'M', 
					'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '○', 'X', 'B', 'B', 'B', 'B', 'M', 
					'B', '♦', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 'B', 'M', 
					'B', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 'B', 'M', 
					'B', 'B', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 'B', 'M', 
					'B', 'B', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '☻', 'X', '☻', 'X', 'X', '☻', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 'B', 'M', 
					'B', 'B', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '☻', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 'B', 'M', 
					'D', 'B', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'E', 'E', 'E', 'E', 'E', 'X', 'X', 'X', 'X', 'X', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 
					'D', 'D', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'B', 'B', 'B', 'B', 'B', 'B', 'X', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 
					'D', 'D', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'B', 'B', 'B', 'B', 'B', 'F', 'C', 'X', 'X', 'X', 'X', 'X', 'C', 'F', 'B', 'B', 'B', 'B', 'B', 'B', 
					'D', 'D', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'B', 'B', 'B', 'B', 'B', 'B', 'F', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'F', 'B', 'B', 'B', 'B', 'B', 'B', 
					'D', 'D', 'D', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'F', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'F', 'B', 'B', 'B', 'B', 'B', 'B', 
					};
		case 4:
			return new char[] { 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X',
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X',
					'☺', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '○', '○', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '○', '○', 'X', 'X', 'K',
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'X', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X',
					'X', 'X', 'X', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X',
					};
		case 5:
			return new char[] { 
					'X', 'X', '○', '○', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 
					'☺', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'X', 'X', 'X', '☻', '☻', 'X', 'X', 'X', 'X', 
					'E', '•', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '☻', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'D', 'E', 'E', 'X', 'X', 'X', 'X', 'X', 'X', '☻', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'E', 'E', 'E', 'X', 'X', 'X', 'X', 
					'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', '☻', 'X', 'E', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 'B', 'X', 'X', 'X', 'X', 
					'D', 'D', 'D', 'E', 'X', 'X', 'X', 'X', 'X', 'E', 'D', 'X', 'X', 'D', '○', '○', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'B', 'B', 'B', 'B', 'X', 'X', 'X', 'X', 
					'D', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'E', 'D', 'D', 'X', 'X', 'D', '○', '○', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 'B', 'B', 'X', 'X', 'X', 'X', 
					'D', 'D', 'D', 'D', 'X', 'X', 'X', 'E', 'D', 'D', 'D', 'X', 'X', 'D', '○', '○', '○', 'X', 'X', 'X', 'X', 'X', 'E', 'B', 'B', 'B', 'B', 'B', 'X', 'X', 'X', 'X', 
					'D', 'D', 'D', 'D', 'E', 'E', 'E', 'D', 'D', 'D', 'D', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 'B', 'B', 'B', '○', 'X', 'X', 'X', 
					'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'B', 'B', 'B', 'B', 'B', 'B', 'E', 'X', 'X', 'X', 
					'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'X', 'X', 'X', 
					'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'X', 'X', 'X', 
					'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', '○', 'X', 'K', 
					'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 'E', 'E', 'E', 'E', 'E', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'E', 'X', 'K', 
					'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'E', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'X', 'E', 
					'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'X', 'X', 
					};
		case 6:
			return new char[] { 
					'X', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '☻', 'X', 'X', 'X', 'X', 'X', 'X', '○', '○', 'X', 'X', '☻', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'K', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', 'X', '○', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'K', 'X', 'X', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'E', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'X', 'X', 'D', 'X', 'E', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'D', '○', 'X', 'D', 'X', 'X', 'X', 'X', 'D', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'D', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'D', '○', 'X', 'D', 'X', 'X', 'X', 'X', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'D', 'E', 'X', 'X', 'X', 
					'X', 'X', 'X', 'D', '○', 'D', 'D', 'X', 'X', 'X', 'X', 'D', 'D', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'D', 'D', 'X', 'X', 'X', 
					'X', 'X', 'X', 'D', '○', 'D', 'D', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'E', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'D', 'D', 'E', 'X', 'X', 
					'X', 'X', 'X', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 'X', 
					'X', 'X', 'X', 'D', 'D', 'D', 'D', 'D', 'X', 'X', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'E', 'X', 
					'X', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 'D', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 
					'X', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'X', '○', '○', '○', 'D', 'D', 'X', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'E', 
					'X', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'E', 'E', 'E', 'D', 'D', 'D', '☻', '☻', 'X', 'D', 'D', 'D', '☻', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'B', 
					'X', 'X', 'D', 'E', 'E', 'E', 'D', 'D', 'E', 'B', 'B', 'B', 'E', 'D', 'D', 'X', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'E', 'B', 
					'☺', '•', 'E', 'B', 'B', 'B', 'E', 'E', 'B', 'B', 'B', 'B', 'B', 'E', 'E', 'E', 'D', 'D', 'D', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'D', 'D', 'D', 'D', 'B', 'B', 
					'E', 'E', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'E', 'E', 'E', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'E', 'E', 'E', 'E', 'B', 'B', 
					'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 
					};
		case 7:
			return new char[] { 
					'X', 'X', '○', '○', '○', 'X', '☻', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'X', 'X', 'X', 'E', 
					'X', 'X', 'X', 'X', 'X', 'D', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'X', 'X', 'D', 'X', 'X', 'X', 'D', 
					'X', 'X', 'X', 'X', 'X', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'E', 'X', 'X', 'D', 'X', 'X', 'D', 'X', 'X', 'X', 'D', 
					'X', 'X', 'X', 'X', 'X', 'E', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'E', 'X', 'X', 'D', 'X', 'X', 'D', 'X', 'X', 'D', 'D', 'X', 'X', 'D', 
					'X', 'X', 'X', 'X', 'X', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'X', 'X', 'D', 'X', 'X', 'D', 'X', 'D', 'D', 'D', 'X', 'D', 'D', 
					'X', 'X', 'X', 'X', 'X', 'D', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'E', 'E', 'D', 'X', 'D', 'D', 'X', 'D', 'D', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 
					'X', 'X', 'X', 'X', 'X', 'D', 'D', 'X', 'X', 'X', '○', '○', '○', 'X', 'X', 'D', 'D', 'D', 'D', 'X', 'D', 'D', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 
					'X', 'X', 'X', 'X', 'X', 'E', 'D', 'D', 'X', '○', '○', '○', '○', '○', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 
					'X', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 
					'X', 'X', 'X', 'X', 'X', 'D', 'E', 'E', 'E', 'X', 'X', 'X', 'X', 'X', 'D', 'E', 'E', 'E', 'D', 'D', 'D', 'D', 'D', 'D', 'E', 'E', 'E', 'E', 'E', 'E', 'D', 'B', 
					'X', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'E', 'E', 'E', 'E', 'D', 'D', 'D', 'D', 'D', 'D', 'E', 'B', 
					'X', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'B', 'B', 
					'X', 'X', 'X', 'X', 'X', 'D', 'D', 'E', 'E', 'X', 'X', 'X', 'X', 'X', 'E', 'E', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'E', 'E', 'E', 'E', 'E', 'B', 'B', 
					'☺', '•', 'X', 'X', 'D', 'D', 'E', 'B', 'B', 'X', 'X', 'X', 'X', 'X', 'B', 'B', 'E', 'D', 'D', 'D', 'E', 'E', 'E', 'E', 'E', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 
					'E', 'E', 'E', 'E', 'E', 'E', 'B', 'B', 'B', 'X', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 'E', 'D', 'D', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 
					};

		case 8:
			return new char[] { 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'A', 'X', 
					'☺', 'X', 'E', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'X', 'X', 'X', 'X', 'X', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'E', 'X', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'D', 'X', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'D', 'X', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'D', 'X', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', '○', '○', '○', '○', 'X', 
					'D', 'X', 'D', 'D', 'A', 'A', 'X', 'X', 'X', 'X', 'D', 'E', 'X', 'X', 'X', 'X', 'D', 'D', 'X', 'D', 'X', 'X', 'X', 'D', 'X', 'X', 'X', '○', '○', '○', '○', 'X', 
					'D', 'X', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'X', 'X', 'X', 'X', 'D', 'D', 'X', 'D', 'X', 'X', 'X', 'D', 'X', 'X', 'X', '○', '○', '○', '○', 'X', 
					'D', 'X', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'X', 'X', 'D', 'D', 'D', 'X', 'D', 'D', 'X', 'D', 'D', 'X', 'X', 'X', '○', '○', '○', '○', 'X', 
					'D', 'X', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'X', 'X', 'D', 'D', 'D', 'X', 'D', 'D', 'X', 'D', 'D', 'X', 'X', 'X', '○', '○', '○', '○', 'X', 
					'D', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'X', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 'D', 'D', 'X', 'X', 'X', '○', '○', '○', '○', 'X', 
					'D', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'X', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 'D', 'D', 'X', 'X', 'X', '○', '○', '○', '○', 'X', 
					'D', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'X', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 'D', 'D', 'D', 'X', 'X', '○', '○', '○', '○', 'X', 
					'D', 'D', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'X', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 'D', 'D', 'D', 'X', 'X', '○', '○', '○', '○', 'X', 
					'D', 'D', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'K', 'X', 
					'D', 'D', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'K', 'X', 
					'D', 'D', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 
					};

		case 9:
			return new char[] { 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'X', 'X', 'X', 'X', 'X', '☻', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'X', 'X', 'X', 'E', 'E', 'X', 'X', '☻', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 
					'X', 'X', 'E', 'B', 'B', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '○', '○', '○', '○', '○', '☻', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'B', 
					'X', '♣', 'B', 'B', 'B', 'B', 'E', 'E', 'X', 'X', 'X', 'X', 'E', 'X', 'X', 'X', 'X', '○', '○', '○', '○', '○', 'X', 'X', 'X', 'X', 'E', 'E', 'E', 'E', 'X', 'B', 
					'X', 'E', 'B', 'B', 'B', 'B', 'B', 'B', 'X', 'X', 'X', 'X', 'B', 'X', 'X', 'X', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'X', 'X', 'X', 'B', 'B', 'B', 'B', 'X', 'B', 
					'☺', 'B', 'D', 'D', 'B', 'B', 'B', 'B', 'X', 'X', 'X', 'X', 'B', 'B', 'X', 'X', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'X', 'X', 'X', 'B', 'B', 'B', 'B', 'B', 'B', 
					'E', 'D', 'D', 'D', 'D', 'B', 'B', 'B', 'B', 'X', 'X', 'B', 'B', 'B', 'X', 'X', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'X', 'X', 'B', 'B', 'B', 'B', 'B', 'B', 'D', 
					'D', 'D', 'D', 'D', 'D', 'D', 'B', 'B', 'B', 'X', 'X', 'B', 'B', 'B', 'X', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'D', 'D', 
					};
		case 10:
			return new char[] { 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', '○', '○', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', '○', '○', '○', 'X', '☻', 'X', '☻', 'X', '☻', 'X', '☻', 'X', '☻', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', '○', '○', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '○', '○', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'X', 'X', 'X', 'X', '○', '○', '○', 'X', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', '○', '○', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'X', 'X', 'X', 'X', 'E', 'E', 'E', 'E', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'X', 'X', 'X', 'E', 
					'X', 'X', 'X', 'X', 'B', 'B', 'B', 'B', 'B', 'F', 'C', 'C', 'C', 'C', 'C', 'F', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'X', 'X', 'X', 'D', 
					'☺', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 'B', 'F', 'X', 'X', 'X', 'X', 'X', 'F', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'X', 'X', 'X', 'E', 'D', 
					'E', '♣', 'X', 'X', 'X', 'X', 'X', 'X', 'B', 'F', 'X', 'X', 'X', 'X', 'X', 'F', 'B', 'B', 'B', 'B', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 
					'D', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'B', 'F', 'X', 'X', 'X', 'X', '☻', 'F', 'B', 'X', 'B', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'D', 'D', 
					'D', 'D', 'X', 'X', 'X', 'X', 'X', '☻', 'B', 'F', 'X', 'X', 'X', 'X', 'X', 'F', 'B', 'X', 'B', '☻', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 
					'D', 'D', 'E', 'X', 'X', 'X', 'X', 'B', 'B', 'F', 'E', 'E', 'E', 'E', 'E', 'E', 'B', 'B', 'B', 'B', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'D', 'D', 'D', 
					'D', 'D', 'D', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'D', 'D', 'D', 'D', 'D', 'D', 'E', 'E', 'E', 'E', 'X', 'X', 'X', 'X', 'X', 'E', 'E', 'E', 'D', 'D', 'D', 'D', 
					'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 
					'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 
					'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 
					};
		case 11:
			return new char[] { 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'K', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'K', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '○', '○', '○', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'D', 'X', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '○', 'X', 'X', 'X', 'X', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', 'D', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'☺', 'X', 'X', 'X', 'D', 'D', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'X', 
					'E', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'X', '○', '○', '○', 'X', 'X', 'X', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'B', 'X', 
					'D', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'D', '○', '○', '○', 'X', 'X', 'X', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'E', 'B', 'X', 
					'D', 'X', 'X', '○', 'D', 'D', 'D', 'D', 'D', '○', '○', '○', 'X', 'X', 'X', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'X', 'X', 'X', 'X', 'X', 'B', 'B', 'X', 
					'D', '♣', 'X', 'X', 'D', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'X', 'X', 'X', 'E', 'B', 'B', 'B', 
					'D', 'E', 'X', 'X', 'D', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'X', 'X', 'X', 'B', 'B', 'B', 'B', 
					'D', 'D', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'X', '○', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'X', 'X', 'E', 'B', 'B', 'B', 'B', 
					'D', 'D', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'X', '○', 'D', 'D', 'X', 'X', 'B', 'B', 'B', 'B', 'B', 
					'D', 'D', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'X', 'E', 'B', 'B', 'B', 'B', 'B', 
					'D', 'D', 'E', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'X', 'B', 'B', 'B', 'B', 'B', 'B', 
					'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 'E', 'X', 'X', 'X', 'D', 'D', 'D', 'E', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'E', 'B', 'B', 'B', 'B', 'B', 'B', 
					};
		case 12:
			return new char[] { 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'X', 'X', 'X', 'X', 'X', '☻', '☻', '☻', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'☺', '♠', 'X', 'X', 'X', 'X', 'X', 'X', '☻', '☻', '☻', '☻', '☻', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'X', 'X', 'X', 'X', 'X', '☻', '☻', '☻', '☻', '☻', '☻', '☻', '☻', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'E', 'E', 'E', 'E', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', '☻', '☻', '☻', '☻', '☻', '☻', '☻', '☻', '☻', 'X', 'X', 
					'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 
					'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'X', 'X', 
					'B', 'B', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'X', 'X', 'D', 
					'B', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'B', 'B', 'B', 'B', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 
					'B', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'E', 'D', 'D', 
					'B', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 
					'B', 'X', 'X', 'X', 'X', '○', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'D', 'D', 'D', 'D', 
					'D', 'D', 'X', 'K', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'D', 
					'D', 'D', 'D', 'K', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'D', 'D', 'D', 'D', 'D', 
					'D', 'D', 'D', 'E', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'E', 'D', 'X', 'X', 'X', 'X', 'D', 'D', 'E', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 
					'D', 'D', 'D', 'D', 'D', 'D', 'D', 'E', 'D', 'D', 'D', 'E', 'E', 'E', 'E', 'D', 'D', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 
					'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'X', 'X', 'X', 'X', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 
					};
		case 13:
			return new char[] { 
					'X', 'X', 'X', 'X', 'X', '☻', '☻', '☻', 'X', 'X', 'X', '☻', '☻', '☻', 'X', 'X', 'X', 'X', 'X', '☻', '☻', '☻', '☻', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X',
					'X', 'X', 'X', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', '☻', '☻', 'A', 'A', 'A', 'A', 'X', '☻', '☻', 'X', 'X', '☻', '☻', 'X', 'X',
					'X', 'X', 'X', 'X', 'X', 'X', '☻', '☻', 'X', '☻', '☻', 'X', 'X', '☻', '☻', '☻', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'X', 'X', 'A', 'A', 'X', 'X', 
					'X', 'X', 'X', '☻', '☻', '☻', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'X', 'X', 'X', 'X', '☻', '☻', 'X', 'X', '☻', '☻', 'X', 'X', 'K', 
					'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'X', 'A', 'A', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', '☻', '☻', 'X', 'X', 'A', 'A', 'X', 'X', 'A', 'A', 'X', 'X', 'K',
					'X', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'X', 'X', 'X', '☻', '☻', '☻', 'X', 'X', 'X', 'X', 'K', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'A', 'A', 'A', 'X', 'X', 'X', 'X', 'K', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'X', '♠', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K',
					'X', 'X', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'X', 'X', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'X', 'X', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '☻', '☻', '☻', '☻', '☻', '☻', '♂', 'X', 'X', 'X', 'K', 
					'X', 'X', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', '○', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'K', 
					'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 
					'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B', 
					'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D', 'D',
					};

		default:
			return null;

		}
	}

	public static int getLevelWidth(int level) {
		switch (level) {
		case 1:
			return 32;
		case 2:
			return 32;
		case 3:
			return 32;
		default:
			return 32;
		}
	}

	public static int getLevelHeight(int level) {
		switch (level) {
		case 1:
			return 17;
		case 2:
			return 17;
		case 3:
			return 17;
		default:
			return 17;
		}
	}

}
