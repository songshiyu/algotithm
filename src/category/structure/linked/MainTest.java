package category.structure.linked;

/**
 * @description: 测试自定义链表
 * @create: 2020/8/10 09:45:36
 * <p>
 **/
public class MainTest {

    public static void main(String[] args) {
        MyLinkedListUp linkedList = new MyLinkedListUp();

        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
        }

        linkedList.add(0,5);

        System.out.println(linkedList);

    }
}
