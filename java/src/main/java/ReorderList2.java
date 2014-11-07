/**
 * hujiawei - 10/19/14.
 */

//https://oj.leetcode.com/problems/reorder-list/

//改进原来的版本，首先使用快慢指针得到列表的后半部分然后反转过来，接着和前半部分进行合并得到新列表

public class ReorderList2 {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        new ReorderList2().reorderList(head);
    }

    public void reorderList(ListNode head) {
        if (null == head || null == head.next || null == head.next.next) return;
        ListNode first = head, second;
        ListNode slow = head;
        ListNode fast = head.next.next;

        //slow-fast pointer to locate the middle of the list
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next != null) {
            slow = slow.next;
        }
        second = slow.next;//start the second list
        slow.next = null;//set to null, end the first list
        //reverse the second list
        second = reverse(second);
        ListNode p = first, q = second, t1, t2;

        while (p != null) {
            t1 = p.next;
            t2 = q.next;
            p.next = q;
            p = t1;
            if (t1!=null){//if t1 is null, do not do this!
                q.next = t1;
                q = t2;
            }
        }
        //while(head!=null){//for test
        //    System.out.println(head.val);
        //    head = head.next;
        //}
    }

    // reverse the original list, return original list
    public ListNode reverse(ListNode head) {
        ListNode p = head;
        ListNode q = head.next;
        ListNode t = null;
        while (q != null) {
            t = q.next;
            q.next = p;
            p = q;
            q = t;
        }
        head.next = null;//make the first to be the last
        return p;
    }

}
