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

    /**
     * 递归的方式向二叉搜索树中添加元素
     */
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node root, E e) {
        if (root == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(root.e) > 0) {
            root.right = add(root.right, e);
        } else if (e.compareTo(root.e) < 0) {
            root.left = add(root.left, e);
        }
        return root;
    }

    /**
     * 非递归方式向二叉搜索树中插入元素
     */
    public void addNotR(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            Node cur = root;

            while (cur != null) {
                if (cur.e.equals(e)) {
                    return;
                } else if (e.compareTo(cur.e) > 0 && cur.right == null) {
                    cur.right = new Node(e);
                    size++;
                    return;
                } else if (e.compareTo(cur.e) < 0 && cur.left == null) {
                    cur.left = new Node(e);
                    size++;
                    return;
                }
                if (e.compareTo(cur.e) > 0) {
                    cur = cur.right;
                } else {
                    cur = cur.left;
                }
            }
        }
    }

    /**
     * 通过递归的方式判断二分搜索树中是否包含某个元素
     */
    public boolean contains(E target) {
        return contains(root, target);
    }

    private boolean contains(Node node, E target) {

        if (node == null) {
            return false;
        }

        if (node.e.equals(target)) {
            return true;
        } else if (target.compareTo(node.e) > 0) {
            return contains(node.right, target);
        } else {
            return contains(node.left, target);
        }
    }


    /**
     * 二分搜索树的前序遍历 -- 以根节点为起点，先遍历根节点，然后遍历左子树，最后遍历右子树
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二分搜索树的中序遍历 -- 以根节点的左子树为起点，先遍历左子树，然后根节点，最后右子树
     */
    public void midOrder() {
        midOrder(root);
    }

    private void midOrder(Node node) {

        if (node == null) {
            return;
        }

        midOrder(node.left);
        System.out.println(node.e);
        midOrder(node.right);

    }

    /**
     * 二分搜索树的后序遍历 -- 以根节点的左子树为起点，先遍历左子树，然后遍历右子树，最后是根节点
     */
    public void lastOrder() {
        lastOrder(root);
    }

    private void lastOrder(Node node) {

        if (node == null) {
            return;
        }

        lastOrder(node.left);
        lastOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 基于二分搜索树前序遍历的toString方法
     */
    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuffer res) {

        if (node == null) {
            res.append(generateDepthString(depth)).append("null").append("\n");
            return;
        }

        res.append(generateDepthString(depth)).append(node.e).append("\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }


}
