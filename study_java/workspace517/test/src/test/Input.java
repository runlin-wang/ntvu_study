package test;

import java.util.Scanner;

class Input {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("请输入一个数");
		int a = scanner.nextInt();
		System.out.printf("%d 的平凡和是 %d", a, a * a * a);
	}
}
