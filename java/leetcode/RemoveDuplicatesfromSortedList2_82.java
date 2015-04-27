/**
 * hujiawei 15/4/26
 * <p/>
 * 链表
 * <p/>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesfromSortedList2_82 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode node = new RemoveDuplicatesfromSortedList2_82().deleteDuplicates(head);
        System.out.println(node.val);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //lastVal不能是随便一个不同于head的val值，int lastVal = 0==head?1:0; 错误，可能和后面的数字相同
        //根据惯例，链表中的val一定不会是负数，int lastVal =-1，错误，有可能是-1
        int lastVal = Integer.MIN_VALUE;
        ListNode pre = dummy, cur = head, next = cur.next;
        while (cur != null) {
            //以下两种情况下要删除cur
            // 虽然第二种情况next也需要删除，但是留到各个指针移动了之后再删除
            // 第一种情况不能使用判断条件pre != dummy&& cur.val == lastVal，例如[1,1]
            if ((cur.val == lastVal) || (next != null && cur.val == next.val)) {
                lastVal = cur.val;
                pre.next = next;
                cur = next;
                next = cur != null ? cur.next : null;
            } else {
                pre = cur;
                cur = next;
                next = cur != null ? cur.next : null;
            }
        }
        return dummy.next;
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
