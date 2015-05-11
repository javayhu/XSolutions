import java.util.ArrayList;
import java.util.List;

/**
 * hujiawei 15/5/1
 * <p/>
 * 二叉树
 * <p/>
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ConvertSortedListtoBinarySearchTree_109 {

    public static void main(String[] args) {

    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        List<Integer> list = new ArrayList<Integer>();
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        Integer[] num = new Integer[list.size()];
        list.toArray(num);
        return sortedArrayToBST(num);
    }

    public TreeNode sortedArrayToBST(Integer[] num) {
        if (num == null || num.length == 0) return null;
        if (num.length == 1) return new TreeNode(num[0]);
        return sortedArrayToBST(num, 0, num.length - 1);
    }

    private TreeNode sortedArrayToBST(Integer[] num, int s, int t) {
        if (s > t) return null;
        if (s == t) return new TreeNode(num[s]);
        int m = (s + t) / 2;
        TreeNode node = new TreeNode(num[m]);
        node.left = sortedArrayToBST(num, s, m - 1);
        node.right = sortedArrayToBST(num, m + 1, t);
        return node;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
