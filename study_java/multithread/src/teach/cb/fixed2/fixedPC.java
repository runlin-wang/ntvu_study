package teach.cb.fixed2;

import java.util.concurrent.Semaphore;

class Q {

    private int n;
    public static Semaphore semPut = new Semaphore(1);
    public static Semaphore semGet = new Semaphore(0);

    public void put(int n) {
        try {
            semPut.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Put: " + n);
        this.n = n;
        semGet.release();
    }

    public int get() {
        try {
            semGet.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Get: " + n);
        semPut.release();
        return n;
    }
}

class Producer extends Thread {

    private Q q;

    public Producer(Q q) {
        this.q = q;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            q.put(i);

        }
    }
}

class Consumer extends Thread {

    private Q q;

    public Consumer(Q q) {
        this.q = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            q.get();
        }
    }
}

public class fixedPC {
    public static void main(String[] args) {
        Q q = new Q();
        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);

        consumer.start();
        producer.start();
    }
}
