/**
 * hujiawei 15/4/26
 * <p/>
 * 链表
 * <p/>
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycle2_142 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cycle = new ListNode(10);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = cycle;
        cycle.next = head;
        //System.out.println(new LinkedListCycle2_142().hasCycle(head));
        System.out.println(new LinkedListCycle2_142().detectCycle(head));
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {//区别在于这里，此时快慢指针相遇了，说明存在环，但是相遇点不一定是环入口
                //但是通过分析可知，如果这个时候从链表头部开始移动一个慢指针，两个慢指针的相遇点就是环入口
                ListNode slow2 = head;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow2;//
            }
        }
        return null;
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
