package teach.cb.semaphore;

import java.util.concurrent.Semaphore;

class Shared {
    public static int count = 0;
}

class IncreaseThread extends Thread {
    private final Semaphore incSem;
    private final Semaphore decSem;

    public IncreaseThread(Semaphore incSem, Semaphore decSem) {
        this.incSem = incSem;
        this.decSem = decSem;
    }

    @Override
    public void run() {
        try {
            incSem.acquire();
            for (int i = 0; i < 10; i++) {
                Shared.count++;
                System.out.println(Thread.currentThread().getName() + ": " + Shared.count);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        decSem.release();
    }
}

class DecreaseThread extends Thread {
    private final Semaphore decSem;

    public DecreaseThread(Semaphore decSem) {
        this.decSem = decSem;
    }

    @Override
    public void run() {
        try {
            decSem.acquire();
            for (int i = 0; i < 10; i++) {
                Shared.count--;
                System.out.println(Thread.currentThread().getName() + ": " + Shared.count);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore incSem = new Semaphore(1);
        Semaphore decSem = new Semaphore(0);

        new DecreaseThread(decSem).start();
        new IncreaseThread(incSem, decSem).start();
    }
}
