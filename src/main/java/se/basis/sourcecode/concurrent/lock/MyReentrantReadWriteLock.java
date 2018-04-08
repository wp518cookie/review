/*
package se.basis.sourcecode.concurrent.lock;

import se.java.unsafe.UnsafeGenerator;
import sun.misc.Unsafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

*/
/**
 * Created by ping.wu on 2018/4/9.
 *//*

public class MyReentrantReadWriteLock implements ReadWriteLock {
    private final MyReentrantReadWriteLock.ReadLock readerLock;
    private final MyReentrantReadWriteLock.WriteLock writerLock;
    final Sync sync;
    private static final Unsafe UNSAFE;
    private static final long TID_OFFSET;
    static {
        try {
            UNSAFE = UnsafeGenerator.getUnsafe();
            Class<?> tk = Thread.class;
            TID_OFFSET = UNSAFE.objectFieldOffset(tk.getDeclaredField("tid"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    //---------------static class--------------------
    public static class ReadLock implements Lock {

    }

    public static class WriteLock implements Lock {

    }
}
*/
