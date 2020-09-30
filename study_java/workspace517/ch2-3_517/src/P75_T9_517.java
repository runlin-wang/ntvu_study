
public class P75_T9_517 {
	public static void main(String[] args) {
		int singles, ten, hundred;
		singles = ten = hundred = 0;
		for (int i = 100; i < 1000;i++) {
			singles = i % 10;
			ten = i / 10 % 10;
			hundred = i / 100;
			if (((singles * singles * singles) + (ten * ten * ten) + (hundred * hundred *hundred)) == i) {
				System.out.println(i + " 是一个水仙花数");
			}
		}
	}
}
