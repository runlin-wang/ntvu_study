package my.lanqiao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NewThread extends Thread {

    private char[] s;
    private int start;
    private int end;
    private long count;
    private boolean status;

    public NewThread(char[] s, int start, int end) {
        this.s = s;
        this.start = start;
        this.end = end;
        this.count = 0;
        this.status = false;
    }

    @Override
    public void run() {
        int[] set = new int[123];
        int curCount;
        for (int i = start; i < end; i++) {
            for (int j = 97; j <= 122; j++)
                set[j] = 0;
            curCount = 0;
            for (int j = i; j < s.length; j++) {
                if (set[s[j]] == 0) {
                    set[s[j]] = 1;
                    curCount++;
                }
                count += curCount;
            }
        }
        this.status = true;
        System.out.println(this.getName() + ": " + count);
//        System.out.println();
    }

    public long getCount() {
        return count;
    }

    public boolean isStatus() {
        return status;
    }

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
//        Scanner in = new Scanner(new File("data_20_0000.txt"));
        Scanner in = new Scanner(new File("data/data_20_0000.txt"));
        char[] s = in.next().toCharArray();
//        System.out.println(s);
        int n = s.length;
        NewThread thread = new NewThread(s, 0, n / 6);
        NewThread thread2 = new NewThread(s, n / 6, 3 * n / 6);
        NewThread thread3 = new NewThread(s, 3 * n / 6, n);

        long start, end;
        start = System.currentTimeMillis();
        thread.start();
        thread2.start();
        thread3.start();

//        while (!thread.getStatus() && !thread2.getStatus() && !thread3.getStatus());
//        while (!(thread.isStatus() && thread2.isStatus() && thread3.isStatus())) {
//            continue;
//        }

        thread.join();
        thread2.join();
        thread3.join();

        end = System.currentTimeMillis();

        System.out.println(end - start);
//        System.out.println(thread.getCount());

//        System.out.println(thread.getCount());
        System.out.println(thread2.getCount() + thread.getCount() + thread3.getCount());
    }

}
