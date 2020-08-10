package category.structure.linked;

/**
 * @description:
 * @create: 2020/8/10 09:33:13
 **/
public class MyLinkedListUp<E> {

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

    /**
     * 设置虚拟的头节点，链表的头部第一个元素值永远为null
     */
    private Node dummyHead;
    private int size;

    public MyLinkedListUp(){
        dummyHead = new Node(null,null);
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
     * 向链表指定位置添加元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed. Illegal index.");
        }

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
       /* Node node = new Node(e);
        node.next = pre.next;
        pre.next = node;*/

        pre.next = new Node(e, pre.next);
        size++;
    }

    /**
     * 向链表首部添加元素
     * */
    public void addFirst(E e){
        add(0,e);
    }
}
