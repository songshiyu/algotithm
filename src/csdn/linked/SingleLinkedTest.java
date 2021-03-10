package csdn.linked;

/**
 * @description:
 * @create: 2021/3/9 09:36:59
 **/
public class SingleLinkedTest {

    public static void main(String[] args) {
        /*SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addLast(i);
        }
        System.out.println(linkedList);

        linkedList.addFirst(10);
        System.out.println(linkedList);

        linkedList.add(3,11);
        System.out.println(linkedList);*/

        SingleLinkedList2<Integer> list2 = new SingleLinkedList2();
        for (int i = 0; i < 5; i++) {
            list2.addLast(i);
        }
        System.out.println(list2);
        list2.addFirst(5);
        System.out.println(list2);

        System.out.println(list2.getNode(5));
        System.out.println(list2.contains(67));

        list2.delElement(5);
        System.out.println(list2);

        list2.delElement(3);
        System.out.println(list2);
    }
}
