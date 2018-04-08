package se.basis.sourcecode.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by ping.wu on 2018/4/9.
 */
public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        new Thread1(lock).start();
    }

    static class Thread1 extends Thread {
        private ReadWriteLock lock;

        public Thread1(ReadWriteLock lock) {
            this.lock = lock;
        }

        public void run() {
            System.out.println("Threa1 start running");
            lock.readLock().lock();
            try {
                System.out.println("Thread1 read start");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Thread1 read end");
            } catch (InterruptedException e) {
                System.out.println("Thread1 interrupted");
            } finally {
                lock.readLock().unlock();
            }
        }
    }

    static class Thread2 extends Thread {
        private ReadWriteLock lock;

        public Thread2(ReadWriteLock lock) {
            this.lock = lock;
        }

        public void run() {
            System.out.println("Threa2 start running");
            lock.readLock().lock();
            try {
                System.out.println("Thread2 read start");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Thread2 read end");
            } catch (InterruptedException e) {
                System.out.println("Thread2 interrupted");
            } finally {
                lock.readLock().unlock();
            }
        }
    }

    static class Thread3 extends Thread {
        private ReadWriteLock lock;

        public Thread3(ReadWriteLock lock) {
            this.lock = lock;
        }

        public void run() {
            System.out.println("Threa3 start running");
            lock.readLock().lock();
            try {
                System.out.println("Thread3 read start");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Thread3 read end");
            } catch (InterruptedException e) {
                System.out.println("Thread3 interrupted");
            } finally {
                lock.readLock().unlock();
            }
        }
    }
}
