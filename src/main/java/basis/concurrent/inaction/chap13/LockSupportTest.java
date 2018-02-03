package basis.concurrent.inaction.chap13;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by Administrator on 2018/1/24.
 */
public class LockSupportTest {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Task());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("main thread done!");
        System.out.println("LockSupport blocker:" + LockSupport.getBlocker(t));
        LockSupport.unpark(t);
    }

    private static class Task implements Runnable {
        String hello = new String("hello world");
        public void run() {
            System.out.println("task start running");
            LockSupport.park(hello);
            System.out.println("awake");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                System.out.println("task interrupted");
            }
            System.out.println("task finish");
        }
    }
}
