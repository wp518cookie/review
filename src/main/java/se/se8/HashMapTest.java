package se.se8;

import java.util.HashMap;

/**
 * Created by ping.wu on 2018/4/19.
 */
public class HashMapTest {

    public int testHash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static class InnerHashMap {
        Integer key;
        Integer value;

        public InnerHashMap(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            return key.hashCode() + value.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof InnerHashMap) {
                InnerHashMap temp = (InnerHashMap)obj;
                return value.equals(temp.value) && key.equals(temp.key);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        HashMapTest hashMapTest = new HashMapTest();

        hashMapTest.testHash(1);

        HashMap<InnerHashMap, String> map = new HashMap<>();

        InnerHashMap innerHashMap = new InnerHashMap(1, 2);
        System.out.println("current hash code : " + innerHashMap.hashCode());
        map.put(innerHashMap, "1");
        innerHashMap.setKey(5);
        System.out.println("current hash code : " + innerHashMap.hashCode());
        System.out.println("current value in map : " + map.get(innerHashMap));
    }
}
