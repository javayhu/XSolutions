/**
 * hujiawei 15/4/27
 * <p/>
 * 链表
 * <p/>
 * https://leetcode.com/problems/partition-list/
 */
public class PartitionList_86 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode node = new PartitionList_86().partition(head, 3);
        System.out.println(node.val);
    }

    //Given 1->4->3->2->5->2 and x = 3,
    //return 1->2->2->4->3->5
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode node = new ListNode(0);
        node.next = head;

        ListNode slow = node, fast = head, aFast = fast.next, bFast = node;//
        //慢指针slow是用来记录小于x的位置，出现一个小于x的数字就放在它的后面即可
        //快指针fast是用来找到小于x的节点，对于大于等于x的节点不用考虑
        //aFast是fast指针的后一个节点，bFast是fast指针前一个节点 -> [bFast][fast][aFast]
        while (fast != null) {
            if (fast.val >= x) {
                bFast = fast;
                fast = aFast;
                aFast = fast != null ? fast.next : null;
            } else {
                if (fast.val < x && slow.next == fast) {//这是种特殊情况
                    slow = slow.next;
                    bFast = fast;
                    fast = aFast;
                    aFast = fast != null ? fast.next : null;
                } else {
                    //下面以遇到第一个2为例子
                    bFast.next = aFast;//3->5
                    fast.next = slow.next;//2->4
                    slow.next = fast;//1->2
                    fast = aFast;//fast->5
                    slow = slow.next;//slow->2
                    aFast = fast != null ? fast.next : null;//bFast不变，aFast变为fast的后面一个节点
                }
            }
        }
        return node.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
