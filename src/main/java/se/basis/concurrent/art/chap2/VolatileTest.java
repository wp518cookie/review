package se.basis.concurrent.art.chap2;

/**
 * Created by ping.wu on 2018/2/28.
 */
public class VolatileTest {
    private static volatile int state;

    public static void main(String[] args) {
        new Thread(() -> {
            state = 10;
        }).start();
        System.out.println(state);
    }
}
