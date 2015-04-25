/**
 * hujiawei 15/4/24
 * <p/>
 * 链表
 * <p/>
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemovNthNodeFromEndofList_19 {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        //head.next = new ListNode(1);
        //head.next.next = new ListNode(2);
        //head.next.next.next = new ListNode(3);
        ListNode node = new RemovNthNodeFromEndofList_19().removeNthFromEnd(head, 1);
        //System.out.println(node.val);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, q = head;
        while (n-- > 0) {
            q = q.next;
        }
        if (q == null) {//特殊情况，例如{1}删除倒数第一个，{1,2}删除倒数第二个，其实都是说明要删除链表头结点
            return p.next;//因为题目说明了n一定是合法的
        }
        while (true) {
            if (q.next == null) {//q到了最后那个节点
                p.next = p.next.next;
                return head;
            } else {
                p = p.next;
                q = q.next;
            }
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
