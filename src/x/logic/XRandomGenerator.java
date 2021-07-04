package x.logic;

import java.util.Random;

import x.logic.XMath;

public class XRandomGenerator {
	private static Random random = new Random();
		
	public static boolean generateBoolean() {
		return random.nextBoolean();
	}
	
	public static boolean generateBoolean(int probability) {
		probability = XMath.getValueInRange(probability, 0, 100);
		return (random.nextInt(100) < probability);
	}
	
	public static int generateInteger(int min, int max) {
		if (min > max) {
			throw new RuntimeException(String.format("[RG] Wrong parameters [min] = [%s] and [max] = [%s]. Parameter [max] must be >= [min].", min, max));
		}
		return min + random.nextInt(max - min + 1);
	}
}
