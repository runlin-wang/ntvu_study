package teach.cb.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

class MyThread extends Thread {

    private final CountDownLatch cdl;
    private final String name;

    public MyThread(CountDownLatch cdl, String name) {
        this.cdl = cdl;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " : started");
        cdl.countDown();
    }
}

class Monitor extends Thread {

    private final CountDownLatch cdl;
    private final Semaphore sem;

    public Monitor(CountDownLatch cdl, Semaphore sem) {
        this.cdl = cdl;
        this.sem = sem;
    }

    @Override
    public void run() {
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sem.release();
    }
}

class CallbackThread extends Thread {

    Semaphore sem;

    public CallbackThread(Semaphore sem) {
        this.sem = sem;
    }

    @Override
    public void run() {
        try {
            System.out.println("wait for pass....");
            sem.acquire();
            System.out.println("get pass!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sub threads all done!");
    }
}

public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(3);
        Semaphore sem = new Semaphore(0);

        new CallbackThread(sem).start();

        for (char ch = 'A'; ch < 'D'; ch++) {
            new MyThread(cdl, "Thread" + ch).start();
        }

        new Monitor(cdl, sem).start();

        System.out.println("main done!");
    }
}