package se.basis.concurrent.inaction.chap5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/1/24.
 */
public class CatchDownLatchTest {
    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        new Thread(new Task(latch)).start();
        latch.await();
        System.out.println("done");
    }
    private static final class Task implements Runnable {
        private CountDownLatch latch;
        public Task(CountDownLatch latch) {
            this.latch = latch;
        }
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {

            }
            latch.countDown();
        }
    }
}
