package basis.concurrent.inaction.chap6;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/1/12.
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        int countBits = Integer.SIZE - 3;
        int running  = -1 << countBits;
        int capacity = (1 << countBits) - 1;
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(running));
        System.out.println(Integer.toBinaryString(capacity));
    }
}
