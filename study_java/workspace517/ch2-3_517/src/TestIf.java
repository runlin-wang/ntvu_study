
public class TestIf {
	public void test(int x) {
		switch (x) {
		case 1:
		case 2:
		case 3:
		default:
		case 4:
		}
	}

	public static void main(String[] args) {
		int x = 5, y = 10, r = 5;
		switch(x+y) {
		case 15: r += x;
		case 20: r -= y;
		case 25: r *= x / y;
		default: r += r;
		}
		System.out.println(r);
	}
}
