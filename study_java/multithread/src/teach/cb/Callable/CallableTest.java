package teach.cb.Callable;

import java.nio.charset.Charset;
import java.util.concurrent.*;

class Sum implements Callable<Integer> {

    private final int stop;

    public Sum(int stop) {
        this.stop = stop;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;

        for (int i = 1; i <= stop; i++) {
            sum += i;
        }

        Thread.sleep(2000);
        return sum;
    }
}

class Factorial implements Callable<Long> {

    private int stop;

    public Factorial(int stop) {
        this.stop = stop;
    }

    @Override
    public Long call() throws Exception {
        long result = 1;

        while (stop > 0)
            result *= stop--;

        Thread.sleep(2000);
        return result;
    }
}

class Hypotenuse implements Callable<Double> {
    private final double side1;
    private final double side2;

    public Hypotenuse(double side1, double side2) {
        this.side1=side1;
        this.side2=side2;
    }

    @Override
    public Double call() throws Exception {
        Thread.sleep(3000);
        return Math.sqrt(side1 * side1 + side2 * side2);
    }
}

class Monitor extends Thread {

    private final CyclicBarrier cBar;
    private final Future<Integer> sumFuture;
    private final Future<Long> facFuture;
    private final Future<Double> hypFuture;

    public Monitor(CyclicBarrier cBar, Future<Integer> sumFuture, Future<Long> facFuture, Future<Double> hypFuture) {
        this.cBar = cBar;
        this.sumFuture = sumFuture;
        this.facFuture = facFuture;
        this.hypFuture = hypFuture;
    }

    @Override
    public void run() {
        while (true) {
            if (sumFuture.isDone() && facFuture.isDone() && hypFuture.isDone()) break;
        }

        try {
            cBar.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class CallbackThread extends Thread {

    private final Future<Integer> sumFuture;
    private final Future<Long> facFuture;
    private final Future<Double> hypFuture;

    public CallbackThread(Future<Integer> sumFuture, Future<Long> facFuture, Future<Double> hypFuture) {
        this.sumFuture = sumFuture;
        this.facFuture = facFuture;
        this.hypFuture = hypFuture;
    }

    @Override
    public void run() {
        try {
            System.out.println("sum: " + sumFuture.get());
            System.out.println("fac: " + facFuture.get());
            System.out.println("hyp: " + hypFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("run time：" + (System.currentTimeMillis() - CallableTest.start) + "ms");
    }
}

public class CallableTest {

    public static long start;

    public static void main(String[] args) {
//        ExecutorService es = Executors.newFixedThreadPool(3);
        ExecutorService es = Executors.newCachedThreadPool();

        Future<Integer> sumFuture = es.submit(new Sum(100));
        Future<Long> facFuture = es.submit(new Factorial(10));
        Future<Double> hypFuture = es.submit(new Hypotenuse(3.0, 4.0));

        CyclicBarrier cBar = new CyclicBarrier(1, new CallbackThread(sumFuture, facFuture, hypFuture));

        start = System.currentTimeMillis();

        new Monitor(cBar, sumFuture, facFuture, hypFuture).start();
        es.shutdown();

        System.out.println("main done.");

        // 打印 CPU 核心数量
//        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
