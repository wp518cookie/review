package basis.concurrent.art.chap3;

/**
 * Created by Administrator on 2018/3/1.
 */
public class PossibleRecording {
    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                a = 1;
                x = b;
            }).start();
            new Thread(() -> {
                b = 1;
                y = a;
            }).start();
            System.out.println(x + ", " + y);
        }

    }
}
