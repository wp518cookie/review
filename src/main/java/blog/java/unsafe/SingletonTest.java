package blog.java.unsafe;

import sun.misc.Unsafe;

/**
 * Created by Administrator on 2018/1/19.
 */
public class SingletonTest {
    public static void main(String[] args) throws Exception {
        Unsafe unsafe = UnsafeGenerator.getUnsafe();
        SingleTon singleTon = (SingleTon) unsafe.allocateInstance(SingleTon.class);
        System.out.println(singleTon == SingleTon.getSingleton());
    }
}

class SingleTon {
    private static SingleTon singleton = new SingleTon();

    private SingleTon() {
    }

    public static SingleTon getSingleton() {
        return singleton;
    }
}
