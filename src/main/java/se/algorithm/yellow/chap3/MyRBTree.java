/*
package review.algorithm.yellow.chap3;

*/
/**
 * Created by Administrator on 2018/2/24.
 *//*

public class MyRBTree<Key extends Comparable<Key>> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private RBTNode<Key> root;

    private class RBTNode<Key> {
        private RBTNode<Key> left;
        private RBTNode<Key> right;
        private RBTNode<Key> parent;
        private boolean color;
        private Key key;

        public RBTNode(Key key, boolean color, RBTNode<Key> left, RBTNode<Key> right, RBTNode<Key> parent) {
            this.key = key;
            this.left = left;
            this.color = color;
            this.right = right;
            this.parent = parent;
        }
    }

    public MyRBTree() {
        root = null;
    }

    private boolean isRed(RBTNode<Key> node) {
        return node != null && node.color == RED;
    }

    private boolean isBlack(RBTNode<Key> node) {
        return !isRed(node);
    }

    public void insert(Key key) {
        RBTNode<Key> node = new RBTNode(key, BLACK, null, null, null);
        insert(node);
    }

    private RBTNode<Key> parentOf(RBTNode<Key> node) {
        return node == null ? null : node.parent;
    }

    private void setBlack(RBTNode<Key> node) {
        node.color = BLACK;
    }

    private void setRed(RBTNode<Key> node) {
        node.color = RED;
    }

    private void insert(RBTNode<Key> node) {
        if (root == null) {
            root = node;
        } else {
            RBTNode<Key> parent = null;
            RBTNode<Key> current = root;
            while (current != null) {
                parent = current;
                int cmp = current.key.compareTo(node.key);
                if (cmp > 0) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            node.parent = parent;
            if (parent.key.compareTo(node.key) > 0) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            node.color = RED;
            if (isRed(parent)) {
                insertFixUp(node);
            }
        }
    }

    private void insertFixUp(RBTNode<Key> node) {
        RBTNode<Key> parent, gparent;
        while ((parent = parentOf(node)) != null && isRed(node)) {
            gparent = parentOf(parent);
            if (gparent.left == parent) {
                RBTNode<Key> uncle = gparent.right;
                if (isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }
                if (parent.right == node) {
                    leftRotate(parent);
                    RBTNode<Key> tmp = parent;
                    parent = node;
                    node = tmp;
                }
                setRed(gparent);
                setBlack(parent);
                rightRotate(gparent);
            } else {
                RBTNode<Key> uncle = gparent.left;
                if (isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }
                if (parent.left == node) {
                    rightRotate(parent);
                    RBTNode<Key> tmp = parent;
                    parent = node;
                    node = tmp;
                }
                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }
        root.color = BLACK;
    }

    private void rightRotate(RBTNode<Key> node) {
        RBTNode<Key> son = node.left;
        node.left = son.right;
        son.parent = node.parent;
        if (node.parent == null) {
            root = son;
        } else {
            if (node.parent.left == node) {
                node.parent.left = son;
            } else {
                node.parent.right = son;
            }
        }
        son.right.parent = node;
        node.parent = son;
        son.right = node;
    }

    private void leftRotate(RBTNode<Key> node) {
        RBTNode<Key> son = node.right;
        node.right = son.left;
        son.left.parent = node;
        son.parent = node.parent;
        if (node.parent == null) {
            root = son;
        } else {
            if (node.parent.left == node) {
                node.parent.left = son;
            } else {
                node.parent.right = son;
            }
        }
        son.left = node;
        node.parent = son;
    }

    private RBTNode<Key> search(Key key) {
        RBTNode<Key> x = root;
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

    public void remove(Key key) {
        RBTNode<Key> node = search(key);
        if (node != null) {
            remove(node);
        }
    }

    private void remove(RBTNode<Key> node) {
        RBTNode<Key> child, parent;
        boolean color;
        if (node.left != null && node.right != null) {
            RBTNode<Key> replace = node.right;
            while (replace.left != null) {
                replace = replace.left;
            }

            if (node.parent == null) {
                root = replace;
            } else {
                if (node.parent.left == node) {
                    node.parent.left = replace;
                } else {
                    node.parent.right = replace;
                }
            }
            color = replace.color;
            child = replace.right;
            if (replace.parent == node) {
                parent = replace;
            } else {
                parent = replace.parent;
            }
            replace.parent = node.parent;
            replace.left = node.left;
            replace.right = node.right;
            replace.color = node.color;
            if (color == BLACK) {
                removeFixUp(child, parent);
            }
            return;
        }
        if (node.left != null) {
            child = node.left;
        } else {
            child = node.right;
        }
        parent = node.parent;
        if (parent == null) {
            root = child;
        }
    }
}
*/
