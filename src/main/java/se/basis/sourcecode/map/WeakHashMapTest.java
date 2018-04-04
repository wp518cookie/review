package se.basis.sourcecode.map;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/4/4.
 */
public class WeakHashMapTest {
    public static void main(String[] args) throws Exception {
        WeakHashMap<WeakReference<String>, String> map = new WeakHashMap();
        map.put(new WeakReference<String>("hello"), "world");
        System.gc();
        TimeUnit.SECONDS.sleep(3);
        System.out.println(map.get("hello"));
    }
}
