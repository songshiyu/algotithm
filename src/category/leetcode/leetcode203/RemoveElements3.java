package category.leetcode.leetcode203;

/**
 * @description: 使用递归解决leetcode203
 * @create: 2020/8/13 09:02:51
 **/
public class RemoveElements3 {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return head;
        }

        ListNode res = removeElements(head.next, val);
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ListNode listNode = new ListNode(arr);
        RemoveElements3 removeElements3 = new RemoveElements3();
        ListNode res = removeElements3.removeElements(listNode, 2);
        System.out.println(res);

    }

}
