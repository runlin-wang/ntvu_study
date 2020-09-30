package numGame;

import java.util.Random;

public class Test2 {
	public static void main(String[] args) {
		Random a = new Random();
		
		for (int j = 0; j < 10; j++) {
			int i = Math.abs(a.nextInt(100));
			System.out.println(i);
		}
	}
}
