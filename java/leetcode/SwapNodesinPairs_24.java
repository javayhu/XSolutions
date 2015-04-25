/**
 * hujiawei 15/4/25
 * <p/>
 * 链表
 * <p/>
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesinPairs_24 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        //head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        ListNode node = new SwapNodesinPairs_24().swapPairs(head);
        System.out.println(node.val);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode node = new ListNode(-1);
        node.next = head;

        ListNode pre, cur, next;
        for (pre = node, cur = node.next, next = cur.next; next != null;
             pre = cur, cur = cur.next, next = cur != null ? cur.next : null) {
            pre.next = next;
            cur.next = next.next;
            next.next = cur;
        }

        return node.next;//not head
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
