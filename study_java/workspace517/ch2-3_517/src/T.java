import java.util.Scanner;

public class T {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("请输入一个整数，输入Q结束");
		
		while (true) {
			String line = sc.nextLine();
			if(line.equals("Q")) break;
			
			int score = Integer.parseInt(line);
			score /= 10;
			switch (score) {
				case 10:
				case 9:
					System.out.println("A");
					break;
				case 8:
					System.out.println("B");
					break;
				case 7:
					System.out.println("C");
					break;
				case 6:
					System.out.println("D");
					break;
				default:
					System.out.println("E");
			}
		}
	}
}
