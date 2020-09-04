package category.structure.linked;

/**
 * @description: 使用递归实现一个链表
 * @create: 2020/8/17 08:27:23
 **/
public class LinkedListRecursion<E> {

    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    private Node head;
    private int size;

    public LinkedListRecursion() {
        this.head = null;
        this.size = 0;
    }

    /**
     * 获取链表元素个数
     */
    public int size() {
        return size;
    }

    /**
     * 判断链表是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向链表首部添加元素
     */
    public void addHead(E e) {
        head = new Node(e, head);
        size++;
    }

    /**
     * 向链表指定位置添加元素
     * 此方法在链表中不是一个常用操作
     */
    public void add(int index, E e) {

    }

}
