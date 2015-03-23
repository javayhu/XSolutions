/**
 * hujiawei - 15/3/22.
 * <p/>
 * 排序
 * <p/>
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists_21 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode list = new MergeTwoSortedLists_21().mergeTwoLists(l1, l2);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode list = head;//换另一个指针去移动

        for (; l1 != null || l2 != null; list = list.next) {
            int val1 = l1 != null ? l1.val : Integer.MAX_VALUE;
            int val2 = l2 != null ? l2.val : Integer.MAX_VALUE;
            if (val1 < val2) {
                list.next = l1;
                l1 = l1.next;
            } else {
                list.next = l2;
                l2 = l2.next;
            }
        }
        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
