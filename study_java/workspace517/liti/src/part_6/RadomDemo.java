package part_6;

import java.util.Arrays;
import java.util.Random;

public class RadomDemo {
	public static void main(String[] args) {
		int[] randoms = new int[10];

		Random rnd = new Random(1);

		for (int i = 0; i < randoms.length; i++) {
			randoms[i] = rnd.nextInt(11);
			System.out.printf(randoms[i] + " ");
		}
		System.out.println();
		System.out.println("===================");

		System.out.println(Arrays.binarySearch(randoms, 6));
		Arrays.sort(randoms);
		System.out.println(Arrays.binarySearch(randoms, 6));

//		for (int i = randoms.length - 1; i > -1; i--)
//			System.out.printf(randoms[i] + " ");
//		
//		System.out.println();
//		System.out.println("====================");
//		
//		for (int r : randoms)
//			System.out.printf(r + " ");

	}
}
