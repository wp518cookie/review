package se.basis.javaperformance;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/12.
 */
public class StandardTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap();
        String a = "abc";
        map.put(a, "def");
        a = "def";
        System.out.println("abc");
    }
}
