package teach.cb.sync;

class Printer {
    void print(String msg) {
        synchronized (this) {
            System.out.print("[ " + msg);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" ]");
        }
    }
}

class PrintThread implements Runnable {
    private final Printer target;
    private final String msg;
    private final Thread thread;

    public static PrintThread createAndStart(Printer target, String msg) {
        PrintThread printThread = new PrintThread(target, msg);
        printThread.getThread().start();
        return printThread;
    }

    private PrintThread(Printer target, String msg) {
        this.target = target;
        this.msg  = msg;
        thread = new Thread(this);
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        target.print(msg);
    }
}

public class SynchronizeRunnable {
    public static void main(String[] args) {
        Printer target = new Printer();

        PrintThread pt1 = PrintThread.createAndStart(target, "hello");
        PrintThread pt2 = PrintThread.createAndStart(target, "world");
        PrintThread pt3 = PrintThread.createAndStart(target, "!");

    }
}
