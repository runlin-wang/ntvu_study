
public class P75_T9_517 {
	static final int N = 3;
	public static void main(String[] args) {
		int s, t, h;
		s = t = h = 0;
		for (int i = 100; i < 1000;i++) {
			s = i % 10;
			t = i / 10 % 10;
			h = i / 100;
			if (Math.pow(s, N) + Math.pow(t, N) + Math.pow(h, N) == i) {
				System.out.println(i);
			}
		}
	}
}
