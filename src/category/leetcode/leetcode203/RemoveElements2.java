package category.leetcode.leetcode203;

/**
 * @description: 设置虚拟头节点的方式解决
 * @create: 2020/8/12 10:01:30
 **/
public class RemoveElements2 {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return dummyNode.next;
    }
}
