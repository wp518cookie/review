package se.basis.sourcecode.concurrent.collection;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/1/11.
 */
public class MyArrayBlockingQueue<E> {
    final Object[] items;
    private int takeIndex;
    private int putIndex;
    private int count;
    private ReentrantLock lock;
    private Condition notEmpty;
    private Condition notFull;

    public MyArrayBlockingQueue(int capacity) {
        this(capacity, false);
    }

    public MyArrayBlockingQueue(int capacity, boolean fair) {
        this.items = new Object[capacity];
        takeIndex = putIndex = 0;
        count = 0;
        this.lock = new ReentrantLock(fair);
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }

    public boolean add(E e) {
        return offer(e);
    }

    private void checkNotNull(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
    }

    private E dequeue() {
        E result = (E) items[takeIndex];
        items[takeIndex] = null;
        if (++takeIndex == items.length) {
            takeIndex = 0;
        }
        count--;
        notFull.signal();
        return result;
    }

    private void enqueue(E e) {
        items[putIndex] = e;
        if (++putIndex == items.length) {
            putIndex = 0;
        }
        count++;
        notEmpty.signal();
    }

    public boolean offer(E e) {
        checkNotNull(e);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (count == items.length) {
                return false;
            } else {
                enqueue(e);
                return true;
            }
        } finally {
            lock.unlock();
        }
    }

    public E peek() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (count == 0) {
                return null;
            } else {
                return (E) items[takeIndex];
            }
        } finally {
            lock.unlock();
        }
    }

    public E take() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            return dequeue();
        } finally {
            lock.unlock();
        }
    }

    public void put(E e) throws InterruptedException {
        checkNotNull(e);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == items.length) {
                notFull.await();
            }
            enqueue(e);
        } finally {
            lock.unlock();
        }
    }
}
