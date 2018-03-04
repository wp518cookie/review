package basis.concurrent.art.chap2;

/**
 * Created by Administrator on 2018/3/1.
 */
public class SynchronizedTest {
    public volatile int b = 1;
    public static void main(String[] args) {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        int a = 0;
        synchronized (synchronizedTest) {
            System.out.println(a);
            System.out.println("hello world!");
            System.out.println(synchronizedTest.b);
        }
    }
}
