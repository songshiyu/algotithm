package category.leetcode.leetcode203;


import com.sun.jmx.snmp.SnmpNull;

/**
 * @description:
 * @create: 2020/8/12 09:38:24
 **/
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr) {

        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("array is empty");
        }

        this.val = arr[0];
        ListNode cur = this;

        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();

        ListNode cur = this;
        while (cur != null) {
            res.append(cur.val + "-->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
    }
}
