//package review.basis.sourcecode.concurrent.collection;
//
//import sun.misc.Unsafe;
//import se.util.UnsafeGenerator;
//
///**
// * Created by Administrator on 2018/1/11.
// */
//public class MyConcurrentLinkedQueue<E> {
//    private static final Unsafe UNSAFE;
//    private transient volatile Node<E> head;
//    private transient volatile Node<E> tail;
//    private static final long headOffset;
//    private static final long tailOffset;
//
//    private static class Node<E> {
//        volatile E item;
//        volatile Node<E> next;
//        private static final Unsafe UNSAFE;
//        private static final long itemOffset;
//        private static final long nextOffset;
//
//        static {
//            try {
//                UNSAFE = UnsafeGenerator.getUnsafe();
//                Class<?> k = Node.class;
//                itemOffset = UNSAFE.objectFieldOffset(k.getDeclaredField("item"));
//                nextOffset = UNSAFE.objectFieldOffset(k.getDeclaredField("next"));
//            } catch (Exception e) {
//                throw new Error(e);
//            }
//        }
//
//        Node(E item) {
//            UNSAFE.putObject(this, itemOffset, item);
//        }
//
//        boolean casItem(E cmp, E val) {
//            return UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val);
//        }
//
//        void lazySetNext(Node<E> val) {
//            UNSAFE.putOrderedObject(this, nextOffset, val);
//        }
//
//        boolean casNext(Node<E> cmp, Node<E> val) {
//            return UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
//        }
//    }
//
//    static {
//        try {
//            UNSAFE = UnsafeGenerator.getUnsafe();
//            Class<?> k = MyConcurrentLinkedQueue.class;
//            headOffset = UNSAFE.objectFieldOffset(k.getDeclaredField("head"));
//            tailOffset = UNSAFE.objectFieldOffset(k.getDeclaredField("tail"));
//        } catch (Exception e) {
//            throw new Error(e);
//        }
//    }
//
//    public MyConcurrentLinkedQueue() {
//        head = tail = new Node(null);
//    }
//
//    public void checkNotNull(E e) {
//        if (e == null) {
//            throw new NullPointerException();
//        }
//    }
//
//    public boolean offer(E e) {
//        checkNotNull(e);
//        Node<E> node = new Node(e);
//
//    }
//}
