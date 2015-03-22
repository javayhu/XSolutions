
//https://oj.leetcode.com/problems/reorder-list/

//就地对列表进行重新排列，首先反转列表得到一个新列表，然后结合两个列表就行了

public class ReorderList_143 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        new ReorderList_143().reorderList(head);
    }

    public void reorderList(ListNode head) {
        if (null==head || null == head.next || null == head.next.next) return;
        ListNode rhead = reverseList(head);
        int len = 0, l = 1;
        ListNode p = head, q = rhead;
        ListNode t1 = null, t2 = null;
        while (p != null) {//get list length
            p = p.next;
            len++;
        }
        p = head;
        while (l <= len / 2) {//only len/2 elements need to move
            t1 = p.next;
            t2 = q.next;
            p.next = q;
            q.next = t1;
            p = t1;
            q = t2;
            l++;
        }
        l = 1;
        p = head;
        while (p != null && l < len) {//get first len elements
            p = p.next;
            l++;
        }
        p.next = null;//make it end here!
    }

    // reverse the original list
    public ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode r = new ListNode(p.val);
        while (null != p.next) {
            p = p.next;
            ListNode node = new ListNode(p.val);
            node.next = r;
            r = node;
        }
        return r;
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

