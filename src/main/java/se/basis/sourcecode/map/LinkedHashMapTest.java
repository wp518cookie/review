package se.basis.sourcecode.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/4.
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap();
        LinkedHashMap<String, String> lruMap = new LinkedHashMap(10, 0.75f, true);
        HashMap<String, String> map1 = new HashMap();
        for (int i = 0; i < 100; i++) {
            map.put(i + "", i + "");
            lruMap.put(i + "", i + "");
            map1.put(i + "", i + "");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " ");
        }
        System.out.println();
        map.put(10 + "", 10 + "");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " ");
        }
        System.out.println();
        for (Map.Entry<String, String> entry : lruMap.entrySet()) {
            System.out.print(entry.getKey() + " ");
        }
        lruMap.put(10 + "", 10 + "");
        System.out.println();
        for (Map.Entry<String, String> entry : lruMap.entrySet()) {
            System.out.print(entry.getKey() + " ");
        }
        System.out.println();
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            System.out.print(entry.getKey() + " ");
        }
    }
}
