package teach.cb.semaphore;

import java.util.concurrent.Semaphore;

class Shared {
    public static int count = 0;
}

class IncreaseThread extends Thread {
    private Semaphore sem;

    public IncreaseThread(Semaphore sem) {
        this.sem = sem;
    }

    @Override
    public void run() {
        try {
            sem.acquire();
            for (int i = 0; i < 10; i++) {
                Shared.count++;
                System.out.println(Thread.currentThread().getName() + ": " + Shared.count);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sem.release();
    }
}

class DecreaseThread extends Thread {
    private Semaphore sem;

    public DecreaseThread(Semaphore sem) {
        this.sem = sem;
    }

    @Override
    public void run() {
        try {
            sem.acquire();
            for (int i = 0; i < 10; i++) {
                Shared.count--;
                System.out.println(Thread.currentThread().getName() + ": " + Shared.count);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sem.release();
    }
}

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        new IncreaseThread(sem).start();
        new DecreaseThread(sem).start();
    }
}
