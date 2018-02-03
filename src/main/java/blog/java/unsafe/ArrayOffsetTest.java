package blog.java.unsafe;

import sun.misc.Unsafe;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/1/19.
 */
public class ArrayOffsetTest {
    public static void main(String[] args) throws Exception {
        Unsafe unsafe = UnsafeGenerator.getUnsafe();
        int[] arr = {1, 2, 3};
        //数组对象起始地址的内存偏移量
        long arrayOffset = unsafe.arrayBaseOffset(arr.getClass());
        //每个数组元素占用多少字节
        long scale = unsafe.arrayIndexScale(arr.getClass());
        unsafe.putInt(arr, arrayOffset + scale * 1, 1000);
        System.out.println(Arrays.toString(arr));
    }
}
