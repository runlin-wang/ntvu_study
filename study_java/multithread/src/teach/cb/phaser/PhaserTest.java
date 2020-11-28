package teach.cb.phaser;

import java.util.concurrent.Phaser;

class MyThread extends Thread {

    Phaser phaser;
    String name;

    public MyThread(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register();
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println(name + " starting phase " + (i+1));
            phaser.arriveAndAwaitAdvance();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " starting phase 3");
        phaser.arriveAndDeregister();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * @author Mr.lin
 * @version V1.0
 * @Package teach.cb.Phaser
 * @date 2020/11/28 19:34
 */
public class PhaserTest {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int curPhase;

        for (char ch = 'A'; ch < 'D'; ch++) {
            new MyThread(phaser, "Thread" + ch).start();
        }

        for (int i = 0; i < 3; i++) {
            curPhase = phaser.getPhase();
            phaser.arriveAndAwaitAdvance();
            System.out.println("Phaser" + (curPhase + 1) + "complete");
        }
        phaser.arriveAndDeregister();

        System.out.println(phaser.isTerminated());
        System.out.println(phaser.getRegisteredParties());
        System.out.println(phaser.getUnarrivedParties());
    }
}
