package basis.concurrent.inaction.chap3;

/**
 * Created by Administrator on 2017/12/26.
 */
public class SingleTonByStatic {

    private SingleTonByStatic() {

    }

    private static class SingletonFactory {
        private static final SingleTonByStatic singleTonByStatic = new SingleTonByStatic();
    }

    public static SingleTonByStatic getSingleton() {
        return SingletonFactory.singleTonByStatic;
    }
}
