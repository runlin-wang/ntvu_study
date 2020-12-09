package my.lanqiao.guosai;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mr.lin
 * @version V1.0
 * @Package my.lanqiao.guosai
 * @date 2020/12/6 19:10
 */
public class Main {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new File("data.txt"));
        int sum = 0;                            // 总和
        int n = in.nextInt();                   // 数组 f 下标
        int[] f = new int[n];                   // 数组
        int a_b, cost = 0;                  // a_b 进来和讲解的时间总和
        for (int i = 0; i < n; i++) {
            a_b = in.nextInt() + in.nextInt();
            sum += a_b;
            f[i] = a_b + in.nextInt();
        }

        Arrays.sort(f);

        for (int i = 0; i < n; i++) {
            sum += (n - i - 1) * f[i];
        }

        System.out.println(sum);

    }
}