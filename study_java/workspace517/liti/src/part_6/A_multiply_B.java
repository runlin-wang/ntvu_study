package part_6;

public class A_multiply_B {
	public static void main(String[] args) {
		float[][] B = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; // 声明定义初始化二维数组B
		float[][] A = { { 1, 2, 3 }, { 4, 5, 6 } }; // 声明定义初始化二维数组A
		float[][] C = new float[2][3]; // 声明定义初始化二维数组C
		int i, j, k;
		for (i = 0; i < 2; i++) {
			for (j = 0; j < 3; j++) {
				for (k = 0; k < 3; k++) {
					C[i][j] += A[i][k] * B[k][j];

				}
				System.out.printf(C[i][j] + " ");
			}
			System.out.println("\n");
		}
	}
}
