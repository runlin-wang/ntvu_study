import java.util.Scanner;

public class Rect1_517 {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.print("Please input length:");
		
		double length = input.nextDouble();
		
		System.out.print("Please input wide:");
		
		double wide = input.nextDouble();
		
		double girth = (length + wide) * 2;
		double area = length * wide;
		
		System.out.println("girth = " + girth + "\narea = " + area);

	}
}
