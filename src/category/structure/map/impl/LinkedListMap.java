package category.structure.map.impl;

import category.structure.map.Map;
import util.FileOperation;

import java.util.ArrayList;

/**
 * @description: 基于链表实现的Map
 * @create: 2020/9/9 09:33:01
 **/
public class LinkedListMap<K, V> implements Map<K, V> {

    public class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ":" + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);

        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {

        Node pre = dummyHead;

        while (pre.next != null) {
            if (pre.next.key.equals(key)) {
                break;
            }
            pre = pre.next;
        }

        if (pre.next != null) {
            Node removeNode = pre.next;
            pre.next = removeNode.next;
            removeNode.next = null;
            size--;
            return removeNode.value;
        }

        return null;
    }

    @Override
    public boolean contains(K key) {
        Node node = getNode(key);
        return node != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
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
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        } else {
            node.value = newValue;
        }
    }

    private Node getNode(K key) {

        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();

        ArrayList<String> words = new ArrayList<>();

        if (FileOperation.readFile("/Users/songshiyu/data/algorithm/test1", words)) {
            System.out.println("Total words：" + words.size());

            for (String word : words) {
                if (linkedListMap.get(word) != null) {
                    linkedListMap.add(word, linkedListMap.get(word) + 1);
                } else {
                    linkedListMap.add(word, 1);
                }
            }
            System.out.println("Total different words: " + linkedListMap.size);
            System.out.println("online: " + linkedListMap.get("online"));
        }
    }
}
