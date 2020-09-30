package ch6_517;

import java.util.Scanner;

public class HW_String {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String str = input.nextLine();
		int i, j;
		char a, b;
		for (i = 0, j = str.length() - 1; i < str.length() && j > 0; i++, j--) {
			a = str.charAt(i);
			b = str.charAt(j);
			if (a != b) {
				System.out.println("No");
				break;
			}
			if (i == str.length() / 2)
				System.out.println("Yes");
		}
	}
}
