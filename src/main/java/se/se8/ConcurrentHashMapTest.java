package se.se8;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by Administrator on 2018/4/3.
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, LongAdder> map = new ConcurrentHashMap<>();
        map.computeIfAbsent("key", k -> new LongAdder()).increment();
        map.get("key");
    }
}
