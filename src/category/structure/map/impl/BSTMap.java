package category.structure.map.impl;

import category.structure.map.Map;

/**
 * @description: 基于二分搜索树实现Map
 * @create: 2020/9/10 08:26:53
 **/
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    public class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * 向以node为根的二分搜索树中插入元素(key, value)，递归算法
     * 返回插入新节点后二分搜索树的根
     */
    private Node add(Node node, K key, V value) {

        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        return node;
    }


    @Override
    public V remove(K key) {

        Node node = getNode(root, key);

        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exits");
        }

        root = remove(root, key);

        return node.value;
    }

    public Node remove(Node node, K key) {

        if (node == null) {
            return null;
        }

        if (key.compareTo(node.left.key) < 0) {
            node.left = remove(node.left, key);
        } else if (key.compareTo(node.right.key) > 0) {
            node.right = remove(node.right, key);
        } else {

            //如果目标节点的左子树为空，则该节点的右子树替代其位置
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            //如果目标节点的右子树为空，则该节点的左子树替代其位置
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //若目标节点的左子树和右子树均不为空，则从右子树中选择最小的节点替代目标节点
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
        return null;
    }

    /**
     * 查找一棵二叉树中的最小节点
     */
    public Node minimum(Node node) {

        if (node == null) {
            throw new IllegalArgumentException("BSTTree is empty");
        } else {
            if (node.left == null) {
                return node;
            } else {
                return minimum(node.left);
            }
        }
    }

    /**
     * 移除一棵树中的最小节点
     */
    public Node removeMin(Node node) {

        if (node == null) {
            throw new IllegalArgumentException("");
        } else {

            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            node.left = removeMin(node.left);
            return node;
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            return node.value;
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);

        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exits");
        }

        node.value = value;
    }

    /**
     * 在二分搜索树指定节点下查找key的节点
     */
    public Node getNode(Node node, K key) {

        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else {
            return getNode(node.left, key);
        }
    }
}
