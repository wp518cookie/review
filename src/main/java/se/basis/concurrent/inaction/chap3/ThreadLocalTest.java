package se.basis.concurrent.inaction.chap3;

/**
 * Created by Administrator on 2017/12/25.
 */
public class ThreadLocalTest {
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal();
    public static void main(String[] args) throws Exception {
        threadLocal.set(1);
        System.out.println(threadLocal.get());
        Thread a = new Thread(() -> {
           threadLocal.set(2);
        });
        a.start();
        threadLocal.set(3);
        System.out.println(threadLocal.get());
    }
}
