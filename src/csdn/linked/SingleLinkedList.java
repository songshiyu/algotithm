package csdn.linked;

/**
 * @description: 单链表
 * @create: 2021/3/9 08:43:56
 **/
public class SingleLinkedList<E> {

    private class Node {
        private E e;
        private Node next;

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

    public SingleLinkedList(E e) {
        head = new Node(e);
        size = 1;
    }

    public SingleLinkedList() {
        head = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        Node node = new Node(e);
        node.next = head;
        head = node;
        size++;
    }

    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new RuntimeException("index is Illegal");
        }

        if (index == 0) {
            addFirst(e);
        } else {
            Node pre = head;
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
            Node node = new Node(e);
            node.next = pre.next;
            pre.next = node;
            size++;
        }
    }

    public void addLast(E e) {
        add(size, e);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node node = head;
        for (int i = 0; i < getSize(); i++) {
            builder.append(node.e);
            node = node.next;
            if (i != getSize() - 1) {
                builder.append(",");
            }
        }
        return builder.toString();
    }
}
