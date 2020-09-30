package part_6;

public class RadomDemo2 {
	public static void main(String[] args) {
		int [] randoms = new int[10];
		
		for (int i = 0; i < randoms.length; i++) {
			randoms[i] = (int)(Math.random() * 11);
		}
		for (int rnd : randoms)
			System.out.printf(rnd + " ");
		System.out.println();
		System.out.println("==================");
		for (int i = randoms.length - 1; i > -1; i--)
			System.out.printf(randoms[i] + " ");
	}
}
