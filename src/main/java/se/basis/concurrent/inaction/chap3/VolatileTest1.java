package se.basis.concurrent.inaction.chap3;

/**
 * Created by Administrator on 2017/12/25.
 */
public class VolatileTest1 {
    private static volatile int count = 0;
    private static void increase() {
        count++;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    increase();
                }
            }).start();
        }
        System.out.println(count);
    }
}
