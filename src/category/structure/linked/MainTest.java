package category.structure.linked;

/**
 * @description: 测试自定义链表
 * @create: 2020/8/10 09:45:36
 * <p>
 **/
public class MainTest {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.remove(3);
        System.out.println(linkedList);

    }
}
