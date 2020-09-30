package mooc;

public class CubicAnd {

	/**
	 * 判断是否有一些连续正整数等于 n
	 * 返回一个布尔值
	 * @param n
	 */
	public static boolean cubicAnd(int n) {
		int i, j, sum;
		for (i = 1; i < n; i++) {
			sum = 0;
			for (j = i; j < n; j++) {
				sum += Math.pow(j, 3);
				if (sum == Math.pow(n, 3)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		for (int i = 1; i < 1000; i++) {
			if (cubicAnd(i))
				System.out.println(i);
		}
		/**
		 * 求 1 到 1000 之内的 一些连续正整数的立方和 是否 等于 i 的立方
		 * 如果等于 则打印出这个数
		 */
	}
}
