package teach.cb.examABC;

import java.util.concurrent.Semaphore;

class Share {
    public static Semaphore semA = new Semaphore(1);
    public static Semaphore semB = new Semaphore(0);
    public static Semaphore semC = new Semaphore(0);
    public static int N = 5;
}

class ThreadA extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < Share.N; i++) {
            try {
                Share.semA.acquire();
                System.out.print("A ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Share.semB.release();
        }
    }
}
class ThreadB extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < Share.N; i++) {
            try {
                Share.semB.acquire();
                System.out.print("B ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Share.semC.release();
        }
    }
}
class ThreadC extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < Share.N; i++) {
            try {
                Share.semC.acquire();
                System.out.println("C");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Share.semA.release();
        }
    }
}

public class ExamABC {
    public static void main(String[] args) {
        ThreadA ta = new ThreadA();
        ThreadB tb = new ThreadB();
        ThreadC tc = new ThreadC();

        tc.start();
        ta.start();
        tb.start();
    }
}
