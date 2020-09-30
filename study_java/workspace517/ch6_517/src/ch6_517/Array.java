package ch6_517;

public class Array {
	public static void main(String[] args) {
		int i, j;
		int[] sum1, sum2;
		sum1 = new int[5];
		sum2 = new int[5];
		int[][] rand = new int[sum1.length][sum1.length];

		for (i = 0; i < rand.length; i++) {
			for (j = 0; j < rand[0].length; j++) {
				rand[i][j] = (int) (Math.random() * 10);
				System.out.print(rand[i][j] + "  ");
				sum1[i] += rand[i][j];
				sum2[j] += rand[i][j];
			}
			System.out.println();
		} // 创建一个矩阵并输出
		
		System.out.println("=============");
		for (i = 0; i < rand.length; i++) {
			for (j = 0; j < rand[0].length; j++)
				System.out.print(rand[j][i] + "  ");
			System.out.println();
		} // 
		
		System.out.println("=============");
		for (i = 0, j = 0; i < rand.length && j < rand[0].length; i++,j++) {
			System.out.print(rand[i][j] + "  ");
		}
		
		System.out.println();
		System.out.println("=============");
		for (i = 0, j = rand[0].length - 1; i < rand.length && j > -1; i++, j--) {
			System.out.print(rand[i][j] + "  ");
		}
		
		System.out.println();
		System.out.println("=============");
		for (int s : sum1)
			System.out.println(s);
		
		System.out.println("==============");
		for (int s : sum2)
			System.out.print(s + " ");
	}
}
