package teach.cb.fixed;

class Q {

    private int n;
    private boolean flag;

    public synchronized void put(int n) {
        while (flag) {
            try {
                wait();
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Put: " + n);
        this.n = n;
        flag = true;
        notify();
    }

    public synchronized int get() {
        while (!flag) {
            try {
                wait();
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Get: " + n);
        flag = false;
        notify();
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
