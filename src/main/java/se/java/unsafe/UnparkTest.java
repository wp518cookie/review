package se.java.unsafe;

import sun.misc.Unsafe;

/**
 * Created by Administrator on 2018/1/19.
 */
public class UnparkTest {
    public static void main(String[] args) {
        Unsafe unsafe = UnsafeGenerator.getUnsafe();
        Thread thread = Thread.currentThread();
        unsafe.unpark(thread);
        System.out.println("before park");
        unsafe.park(false, 0);
        System.out.println("after park");
    }
}
