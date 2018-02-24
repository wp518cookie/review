package algorithm.yellow.chap3;

import java.util.Random;

/**
 * Created by Administrator on 2018/2/22.
 */
public class BST<Key extends Comparable<Key>, Value> {
    public Node root;

    private class Node {
        private Key key;
        private Value val;
        public int size;
        private Node left, right;

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BST() {

    }

    public void put(Key key, Value val) {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null");
        }
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else {
            x.val = val;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = x.key.compareTo(key);
        if (cmp > 0) {
            x.left = delete(x.left, key);
        } else if (cmp < 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.left == null) {
                return x.right;
            }
            if (x.right == null) {
                return x.left;
            }
            Node t = x;
            x = min(t.right);
            x.right = delMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    private Node min(Node x) {
        if (x == null) {
            return null;
        }
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    private Node delMin(Node x) {
        if (x == null) {
            return null;
        } else if (x.left == null) {
            return null;
        }
        Node t = x;
        Node parent = t;
        while (t.left != null) {
            parent = t;
            t = t.left;
        }
        parent.left = t.right;
        return x;
    }

    private void prePrint(Node x) {
        if (x == null) {
            return;
        }
        System.out.println(x.key + ":" + x.val + "  ");
        prePrint(x.left);
        prePrint(x.right);
    }

    private void midPrint(Node x) {
        if (x == null) {
            return;
        }
        midPrint(x.left);
        System.out.println(x.key + ":" + x.val + "  ");
        midPrint(x.right);
    }

    private void postPrint(Node x) {
        if (x == null) {
            return;
        }
        postPrint(x.left);
        postPrint(x.right);
        System.out.println(x.val);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        BST<Integer, Integer> bst = new BST();
        bst.put(50, 50);
        bst.put(20, 20);
        bst.put(60, 60);
        bst.put(40, 40);
        bst.put(10, 10);
        bst.put(30, 30);
        bst.put(45, 45);
        bst.put(80, 80);
        bst.put(90, 90);
        bst.put(100, 100);
        System.out.println(bst.root.size);
        bst.prePrint(bst.root);
        bst.delete(40);

        System.out.println("----------------------------");
        bst.prePrint(bst.root);
        System.out.println(bst.root.size);
    }
}
