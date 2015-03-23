import java.util.*;

/**
 * hujiawei - 15/3/22.
 * <p/>
 * 排序
 * <p/>
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergekSortedLists_23 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        List<ListNode> nodeList = new ArrayList<ListNode>();
        nodeList.add(l1);
        nodeList.add(l2);
        ListNode list = new MergekSortedLists_23().mergeKLists(nodeList);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

    // 使用Java内置的优先队列
    // 参考网址:https://leetcode.com/discuss/25518/13-lines-in-java
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() < 1) return null;
        Queue<ListNode> heap = new PriorityQueue(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        ListNode head = new ListNode(0), tail = head;
        // 先把所有的listnode都加入到优先队列中
        for (ListNode node : lists) if (node != null) heap.offer(node);
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            //如果后面的listnode存在就把后面的那个listnode加入到优先队列中
            if (tail.next != null) heap.offer(tail.next);
        }
        return head.next;
    }

    // 复用merge two lists -> 仍然超时
    public ListNode mergeKLists3(List<ListNode> lists) {
        ListNode list = null;
        for (ListNode listNode : lists) {
            list = mergeTwoLists(list, listNode);
        }
        return list;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode list = head;//换另一个指针去移动

        for (; l1 != null || l2 != null; list = list.next) {
            int val1 = l1 != null ? l1.val : Integer.MAX_VALUE;
            int val2 = l2 != null ? l2.val : Integer.MAX_VALUE;
            if (val1 < val2) {
                list.next = l1;
                l1 = l1.next;
            } else {
                list.next = l2;
                l2 = l2.next;
            }
        }
        return head.next;
    }

    // 超时
    public ListNode mergeKLists2(List<ListNode> lists) {
        ListNode head = new ListNode(0);
        ListNode list = head;//换另一个指针去移动
        while (true) {
            int min = Integer.MAX_VALUE, index = 0;
            for (int i = 0, size = lists.size(); i < size; i++) {
                ListNode node = lists.get(i);
                if (node != null && node.val < min) {
                    min = node.val;
                    index = i;
                }
            }
            if (min == Integer.MAX_VALUE) break;//没有node了
            list.next = new ListNode(min);//new node
            lists.set(index, lists.get(index).next);//重新设置这个node，否则它一直指向链表首
            list = list.next;
        }
        return head.next;
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
