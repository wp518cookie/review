package se.algorithm.yellow.chap3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Administrator on 2017/12/1.
 */
public class BinaryTree<T extends Comparable<? super T>> {
    private int size;
    private TreeNode<T> root;
    private Queue<T> q = new LinkedList();
    public BinaryTree() {
        root = null;
    }
    public BinaryTree(TreeNode<T> root) {
        this.root = root;
        size = 1;
    }
    //非递归写法
    public boolean insert(T e) {
        if (root == null) {
            root = new TreeNode(null, e, null);
            size = 1;
            return true;
        }
        if (e == null) {
            throw new NullPointerException();
        }
        Comparable<? super T> nodeValue = (Comparable<? super T>) e;
        TreeNode<T> t = root;
        TreeNode<T> parent = null;
        int cmpResult = 0;
        while (t != null) {
            cmpResult = nodeValue.compareTo(t.getValue());
            if (cmpResult > 0) {
                parent = t;
                t = t.right;
            } else if (cmpResult < 0) {
                parent = t;
                t = t.left;
            } else {
                return false;
            }
        }
        TreeNode<T> newNode = new TreeNode(null, e, null);
        if (cmpResult > 0) {
            parent.setRight(newNode);
        } else {
            parent.setLeft(newNode);
        }
        size++;
        return true;
    }

    public boolean delete(T value) {
        if (root == null) {
            throw new RuntimeException("Tree is Empty");
        }
        TreeNode<T> t = root;
        TreeNode<T> parent = null;
        int cmpResult = 0;
        Comparable<? super T> nodeValue = (Comparable<? super T>) value;
        while (t != null) {
            cmpResult = nodeValue.compareTo(t.getValue());
            if (cmpResult > 0) {
                parent = t;
                t = t.right;
            } else if (cmpResult < 0) {
                parent = t;
                t = t.left;
            } else {
                break;
            }
        }
        if (t != null) {
            if (parent == null) {
                root = null;
                return true;
            }
            if (t.getLeft() == null && t.getRight() == null) {
                if (cmpResult > 0) {
                    parent.setRight(null);
                } else {
                    parent.setLeft(null);
                }
            } else if (t.getLeft() != null && t.getRight() == null) {
                if (cmpResult > 0) {
                    parent.setRight(t.getLeft());
                } else {
                    parent.setLeft(t.getLeft());
                }
            } else if (t.getLeft() == null && t.getRight() != null) {
                if (cmpResult > 0) {
                    parent.setRight(t.getRight());
                } else {
                    parent.setLeft(t.getRight());
                }
            } else if (t.getLeft() != null && t.getRight() != null) {
                //先找到successor
                TreeNode<T> successor = t.getRight();
                TreeNode<T> successorParent = null;
                while (successor.getLeft() != null) {
                    successor = successor.getLeft();
                    successorParent = successor;
                }
                if (cmpResult > 0) {
                    parent.setRight(successor);

                } else {
                    parent.setLeft(successor);
                }
                successorParent.setLeft(successor.getRight());
                successor.setLeft(t.getLeft());
                successor.setRight(t.getRight());
            }
        } else {
            return false;
        }
        return true;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private class TreeNode<T> {
        private TreeNode<T> left;
        private TreeNode<T> right;
        private T value;
        public TreeNode(T value) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
        public TreeNode() {

        }
        public TreeNode(TreeNode<T> left, T value, TreeNode<T> right) {
            this.left = left;
            this.value = value;
            this.right = right;
        }
        public TreeNode<T> getLeft() {
            return left;
        }

        public void setLeft(TreeNode<T> left) {
            this.left = left;
        }

        public TreeNode<T> getRight() {
            return right;
        }

        public void setRight(TreeNode<T> right) {
            this.right = right;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    //递归实现
    public void preOrder(TreeNode<T> root) {
        if (root != null) {
            System.out.print(root.getValue() + " ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    //非递归实现
    public void preOrderNoRecursive(TreeNode<T> root) {
        Stack<TreeNode<T>> stack = new Stack();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.print(root.getValue());
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.getRight();
            }
        }
    }

    //中序遍历递归实现
    public void inOrder(TreeNode<T> root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getValue() + " ");
            inOrder(root.getRight());
        }
    }

    //中序遍历非递归实现
    public void inOrderNoRecursive(TreeNode<T> root) {
        Stack<TreeNode<T>> stack = new Stack();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode<T> node = stack.pop();
                System.out.print(node.getValue() + " ");
                root = node.right;
            }
        }
    }

    public void postOrder(TreeNode<T> node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }

    public void postOrderNoRecursive(TreeNode<T> node) {
        Stack<TreeNode<T>> stack = new Stack();
        TreeNode<T> prev = node;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            if (!stack.isEmpty()) {
                TreeNode<T> temp = stack.peek().getRight();
                if (temp == null || temp == prev) {
                    node = stack.pop();
                    System.out.print(node.getValue() + " ");
                    prev = node;
                    node = null;
                } else {
                    node = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree();
        binaryTree.insert(5);
        binaryTree.insert(3);
        binaryTree.insert(7);
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(6);
        binaryTree.insert(8);
        binaryTree.postOrderNoRecursive(binaryTree.root);
//        binaryTree.postOrder(binaryTree.root);
    }
}
