package csdn.linked;

/**
 * @description: 单链表-使用虚拟头节点
 * @create: 2021/3/9 08:43:56
 **/
public class SingleLinkedList2<E> {

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

    private Node dummyHead;
    private int size;

    public SingleLinkedList2() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new RuntimeException("index is Illegal");
        }

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node node = new Node(e);
        node.next = pre.next;
        pre.next = node;
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E getNode(int index) {

        if (index < 0 || index >= size) {
            throw new RuntimeException("get node faild,index is illegal");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node resNode = pre.next;
        return resNode.e;
    }

    public E getFirst() {
        return getNode(0);
    }

    public E getLast() {
        return getNode(size - 1);
    }

    public void delNode(int index) {

        if (index < 0 || index >= size) {
            throw new RuntimeException("del node faild,index is illegal");
        }

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node delNode = pre.next;
        pre.next = delNode.next;
        delNode = null;
    }

    public void delElement(E e) {
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.e.equals(e)) {
                break;
            }
            pre = pre.next;
        }
        Node delNode = pre.next;
        pre.next = delNode.next;
        delNode = null;
    }

    //TODO 翻转列表
    public SingleLinkedList2 reversal() {

        return null;
    }

    public E setNode(int index, E e) {

        if (index < 0 || index >= size) {
            throw new RuntimeException("set node faild,index is illegal");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        Node resNode = pre.next;
        E result = resNode.e;
        resNode.e = e;
        return result;
    }

    public boolean contains(E e) {
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.e.equals(e)) {
                return true;
            }
            pre = pre.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node cur = dummyHead;
        while (cur.next != null) {
            builder.append(cur.next.e).append("->");
            cur = cur.next;
        }
        return builder.toString();
    }
}
