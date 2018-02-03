package blog.java.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2018/1/19.
 */
public class StaticFieldTest {
    private static int staticoffset = 20;

    public static void main(String[] args) throws Exception {
        Unsafe unsafe = UnsafeGenerator.getUnsafe();
        Field field = UnsafeTest.class.getDeclaredField("staticoffset");
        long offset = unsafe.staticFieldOffset(field);
        Object staticFieldBase = unsafe.staticFieldBase(field);
        int val = unsafe.getInt(staticFieldBase, offset);
        System.out.println(val);
    }

    //唤醒
    public native void unpark(Thread thread);

    //isAbsolute
    //为true时，表示绝对时间，单位是毫秒 time = System.currentTimeMillis() + 3000 表示当前时间3秒后
    //为false时，表示相对时间，单位是纳秒 time = 30000000，00挂起一段时间
    //park(false, 0)表示一直等待，直到有unpark(thisThread)
    public native void park(boolean isAbsolute, long time);

    //object:需要被修改类的实例
    //fieldOffset:该field的内存偏移量，unsafe.objectFieldOffset（Field field）
    //oldValue:旧的预期值
    //newValue:新的值
    public final native boolean compareAndSwapInt(Object object, long fieldOffset, int oldValue, int newValue);
}
