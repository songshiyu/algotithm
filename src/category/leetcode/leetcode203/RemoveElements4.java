package category.leetcode.leetcode203;

/**
 * @description: 优化使用递归解决leetcode203
 * @create: 2020/8/13 10:53:35
 **/
public class RemoveElements4 {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null){
            return head;
        }

        head.next = removeElements(head.next,val);

        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ListNode listNode = new ListNode(arr);
        RemoveElements4 removeElements4 = new RemoveElements4();
        ListNode res = removeElements4.removeElements(listNode, 2);
        System.out.println(res);

    }
}
