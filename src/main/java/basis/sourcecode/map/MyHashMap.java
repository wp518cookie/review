package basis.sourcecode.map;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Administrator on 2017/10/19.
 */
public class MyHashMap<K, V> {
    static final int MIN_TREEIFY_CAPACITY = 64;
    static final int UNTREEIFY_THRESHOLD = 6;
    transient Node<K, V>[] table;
    transient Set<Map.Entry<K, V>> entrySet;
    transient Set<K> keySet;
    transient Collection<V> values;
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;


    private static class Node<K, V> implements Map.Entry<K, V>{
        K key;
        V value;
        int hash;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o instanceof Map.Entry) {
                Map.Entry e = (Map.Entry) o;
                if (Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue())) {
                    return true;
                }
            }
            return false;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }

}
