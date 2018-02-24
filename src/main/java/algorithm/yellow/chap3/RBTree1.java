package algorithm.yellow.chap3;

/**
 * Created by Administrator on 2018/2/23.
 * blog上的代码，只有key
 */
public class RBTree1<T extends Comparable<T>> {
    private RBTNode<T> root;
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public class RBTNode<T extends Comparable<T>> {
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

        public T getKey() {
            return key;
        }

        public String toString() {
            return "" + key + (this.color == RED ? "(R)" : "B");
        }
    }

    public RBTree1() {
        this.root = null;
    }

    private RBTNode<T> parentOf(RBTNode<T> node) {
        return node != null ? node.parent : null;
    }

    private boolean colorOf(RBTNode<T> node) {
        return node != null ? node.color : BLACK;
    }

    private boolean isRed(RBTNode<T> node) {
        return node != null && (node.color == RED ? true : false);
    }

    private boolean isBlack(RBTNode<T> node) {
        return !isRed(node);
    }

    private void setRed(RBTNode<T> node) {
        if (node != null) {
            node.color = RED;
        }
    }

    private void setBlack(RBTNode<T> node) {
        if (node != null) {
            node.color = BLACK;
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

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(RBTNode<T> node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(RBTNode<T> node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key + " ");
            inOrder(node.right);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(RBTNode<T> node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key + " ");
        }
    }

    public RBTNode<T> search(T key) {
        return search(root, key);
    }

    private RBTNode<T> search(RBTNode<T> node, T key) {
        if (node == null) {
            return node;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return search(node.left, key);
        } else if (cmp > 0) {
            return search(node.right, key);
        } else {
            return node;
        }
    }

    public void insert(T key) {
        RBTNode<T> node = new RBTNode(key, BLACK, null, null, null);
        if (node != null) {
            insert(node);
        }
    }

    private void insert(RBTNode<T> node) {
        int cmp;
        RBTNode<T> y = null;
        RBTNode<T> x = root;
        //不考虑key相等的情况?
        while (x != null) {
            y = x;
            cmp = node.key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.parent = y;
        if (y != null) {
            cmp = node.key.compareTo(y.key);
            if (cmp > 0) {
                y.right = node;
            } else {
                y.left = node;
            }
        } else {
            root = node;
        }
        setRed(node);
        insertFixUp(node);
    }

    private void insertFixUp(RBTNode<T> node) {
        RBTNode<T> parent, gparent;
        while ((parent = parentOf(node)) != null && isRed(parent)) {
            //因为根节点必定是黑色的，所以不用担心gparent == null
            gparent = parentOf(parent);
            if (parent == gparent.left) {
                RBTNode<T> uncle = gparent.right;
                if (isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }
                //LR旋转
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
            } else if (parent == gparent.right) {
                RBTNode<T> uncle = gparent.left;
                if (isRed(uncle)) {
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
                    parent = node;
                    node = tmp;
                }
                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }
        setBlack(root);
    }

    private void leftRotate(RBTNode<T> x) {
        RBTNode<T> y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else {
            if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(RBTNode<T> y) {
        RBTNode<T> x = y.left;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == null) {
            root = x;
        } else {
            if (y.parent.left == y) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
        }
        x.right = y;
        y.parent = x;
    }

    public void remove(T key) {
        RBTNode<T> node;
        if ((node = search(key)) != null) {
            remove(node);
        }
    }

    private void remove(RBTNode<T> node) {
        RBTNode<T> child, parent;
        boolean color;
        if (node.left != null && node.right != null) {
            RBTNode<T> replace = node;
            replace = replace.right;
            while (replace.left != null) {
                replace = replace.left;
            }
            if ((parentOf(node)) != null) {
                if ((parentOf(node)).left == node) {
                    parentOf(node).left = replace;
                } else {
                    parentOf(node).right = replace;
                }
            } else {
                root = replace;
            }
            child = replace.right;
            parent = replace.parent;
            color = colorOf(replace);
            if (parent == node) {
                parent = replace;
            } else {
                if (child != null) {
                    setParent(child, parent);
                }
                parent.left = child;
                replace.right = node.right;
                setParent(node.right, replace);
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
        if (node.left != null) {
            child = node.left;
        } else {
            child = node.right;
        }
        parent = node.parent;
        color = node.color;
        if (parent != null) {
            if (parent.left == node) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        } else {
            root = child;
        }
        if (color == BLACK) {
            removeFixUp(child, parent);
        }
        node = null;
    }

    private void removeFixUp(RBTNode<T> node, RBTNode<T> parent) {
        RBTNode<T> other;
        while ((node == null || isBlack(node)) && (node != root)) {
            if (parent.left == node) {
                other = parent.right;
                if (isRed(other)) {
                    setBlack(other);
                    setRed(parent);
                    leftRotate(parent);
                    other = parent.right;
                }
                if ((other.left == null || isBlack(other.left)) && (other.right == null || isBlack(other.right))) {
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);
                } else {
                    if (other.right == null || isBlack(other.right)) {
                        setBlack(other.left);
                        setRed(other);
                        rightRotate(other);
                        other = parent.right;
                    }
                    setColor(other, colorOf(parent));
                    setBlack(parent);
                    setBlack(other.right);
                    leftRotate(parent);
                    node = root;
                    break;
                }
            } else {
                other = parent.left;
                if (isRed(other)) {
                    setBlack(other);
                    setRed(parent);
                    rightRotate(parent);
                    other = parent.left;
                }
                if ((other.left == null || isBlack(other.left)) && (other.right == null || isBlack(other.right))) {
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);
                } else {
                    if (other.left == null || isBlack(other.left)) {
                        setBlack(other.right);
                        setRed(other);
                        leftRotate(other);
                        other = parent.left;
                    }
                    setColor(other, colorOf(parent));
                    setBlack(parent);
                    setBlack(other.left);
                    rightRotate(parent);
                    node = root;
                    break;
                }
            }
        }
        if (node != null) {
            setBlack(node);
        }
    }

    public static void main(String[] args) {
        RBTree1<Integer> rbTree1 = new RBTree1();
        rbTree1.insert(10);
        rbTree1.insert(3);
        rbTree1.insert(12);
        rbTree1.insert(4);
        rbTree1.insert(1);
        rbTree1.insert(9);
        rbTree1.insert(7);
        rbTree1.insert(8);
        rbTree1.insert(15);
        rbTree1.insert(13);
        rbTree1.preOrder();
    }
}