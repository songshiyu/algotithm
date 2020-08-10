package category.structure.linked;

/**
 * @description: 没有设置虚拟的头节点，此时在向链表中添加元素时，需要考虑向首部添加元素的特殊情况
 * @create: 2020/8/10 08:35:20
 * <p>
 **/
public class MyLinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * 获取链表元素个数
     */
    public int getSize() {
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
    public void addFirst(E e) {
       /* Node node = new Node(e);
        node.next = head;
        head.next = node;*/

        head = new Node(e, head);
        size++;
    }

    /**
     * 向链表指定位置添加元素
     * 此方法在链表中不是一个常用操作
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        if (index == 0) {
            addFirst(e);
        } else {
            Node pre = head;

            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }

           /* Node node = new Node(e);
            node.next = pre.next;
            pre.next = node;*/
            pre.next = new Node(e, pre.next);
            size++;
        }
    }
}
