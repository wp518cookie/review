package jvm.gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/3/21.
 */
public class WeakReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue<String> queue = new ReferenceQueue();
        WeakReference<String> weakReference = new WeakReference(new String("test"), queue);

        Thread a = new Thread(()->{
            try {
                WeakReference<String> k;
                while ((k = (WeakReference<String>) queue.remove()) != null) {
                    System.out.println("回收了" + k.get());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        a.setDaemon(true);
        a.start();
        System.gc();
        TimeUnit.SECONDS.sleep(2);
    }
}
