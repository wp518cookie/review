package se.basis.concurrent.inaction.chap5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/1/12.
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 20; i++) {
            final int NO = i;
            Runnable run = () -> {
                try {
                    semaphore.acquire();
                    System.out.println("Accessing:" + NO);
                    TimeUnit.SECONDS.sleep(3);
                    semaphore.release();
                } catch (InterruptedException e) {

                }
            };
            exec.execute(run);
        }
        exec.shutdown();
    }
}
