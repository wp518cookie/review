package basis.concurrent.inaction.chap5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/1/12.
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("before barrier");
            } catch (InterruptedException e) {

            }
        });
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    System.out.println("waiting for barrier" + Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(2);
                    barrier.await();
                    System.out.println("start running" + Thread.currentThread().getName());
                } catch (Exception e) {

                }
            }).start();
        }
    }
}
