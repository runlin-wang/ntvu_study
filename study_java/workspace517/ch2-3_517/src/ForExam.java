
public class ForExam {
	public static void main(String[] args) {
		long factorial;
		for (int n = 5; n <= 10; n++) {
			factorial = 1;
			for (int j = 2; j <= n; j++) {
				factorial *= j;
			}
			System.out.println(n+ "! = " +factorial);
		}
	}
}
