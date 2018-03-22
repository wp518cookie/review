package se.basis.sourcecode.concurrent.collection;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/1/10.
 */
public class SynchronousQueueTest {
    public static void main(String[] args) throws Exception {
        SynchronousQueue queue = new SynchronousQueue();
        new Consumer(queue).start();
        TimeUnit.SECONDS.sleep(3);
        new Producer(queue).start();
    }

    static class Producer extends Thread {
        private SynchronousQueue<Integer> queue;

        public Producer(SynchronousQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            int product = new Random().nextInt(1000);
            System.out.println("produce a product:" + product);
            System.out.println("wait for 3 seconds for consuming");
            try {
                TimeUnit.SECONDS.sleep(3);
                queue.put(product);
            } catch (InterruptedException e) {

            }
        }
    }

    static class Consumer extends Thread {
        private SynchronousQueue<Integer> queue;

        public Consumer(SynchronousQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                System.out.println("consume product:" + queue.take());
            } catch (InterruptedException e) {

            }
        }
    }
}
