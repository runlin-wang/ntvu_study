package teach.cb.cyclicbarrier;

import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class SyncThread extends Thread {

    private final CyclicBarrier cb;
    private final int[] data;
    private static int MIN = Integer.MAX_VALUE;

    public SyncThread(CyclicBarrier cb, int... data) {
        this.cb = cb;
        this.data = data;
        if (data.length < MIN) {
            MIN = data.length;
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < MIN; i++) {
            CBAction.lst.add(data[i]);
            try {
                cb.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}

class CBAction extends Thread {

    public static ArrayList<Integer> lst = new ArrayList<>();

    @Override
    public void run() {
        for (int n : lst) {
            System.out.print(n + " ");
        }
        System.out.println();
        lst.clear();
    }
}

public class StudyCyclicBarrier {
    public static void main(String[] args) {
        final int THREAD_COUNTS = 10;
        CyclicBarrier cb = new CyclicBarrier(THREAD_COUNTS, new CBAction());
//        new SyncThread(cb, new int[]{1, 2, 3, 8}).start();
//        new SyncThread(cb, 4, 5, 6).start();
//        new SyncThread(cb, 7, 8, 9).start();

        // 调用 THREAD_COUNTS 个线程，判断 CyclicBarrier.await() 方法是否会锁定资源
        for (int i = 0; i < THREAD_COUNTS; i++) {
            int[] data = new int[3];
            int base = 10 * (i + 1);
            for (int j = 0; j < data.length; j++) {
                data[j] = base + (j + 1);
            }

            new SyncThread(cb, data).start();
        }

    }
}
