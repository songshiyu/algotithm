package csdn.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 特使链表-环形链表
 * @create: 2021/3/11 08:07:50
 **/
public class CircleLinkedList<E> {

    private class Node<E> {
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

    private Node head = null;
    private Node tail = null;

    public CircleLinkedList(int nums) {
        if (nums < 1) {
            throw new RuntimeException("nums < 1");
        }

        for (int i = 1; i <= nums; i++) {
            Node node = new Node(i);
            if (i == 1) {
                head = node;
                head.next = head;
                tail = head;
            } else {
                tail.next = node;
                node.next = head;
                tail = node;
            }
        }
    }

    public CircleLinkedList() {
        this(5);
    }

    /**
     * 利用环形链表实现约瑟夫问题
     *
     * @param startNo  从第几个开始数
     * @param countNum 数几下
     * @param nums     链表的初始容量
     */
    public void exitCircle(int startNo, int countNum, int nums) {
        //1.进行参数校验
        if (head == null || startNo < 1 || startNo > nums) {
            throw new RuntimeException("参数非法");
        }
        //2.根据startNo对环形链表的head和tail进行初始化
        for (int i = 1; i < startNo - 1; i++) {
            head = head.next;
            tail = tail.next;
        }
        //3.开始进行出圈操作
        while (true) {
            //当head和tail相等时，证明环形链表中只剩下了一个元素
            if (head == tail) {
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                head = head.next;
                tail = tail.next;
            }
            System.out.println("元素：" + head.e + "出圈");
            head = head.next;
            tail.next = head;
        }
        System.out.println("环形链表中剩余元素：" + head.e);
    }

    /**
     * 使用List实现约瑟夫问题
     *
     * @param start
     * @param count
     * @param total
     */
    public static void yueSeFu(int start, int count, int total) {

        if (total < 0 || start < 1 || count > total) {
            throw new RuntimeException("参数错误！");
        }

        List<String> list = new ArrayList<>();
        for (int i = 1; i <= total; i++) {
            list.add("person" + i);
        }

        int actualCount = count - 1;
        int startIndex = start - 1;
        while (list.size() > 1) {
            startIndex = (startIndex + actualCount) % list.size();
            System.out.println("元素：" + list.get(startIndex) + "需要被移除");
            list.remove(startIndex);
        }
        System.out.println("集合中剩余：" + list.get(0));
    }

    public static void main(String[] args) {
        CircleLinkedList<Integer> circleLinkedList = new CircleLinkedList<>();
        circleLinkedList.exitCircle(1, 2, 5);

        yueSeFu(1, 2, 5);
    }
}
