package numGame;

import java.util.Scanner;

public class Test {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		A a = new A();
		int v, i = 0;
		do {
			i++;
			v = input.nextInt();
			if (v == a.getV()) {
				System.out.println("答对了 你用了" + i + "次就猜对了");
			}
			if (v > a.getV()) {
				System.out.println("大了");
			}
			if (v < a.getV()) {
				System.out.println("小了");
			}
		} while(v != a.getV());
	}
}
