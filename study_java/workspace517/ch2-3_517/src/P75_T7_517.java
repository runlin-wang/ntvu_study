
public class P75_T7_517 {
	public static void main(String[] args) {
		double e = 0;
		double term = 1;
		int mu = 1;
		int i = 0;
		while (term - 1.0e-6 >= 0)
		{
			e += term;
			i++;
			mu *= i;
			term = 1 / (double)mu;
		}
		System.out.println("e = " + e);
	}
}
