package third_jar.jetbrain;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

/**
 * Created by ping.wu on 2018/4/20.
 */
public class TestNotNullAnnotation {
    public static void main(String[] args) {
        Random random = new Random();
        int num = random.nextInt(10);
        String s = null;
        if (num > 5) {
            s = "Hello World";
        }
        if ( s != null) {
            testMethod(s);
        }
    }

    public static void testMethod(@NotNull String message) {
        System.out.println(message);
    }
}
