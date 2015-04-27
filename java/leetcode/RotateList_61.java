/**
 * hujiawei 15/4/26
 * <p/>
 * 链表
 * <p/>
 * https://leetcode.com/problems/rotate-list/
 */
public class RotateList_61 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        ListNode node = new RotateList_61().rotateRight(head, 1);
        System.out.println(node.val);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;//[],1
        if (k == 0) return head;//[1],0
        ListNode p = head;
        int len = 1;
        while (p != null && p.next != null) {
            len++;
            p = p.next;
        }
        //System.out.println(len);//2
        p.next = head;//构建成循环链表，p是最后一个节点
        int t = len - k % len;//
        p = head;
        while (t-- > 0) {
            p = p.next;
        }
        //此时p指向了新的head，为了保持原有链表的长度，要将最后节点的next置为null
        ListNode q = p;
        while (--len > 0) {
            q = q.next;
        }
        q.next = null;
        return p;
    }

    //错误解法，因为k可以大于list的长度，但是这个函数在k小于链表长度的时候是没有问题的
    public ListNode rotateRight2(ListNode head, int k) {
        if (k == 0) return head;//
        ListNode fast = head, slow = head;
        while (k-- > 0) {
            fast = fast.next;
        }

        if (fast == null) return head;//k=length(list)
        while (true) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next == null) {//fast到达了最后一个节点，退出循环
                break;
            }
        }
        ListNode t = slow.next;
        slow.next = null;
        fast.next = head;
        return t;
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
