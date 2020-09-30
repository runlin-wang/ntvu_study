
public class P75_T7_517 {
	public static void main(String[] args) {
		double a = 0, term = 1;
		int m = 1, i = 1;
		while (term - 1.0e-6 >= 0) {
			a += term;
			m *= i;
			i++;
			term = 1.0 / m;
		}
		System.out.println("e = " + a);
	}
}
