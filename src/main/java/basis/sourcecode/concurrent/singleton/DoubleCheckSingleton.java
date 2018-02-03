package basis.sourcecode.concurrent.singleton;

/**
 * Created by Administrator on 2017/11/29.
 */
public class DoubleCheckSingleton {
    private static volatile DoubleCheckSingleton singleton;

    private DoubleCheckSingleton() {

    }

    public static DoubleCheckSingleton getSingleton() {
        if (singleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckSingleton();
                    return singleton;
                }
            }
        }
        return singleton;
    }
}
