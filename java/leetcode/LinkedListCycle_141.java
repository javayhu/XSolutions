/**
 * hujiawei 15/4/26
 * <p/>
 * 链表
 * <p/>
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle_141 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cycle = new ListNode(10);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = cycle;
        //cycle.next = head;
        System.out.println(new LinkedListCycle_141().hasCycle(head));
    }

    //判断链表中是否存在环，简单方法使用HashMap记录访问的节点，高效方法使用快慢指针
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
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
