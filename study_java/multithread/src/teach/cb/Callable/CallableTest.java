package teach.cb.Callable;

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

public class CallableTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);

        Future<Integer> sumFuture = es.submit(new Sum(100));
        Future<Long> facFuture = es.submit(new Factorial(10));
        Future<Double> hypFuture = es.submit(new Hypotenuse(3.0, 4.0));

        try {
            System.out.println("sum: " + sumFuture.get());
            System.out.println("fac: " + facFuture.get());
            System.out.println("hyp: " + hypFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        es.shutdown();
    }
}
