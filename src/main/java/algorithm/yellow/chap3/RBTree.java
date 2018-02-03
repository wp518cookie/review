package algorithm.yellow.chap3;

import java.util.Stack;

/**
 * Created by Administrator on 2017/12/7.
 */
public class RBTree<T extends Comparable<T>> {
    private int N;
    private static final boolean RED = false;
    private static final boolean BLACK = true;
    private RBTNode<T> mRoot;

    private class RBTNode<T extends Comparable<T>> {
        boolean color;
        T key;
        RBTNode<T> left;
        RBTNode<T> right;
        RBTNode<T> parent;

        public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return "" + key + (this.color == RED ? "(R)" : "B");
        }
    }

    public RBTree() {
        mRoot = null;
    }

    private RBTNode<T> parentOf(RBTNode<T> node) {
        return node != null ? node.parent : null;
    }

    private boolean colorOf(RBTNode<T> node) {
        return node != null ? node.color : BLACK;
    }

    private boolean isRed(RBTNode<T> node) {
        return (node != null) && (node.color == RED);
    }

    private boolean isBlack(RBTNode<T> node) {
        return !isRed(node);
    }

    private void setBlack(RBTNode<T> node) {
        if (node != null) {
            node.color = BLACK;
        }
    }

    private void setRed(RBTNode<T> node) {
        if (node != null) {
            node.color = RED;
        }
    }

    private void setParent(RBTNode<T> node, RBTNode<T> parent) {
        if (node != null) {
            node.parent = parent;
        }
    }

    private void setColor(RBTNode<T> node, boolean color) {
        if (node != null) {
            node.color = color;
        }
    }

    //非递归遍历
    public void preOrder(RBTNode<T> tree) {
        if (tree != null) {
            System.out.print(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(mRoot);
    }

    private void preOrderNoRecursive(RBTNode<T> node) {
        Stack<RBTNode> stack = new Stack();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.print(node.key + " ");
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                RBTNode<T> temp = stack.pop();
                node = temp.right;
            }
        }
    }

    public void preOrderNoRecursive() {
        preOrderNoRecursive(mRoot);
    }

    //递归前序遍历
    private void inOrder(RBTNode<T> node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    //非递归前序遍历
    private void inOrderNoRecursive(RBTNode<T> node) {
        Stack<RBTNode<T>> stack = new Stack();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                RBTNode<T> temp = stack.pop();
                System.out.print(temp.key + " ");
                node = temp.right;
            }
        }
    }

    public void inOrder() {
        inOrder(mRoot);
    }

    public void inOrderNoRecursive() {
        inOrderNoRecursive(mRoot);
    }

    private void postOrder(RBTNode<T> node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + " ");
        }
    }

    private void postOrderNoRecursive(RBTNode<T> node) {
        Stack<RBTNode<T>> stack = new Stack();
        RBTNode<T> prev = node;
        while (node != null && !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                RBTNode<T> temp = stack.peek().right;
                if (temp == null || temp == prev) {
                    node = stack.pop();
                    System.out.print(node.key + " ");
                    prev = node;
                    node = null;
                } else {
                    node = temp;
                }
            }
        }
    }

    public void postOrder() {
        postOrder(mRoot);
    }

    public void postOrderNoRecursive() {
        postOrderNoRecursive(mRoot);
    }

    //递归
    private RBTNode<T> search(RBTNode<T> x, T key) {
        if (x == null) {
            return null;
        } else {
            int cmpResult = x.key.compareTo(key);
            if (cmpResult > 0) {
                return search(x.left, key);
            } else if (cmpResult < 0) {
                return search(x.right, key);
            } else {
                return x;
            }
        }
    }

    public RBTNode<T> search(T key) {
        return search(mRoot, key);
    }

    private RBTNode<T> iterativeSearch(RBTNode<T> x, T key) {
        while (x != null) {
            int cmp = x.key.compareTo(key);
            if (cmp > 0) {
                x = x.left;
            } else if (cmp < 0) {
                x = x.right;
            } else {
                break;
            }
        }
        return x;
    }

    public RBTNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    private RBTNode<T> minimum(RBTNode<T> tree) {
        if (tree != null) {
            while (tree.left != null) {
                tree = tree.left;
            }
        }
        return tree;
    }

    public RBTNode<T> minimum() {
        return minimum(mRoot);
    }

    private RBTNode<T> maximum(RBTNode<T> tree) {
        if (tree != null) {
            while (tree.right != null) {
                tree = tree.right;
            }
        }
        return tree;
    }

    public RBTNode<T> maximum() {
        return maximum(mRoot);
    }

    //获得后继节点
    public RBTNode<T> successor(RBTNode<T> x) {
        if (x != null) {
            RBTNode<T> temp = x.right;
            if (temp != null) {
                while (temp.left != null) {
                    temp = temp.left;
                }
            }
            return temp;
        }
        return null;
    }

    //获得前驱节点
    public RBTNode<T> predecessor(RBTNode<T> x) {
        if (x != null) {
            RBTNode<T> temp = x.left;
            if (temp != null) {
                while (temp.right != null) {
                    temp = temp.right;
                }
            }
            return temp;
        }
        return null;
    }

    private void leftRotate(RBTNode<T> x) {
        RBTNode<T> parent = x.parent;
        RBTNode<T> y = x.right;
        if (parent == null) {
            mRoot = y;
        } else {
            if (parent.left == x) {
                parent.left = y;
            } else {
                parent.right = y;
            }
        }
        y.parent = parent;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(RBTNode<T> y) {
        RBTNode<T> parent = y.parent;
        RBTNode<T> x = y.left;
        y.left = x.right;
        x.parent = parent;
        if (x.right != null) {
            x.right.parent = y;
        }
        if (parent == null) {
            this.mRoot = x;
        } else {
            if (parent.left == y) {
                parent.left = x;
            } else {
                parent.right = x;
            }
        }
        x.right = y;
        y.parent = x;
    }

    public void insert(T key) {
        RBTNode<T> node = new RBTNode(key, BLACK, null, null, null);
        if (node != null) {
            insert(node);
        }
    }

    private void insert(RBTNode<T> node) {
        RBTNode<T> y = null;
        RBTNode<T> x = mRoot;
        int cmp = 0;
        while (x != null) {
            cmp = node.key.compareTo(x.key);
            if (cmp > 0) {
                x = x.right;
                y = x;
            } else if (cmp < 0) {
                x = x.left;
                y = x;
            } else {
                return;
            }
        }
        if (y == null) {
            mRoot = node;
        } else {
            if (cmp > 0) {
                y.right = node;
            } else {
                y.left = node;
            }
            node.parent = y;
        }
        node.color = RED;
        insertFixUp(node);
    }

    private void insertFixUp(RBTNode<T> node) {
        RBTNode<T> parent = node.parent;
        RBTNode<T> gparent;
        if (parent == null) {
            setBlack(node);
        } else {
            while ((parent = parentOf(node)) != null && parent.color == RED) {
                gparent = parentOf(parent);
                if (parent == gparent.left) {
                    RBTNode<T> uncle = gparent.right;
                    if (uncle != null && isRed(uncle)) {
                        setBlack(parent);
                        setBlack(uncle);
                        setRed(gparent);
                        node = gparent;
                        continue;
                    }
                    if (parent.right == node) {
                        RBTNode<T> tmp;
                        leftRotate(parent);
                        tmp = parent;
                        parent = node;
                        node = tmp;
                    }
                    setBlack(parent);
                    setRed(gparent);
                    rightRotate(gparent);
                } else {
                    RBTNode<T> uncle = gparent.left;
                    if (uncle != null && isRed(uncle)) {
                        setBlack(uncle);
                        setBlack(parent);
                        setRed(gparent);
                        node = gparent;
                        continue;
                    }
                    if (parent.left == node) {
                        RBTNode<T> tmp;
                        rightRotate(parent);
                        tmp = parent;
                        node = parent;
                        parent = tmp;
                    }
                    setRed(gparent);
                    setBlack(parent);
                    leftRotate(gparent);
                }
            }
            setBlack(this.mRoot);
        }
    }

    public void remove(T key) {
        RBTNode<T> node;
        if ((node = search(mRoot, key)) != null) {
            remove(node);
        }
    }

    private void remove(RBTNode<T> node) {
        RBTNode<T> child, parent;
        boolean color;
        if (node.left != null && node.right != null) {
            RBTNode<T> replace = node.right;
            while (replace.left != null) {
                replace = replace.left;
            }
            if (parentOf(node) != null) {
                if (parentOf(node).left == node) {
                    parentOf(node).left = replace;
                } else {
                    parentOf(node).right = replace;
                }
            } else {
                this.mRoot = mRoot;
            }
            child = replace.right;
            parent = parentOf(replace);
            color = replace.color;
            if (parent == node) {
                parent = replace;
            } else {
                if (child != null) {
                    child.parent = parent;
                }
                parent.left = child;
                replace.right = node.right;
                node.right.parent = replace;
            }
            replace.parent = node.parent;
            replace.color = node.color;
            replace.left = node.left;
            node.left.parent = replace;
            if (color == BLACK) {
                removeFixUp(child, parent);
            }
            node = null;
            return;
        }
    }

    private void removeFixUp(RBTNode<T> node, RBTNode<T> parent) {
        RBTNode<T> other;
        while ((node == null || isBlack(node)) && (node != this.mRoot)) {

        }
    }
}

