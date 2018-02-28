package basis.concurrent.art.chap1;

import java.util.concurrent.TimeUnit;

/**
 * Created by ping.wu on 2018/2/28.
 */
public class DeadLockDemo {
    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    static class A implements Runnable {
        public void run() {
            synchronized (obj1) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("A is interrupted");
                }
                synchronized (obj2) {
                    System.out.println("A is done");
                }
            }
        }
    }

    static class B implements Runnable {
        public void run() {
            synchronized (obj2) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("B is interrupted");
                }
                synchronized (obj1) {
                    System.out.println("B is done");
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new A()).start();
        new Thread(new B()).start();
    }
}
