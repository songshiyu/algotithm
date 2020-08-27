package category.leetcode.leetcode203;

/**
 * @description: 
 *   public ListNode removeElements(ListNode head, int val) {
 *
 *         if (head == null){
 *             return head;
 *         }
 *
 *         head.next = removeElements(head.next,val);
 *
 *         return head.val == val ? head.next : head;
 *     }
 * @create: 2020/8/17 08:32:18
 **/
public class RemoveElements5 {
}
