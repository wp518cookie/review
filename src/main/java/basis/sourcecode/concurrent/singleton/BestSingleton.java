package basis.sourcecode.concurrent.singleton;

/**
 * Created by Administrator on 2017/11/29.
 */
public class BestSingleton {
    private static class Inner {
        private static BestSingleton singleton = new BestSingleton();
    }
    public static BestSingleton getSingleton() {
        return Inner.singleton;
    }
}
