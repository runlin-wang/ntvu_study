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



public class CallableTest {
    public static void main(String[] args) {
        Sum s = new Sum(100);
        int result = 0;
        try {
            result = s.call();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(result);
    }
}
