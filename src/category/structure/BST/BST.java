package category.structure.BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
     * 通过模拟系统栈的方式实现二叉树的前序遍历
     */
    public void preOrderNR() {

        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.e);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

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
     * 二分搜索树的层序遍历（广度优先遍历）
     */
    public void levelOrder() {

        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null) {
                queue.add(cur.left);
            }

            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }


    /**
     * 查找二分搜索树中的最小值（递归方式）
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        Node minimum = minimum(root);
        return minimum.e;
    }

    private Node minimum(Node node) {

        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    /**
     * 查找二分搜索树中的最小值（非递归方式）
     */
    public E minimumNR() {

        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        Node cur = root;

        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.e;
    }


    /**
     * 查找二分搜索树中的最大值（递归方式）
     */
    public E maxMem() {

        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        Node maxMem = maxMem(root);
        return maxMem.e;
    }

    private Node maxMem(Node node) {

        if (node.right == null) {
            return node;
        }

        return maxMem(node.right);
    }

    /**
     * 查找二分搜索树中的最大值（非递归方式）
     */
    public E maxMemNR() {

        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        Node cur = root;

        while (cur.right != null) {
            cur = cur.right;
        }
        return cur.e;
    }

    /**
     * 移除二分搜索树中最小元素(递归方式)
     */
    public E removeMin() {
        E min = minimum();
        root = removeMin(root);
        return min;
    }

    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 移除二分搜索树中的最小元素(非递归方式)
     */
    public E removeMinNR() {

        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        Node cur = root;
        Node preCur = null;
        Node rightNode = null;

        while (cur.left != null) {
            preCur = cur;
            cur = cur.left;
            rightNode = cur.right;
        }

        preCur.left = rightNode;
        cur.right = null;

        return cur.e;
    }

    /**
     * 移除二分搜索树中的最大元素(递归实现方式)
     */
    public E removeMax() {
        E maxMem = maxMem();
        root = removeMax(root);
        return maxMem;
    }

    private Node removeMax(Node node) {

        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 移除二分搜索树中的最大元素(非递归实现方式)
     */
    public E removeMaxNR() {

        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        Node preCur = null;
        Node cur = root;
        Node leftNode = null;

        while (cur.right != null) {
            preCur = cur;
            cur = cur.right;
            leftNode = cur.left;
        }

        preCur.right = leftNode;
        cur.left = null;
        return cur.e;
    }

    /**
     * 移除二分搜索树中值为E的元素
     */
    public void removeEle(E e) {
        root = removeEle(root, e);
    }

    private Node removeEle(Node node, E e) {

        if (node == null) {
            throw new IllegalArgumentException("BST is empty");
        }

        if (e.compareTo(node.e) > 0) {
            node.right = removeEle(node.right, e);
            return node;
        } else if (e.compareTo(node.e) < 0) {
            node.left = removeEle(node.left, e);
            return node;
        } else { //e.compareTo(node.e) == 0

            //若待删除节点的左孩子为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            //若待删除节点的右孩子为空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //若待删除节点的左孩子和右孩子都不为空
            //找到比待删除节点大的最小界定，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            Node targetNode = minimum(node.right);
            targetNode.right = removeMin(node.right);
            targetNode.left = node.left;

            node.left = node.right = null;
            return targetNode;
        }
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
