/*
*有30个人，其中有男人、女人和小孩，在一家饭馆吃饭花了50先令，
*每个男人花3先令，每个女人花2先令，每个小孩花1先令，
*问男人、女人和小孩各有几人？
*请编写程序输出所有的可能性并考虑算法的优化。
*/
public class Man_Woman_Child_517 {
	static final int N = 50;
	static final int P = 30;

	public static void main(String[] args) {
		int m, w, c;
		for (m = 0; m <= 10; m++) {
			for (w = 0; w <= 20; w++) {
				c = P - m - w;
				if (3 * m + 2 * w + c == N)
					System.out.printf("Man = %2d  Woman = %2d  Child = %2d\n", m, w, c);
			}
		}
	}
}
