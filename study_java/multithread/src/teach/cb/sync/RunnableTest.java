package teach.cb.sync;

class NewThread implements Runnable {

    private final String msg;
    private final Thread thread;

    public static NewThread createAndStart(String msg) {
        NewThread newThread = new NewThread(msg);
        newThread.getThread().start();
        return newThread;
    }

    private NewThread(String msg) {
        this.msg = msg;
        thread = new Thread(this);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + ": " + msg);
    }

    public Thread getThread() {
        return thread;
    }
}

public class RunnableTest {
    public static void main(String[] args) {
        NewThread thread1 = NewThread.createAndStart("hello");
        NewThread thread2 = NewThread.createAndStart("world");
    }
}
