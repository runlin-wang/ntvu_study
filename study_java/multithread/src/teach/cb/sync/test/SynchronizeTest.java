package teach.cb.sync.test;

class Printer {
    void print(String msg) {
        System.out.print("[ " + msg);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" ]");
    }
}

class PrintThread extends Thread {
    private final Printer target;
    private final String msg;

    public PrintThread(Printer target, String msg) {
        this.target = target;
        this.msg  = msg;
    }

    @Override
    public void run() {
         synchronized (target) {
             target.print(msg);
         }
    }
}

public class SynchronizeTest {
    public static void main(String[] args) {
        Printer target = new Printer();

        PrintThread pt1 = new PrintThread(target, "hello");
        PrintThread pt2 = new PrintThread(target, "world");
        PrintThread pt3 = new PrintThread(target, "!");

        pt1.start();
        pt2.start();
        pt3.start();

        try {
            pt1.join();
            pt2.join();
            pt3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
