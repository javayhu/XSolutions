/**
 * hujiawei 15/4/25
 * <p/>
 * 链表
 * <p/>
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesinkGroup_25 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        ListNode node = new ReverseNodesinkGroup_25().reverseKGroup(head, 2);
        System.out.println(node.val);
    }

    //参考：http://www.acmerblog.com/leetcode-solution-reverse-nodes-in-k-group-6243.html
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode node = new ListNode(-1);
        node.next = head;

        ListNode before, start, end, after;// [x x before][start x end][after x x]
        for (before = node, start = head, end = head, after = head; end != null; ) {
            int t = k;
            while (--t > 0 && end != null) {
                end = end.next;
            }
            if (end == null) {//不够k个不用处理了
                break;
            }
            //足够k个要进行一次反转
            after = end.next;
            before = reverser(before, start, end, after);
            start = before.next;
            end = start;
        }

        return node.next;
    }

    //反转链表闭区间start到end，before是start前面一个节点，after是end后面一个节点
    private ListNode reverser(ListNode before, ListNode start, ListNode end, ListNode after) {
        ListNode pre, cur, next;//[pre cur next] 遍历链表每次将cur.next改为pre
        for (pre = start, cur = start.next, next = cur.next; cur != after && cur != null;
             pre = cur, cur = next, next = next != null ? next.next : null) {
            cur.next = pre;
        }
        before.next = end;
        start.next = after;

        return start;//返回反转后的链表的最后一个元素
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
