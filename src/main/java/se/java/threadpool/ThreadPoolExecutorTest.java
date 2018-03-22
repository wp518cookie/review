package se.java.threadpool;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/1/19.
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws Exception {
        Thread a = new Thread(new Task());
        a.start();
        a.interrupt();
    }

    private static class Task implements Runnable {
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }
    }
}
