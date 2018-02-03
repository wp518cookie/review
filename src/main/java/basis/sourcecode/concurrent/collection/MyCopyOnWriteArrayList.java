//package basis.sourcecode.concurrent.collection;
//
//import sun.misc.Unsafe;
//import util.UnsafeGenerator;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Iterator;
//import java.util.List;
//import java.util.concurrent.CopyOnWriteArrayList;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * Created by Administrator on 2017/12/29.
// */
//public class MyCopyOnWriteArrayList<E> {
//    final transient ReentrantLock lock = new ReentrantLock();
//    private transient volatile Object[] array;
//    private static final Unsafe UNSAFE = UnsafeGenerator.getUnsafe();
//    private static final long lockOffset;
//
//    static {
//        try {
//            Class<?> k = CopyOnWriteArrayList.class;
//            lockOffset = UNSAFE.objectFieldOffset(k.getDeclaredField("lock"));
//        } catch (Exception e) {
//            throw new Error(e);
//        }
//    }
//
//    public MyCopyOnWriteArrayList() {
//        setArray(new Object[0]);
//    }
//
//    public MyCopyOnWriteArrayList(Collection<? extends E> c) {
//        Object[] elements;
//        if (c.getClass() == MyCopyOnWriteArrayList.class) {
//            elements = ((MyCopyOnWriteArrayList<?>) c).getArray();
//        } else {
//            elements = c.toArray();
//            if (elements.getClass() != Object[].class) {
//                elements = Arrays.copyOf(elements, elements.length, Object[].class);
//            }
//        }
//        setArray(elements);
//    }
//
//    public boolean add(E e) {
//        final ReentrantLock lock = this.lock;
//        lock.lock();
//        try {
//            Object[] elements = getArray();
//            int len = elements.length;
//            Object[] newElements = Arrays.copyOf(elements, len + 1);
//            newElements[len] = e;
//            setArray(newElements);
//            return true;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public void add(int index, E element) {
//        final ReentrantLock lock = this.lock;
//        lock.lock();
//        try {
//            Object[] elements = getArray();
//            int len = elements.length;
//            if (index > len || index < 0) {
//                throw new IndexOutOfBoundsException("Index: " + index + ", size: " + len);
//            }
//            Object[] newElements;
//            int numMoved = len - index;
//            if (numMoved == 0) {
//                newElements = Arrays.copyOf(elements, len + 1);
//            } else {
//                newElements = new Object[len + 1];
//                System.arraycopy(element, 0, newElements, 0, index);
//                System.arraycopy(elements, index, newElements, index + 1, numMoved);
//            }
//            newElements[index] = element;
//            setArray(newElements);
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public boolean addAll(Collection<? extends E> c) {
//        Object[] cs = (c.getClass() == MyCopyOnWriteArrayList.class) ? ((MyCopyOnWriteArrayList<?>) c).getArray() : c.toArray();
//        if (cs.length == 0) {
//            return false;
//        }
//        final ReentrantLock lock = this.lock;
//        lock.lock();
//        try {
//            Object[] elements = getArray();
//            int len = elements.length;
//            if (len == 0 && cs.getClass() == Object[].class) {
//                setArray(cs);
//            } else {
//                Object[] newElement = Arrays.copyOf(elements, len + cs.length);
//                System.arraycopy(cs, 0, newElement, len, cs.length);
//                setArray(newElement);
//            }
//            return true;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public void clear() {
//        final ReentrantLock lock = this.lock;
//        lock.lock();
//        try {
//            setArray(new Object[0]);
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public boolean contains(Object o) {
//        Object[] elements = getArray();
//        return indexOf(o, elements, 0, elements.length) >= 0;
//    }
//
//    public static boolean eq(Object o1, Object o2) {
//        return (o1 == null) ? o2 == null : o1.equals(o2);
//    }
//
//    public boolean equals(Object o) {
//        if (o == this) {
//            return true;
//        }
//        if (!(o instanceof List)) {
//            return false;
//        }
//        List<?> list = (List<?>)(o);
//        Object[] elements = getArray();
//        if (list.size() != elements.length) {
//            return false;
//        }
//        Iterator<?> it = list.iterator();
//        for (int i = 0; i < elements.length; i++) {
//            if (!eq(elements[i], it.next())) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public int indexOf(Object o) {
//        Object[] elements = getArray();
//        return indexOf(o, elements, 0, elements.length);
//    }
//
//    public int indexOf(E e, int index) {
//        Object[] elements = getArray();
//        return indexOf(e, elements, index, elements.length);
//    }
//
//    private static int indexOf(Object o, Object[] elements, int index, int fence) {
//        if (o == null) {
//            for (int i = index; i < fence; i++) {
//                if (elements[i] == null) {
//                    return i;
//                }
//            }
//        } else {
//            for (int i = index; i < fence; i++) {
//                if (o.equals(elements[i])) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
//
//    public E get(int index) {
//        return get(getArray(), index);
//    }
//
//    public E get(Object[] elements, int index) {
//        return (E) elements[index];
//    }
//
//    final Object[] getArray() {
//        return array;
//    }
//
//    public int hashCode() {
//        int hashCode = 1;
//        Object[] elements = getArray();
//        int len = elements.length;
//        for (int i = 0; i < len; i++) {
//            Object obj = elements[i];
//            hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
//        }
//        return hashCode;
//    }
//
//    public boolean isEmpty() {
//        return size() == 0;
//    }
//
//    public int lastIndexOf(Object o) {
//        Object[] elements = getArray();
//        return lastIndexOf(o, elements, elements.length - 1);
//    }
//
//    public int lastIndexOf(Object o, Object[] elements, int index) {
//        if (o == null) {
//            for (int i = index; i >= 0; i--) {
//                if (elements[i] == null) {
//                    return i;
//                }
//            }
//        } else {
//            for (int i = index; i >= 0; i--) {
//                if (o.equals(elements[i])) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
//
//    final void setArray(Object[] a) {
//        array = a;
//    }
//
//    public int size() {
//        return getArray().length;
//    }
//}
