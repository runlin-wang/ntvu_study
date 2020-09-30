import java.util.Scanner;
public class P46_T10_517 {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int n = input.nextInt();
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
