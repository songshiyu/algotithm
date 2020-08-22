package category.leetcode.leetcode203;

/**
 * @description:
 * @create: 2020/8/12 09:39:05
 **/
public class RemoveElements1 {

    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val){
           head = head.next;
        }

        if (head == null){
            return null;
        }

        ListNode prev = head;
        while (prev.next != null){
            if (prev.next.val == val){
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }

        return head;
    }
}
