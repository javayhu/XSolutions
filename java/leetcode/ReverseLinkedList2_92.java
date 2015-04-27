/**
 * hujiawei 15/4/26
 * <p/>
 * 链表
 * <p/>
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedList2_92 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(new ReverseLinkedList2_92().reverseBetween(head, 2, 4));
        System.out.println(head.val);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode node = new ListNode(0);
        node.next = head;

        ListNode before = node, start = head, end = head, after = head;
        int k = n - m;
        while (k-- > 0) {//一开始就让start和end相隔n-m个距离
            end = end.next;
        }
        //System.out.println(start.val+" "+end.val);//
        while (--m > 0) {//然后再让所有指针向后移动m-1次
            before = before.next;
            start = start.next;
            end = end.next;
        }
        after = end.next;//里面随便移动，after最终是等于end的下一个节点
        //System.out.println(start.val + " " + end.val);
        //start是第m个节点，before和after分别是它前面和后面的一个节点s
        //然后开始反转从start到end这部分的链表节点，最后和before和after链接起来就可以了
        ListNode cur = start, next = start.next, tmp;
        while (cur != end) {
            tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
        }
        before.next = end;
        start.next = after;

        return node.next;
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
