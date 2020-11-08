package my.lanqiao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("data/data_1_0000.txt"));
        char[] s = in.next().toCharArray();
//        System.out.println(s);
        int n = s.length;
        long count = 0, curCount;
        int[] set = new int[123];

        long start, end;
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            for (int j = 97; j < 122; j++)
                set[j] = 0;
            curCount = 0;
            for (int j = i; j < n; j++) {
                if (set[s[j]] == 0) {
                    set[s[j]] = 1;
                    curCount++;
                }
                count += curCount;
            }
        }

        System.out.println(count);

        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
