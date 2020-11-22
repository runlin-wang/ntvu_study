package teach.cb.Callable;

import java.util.concurrent.Callable;

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
        return Math.sqrt(side1 * side1 + side2 * side2);
    }
}

public class CallableTest {
    public static void main(String[] args) {
        Sum sum = new Sum(100);
        Factorial factorial = new Factorial(10);
        Hypotenuse hypotenuse = new Hypotenuse(3.0, 4.0);

        int s = 0;
        long f = 0;
        double h = 0;

        try {
            s = sum.call();
            f = factorial.call();
            h = hypotenuse.call();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("sum: " + s);
        System.out.println("factorial: " + f);
        System.out.println("hypotenuse: " + h);
    }
}
