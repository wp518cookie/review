package dp.singleton;

/**
 * Created by Administrator on 2018/4/11.
 */
public class Singleton {
    private Singleton() {}


    public static Singleton getSingleTon() {
        return Inner.singleton;
    }

    private static class Inner {
        private static Singleton singleton = new Singleton();
    }
}
