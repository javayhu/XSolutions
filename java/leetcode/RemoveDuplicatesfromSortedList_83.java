/**
 * hujiawei 15/4/26
 * <p/>
 * 链表
 * <p/>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesfromSortedList_83 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode node = new RemoveDuplicatesfromSortedList_83().deleteDuplicates(head);
        System.out.println(node.val);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode pre = head, cur = pre.next, next = cur.next;
        while (cur != null) {
            if (cur.val == pre.val) {
                pre.next = next;
                cur = next;
                next = cur != null ? cur.next : null;
            } else {
                pre = cur;
                cur = next;
                next = cur != null ? cur.next : null;
            }
        }
        return head;
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
