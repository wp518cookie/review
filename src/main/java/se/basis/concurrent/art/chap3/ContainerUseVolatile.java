package se.basis.concurrent.art.chap3;

/**
 * Created by Administrator on 2018/3/1.
 */
public class ContainerUseVolatile {
    public static class SomeThing {
        private int status;

        public SomeThing() {
            status = 1;
        }

        public int getStatus() {
            return status;
        }
    }

    private volatile SomeThing object;

    public void create() {
        object = new SomeThing();
    }

    public SomeThing get() {
        while (object == null) {
            Thread.yield();
        }
        return object;
    }
}
