package ch6_517;

import java.util.Scanner;

public class HW_StringBuffer {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String str = input.nextLine();
		StringBuffer sb = new StringBuffer(str);
		String str1 = new String(sb.reverse());
		
		if (str.equals(str1)) {
			System.out.println("Yes");
		} else {
			System.out.println("NO");
		}
	}
}
