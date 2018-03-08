package basis.sourcecode.concurrent.lock;

import sun.misc.Unsafe;
import util.UnsafeGenerator;

import java.util.concurrent.locks.AbstractOwnableSynchronizer;

/**
 * Created by ping.wu on 2018/3/6.
 */
public class MyAbstractQueueAynchronizer1_8 extends AbstractOwnableSynchronizer {
    //-------------------------------field-----------------------------------
    private transient volatile Node head;
    private transient volatile Node tail;
    private volatile int state;
    //-------------------------------inner Class-----------------------------
    static final class Node {

    }
    //-------------------------------method---------------------------------
    public final void acquire(int arg) {

    }
    //----------------------------unsupported method------------------------
    protected boolean tryAcquire(int arg) {
        throw new UnsupportedOperationException();
    }

    protected boolean tryRelease(int arg) {
        throw new UnsupportedOperationException();
    }

    protected boolean tryAcquireShared(int arg) {
        throw new UnsupportedOperationException();
    }

    protected boolean tryReleaseShared(int arg) {
        throw new UnsupportedOperationException();
    }

    protected boolean isHeldExclusively() {
        throw new UnsupportedOperationException();
    }
    //-------------------------------constant filed--------------------------
    private static final Unsafe unsafe = UnsafeGenerator.getUnsafe();
    private static final long stateOffset;
    private static final long headOffset;
    private static final long tailOffset;
    private static final long waitStatusOffset;
    private static final long nextOffset;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset
                    (MyAbstractQueueAynchronizer1_8.class.getDeclaredField("state"));
            headOffset = unsafe.objectFieldOffset
                    (MyAbstractQueueAynchronizer1_8.class.getDeclaredField("head"));
            tailOffset = unsafe.objectFieldOffset
                    (MyAbstractQueueAynchronizer1_8.class.getDeclaredField("tail"));
            waitStatusOffset = unsafe.objectFieldOffset
                    (Node.class.getDeclaredField("waitStatus"));
            nextOffset = unsafe.objectFieldOffset
                    (Node.class.getDeclaredField("next"));

        } catch (Exception ex) { throw new Error(ex); }
    }
    //-------------------------------set and get method----------------------
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
