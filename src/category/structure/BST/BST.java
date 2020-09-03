package category.structure.BST;

/**
 * @description: 二分搜索树
 * @create: 2020/9/3 08:48:47
 **/
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node right;
        public Node left;

        public Node(E e) {
            this.e = e;
            this.right = null;
            this.left = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int Size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {

        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    private void add(Node root, E e) {

        if (root.e.equals(e)) {
            return;
        } else if (e.compareTo(root.e) > 0 && root.right == null) {
            root.right = new Node(e);
            size++;
            return;
        } else if (e.compareTo(root.e) < 0 && root.left == null) {
            root.left = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(root.e) > 0) {
            add(root.right, e);
        } else {
            add(root.left, e);
        }
    }
}