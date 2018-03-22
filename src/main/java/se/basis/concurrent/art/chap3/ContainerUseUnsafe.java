package se.basis.concurrent.art.chap3;

/**
 * Created by Administrator on 2018/3/1.
 */
public class ContainerUseUnsafe {
    public static class SomeThing {
        private int status;

        public SomeThing() {
            status = 1;
        }

        public int getStatus() {
            return status;
        }
    }

    private SomeThing object;

    private Object value;

}
