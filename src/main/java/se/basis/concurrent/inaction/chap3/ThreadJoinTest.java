package se.basis.concurrent.inaction.chap3;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/12/25.
 */
public class ThreadJoinTest {
    public static void main(String[] args) throws Exception {
        Thread a = new Thread(() -> {
            try {
                System.out.println("a is running");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("a is done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        a.start();
        System.out.println("main thread is running");
        a.join();
        System.out.println("main thread is done");
    }
}
