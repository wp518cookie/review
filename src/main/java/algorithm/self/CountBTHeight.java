package algorithm.self;

import java.util.LinkedList;

/**
 * Created by ping.wu on 2018/2/11.
 */
public class CountBTHeight {
    public static void main(String[] args) {
        BTree node1 = new BTree();
        BTree node2 = new BTree();
        BTree node3 = new BTree();
        BTree node4 = new BTree();
        BTree node5 = new BTree();
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

        System.out.println(count(node1));
    }
    public static int count(BTree root) {
        LinkedList<BTree> queue = new LinkedList();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int cur = 0;
            int last = queue.size();
            while (cur < last) {
                BTree node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                } else if (node.right != null) {
                    queue.offer(node.right);
                }
                cur++;
            }
            level++;
        }
        return level;
    }
}
class BTree {
    BTree left;
    BTree right;
}
