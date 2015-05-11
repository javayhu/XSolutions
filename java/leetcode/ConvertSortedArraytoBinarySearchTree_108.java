/**
 * hujiawei 15/5/1
 * <p/>
 * 二叉树
 * <p/>
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConvertSortedArraytoBinarySearchTree_108 {

    //convert it to a height balanced BST
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) return null;
        if (num.length == 1) return new TreeNode(num[0]);
        return sortedArrayToBST(num, 0, num.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] num, int s, int t) {
        if (s > t) return null;
        if (s == t) return new TreeNode(num[s]);
        int m = (s + t) / 2;
        TreeNode node = new TreeNode(num[m]);
        node.left = sortedArrayToBST(num, s, m - 1);
        node.right = sortedArrayToBST(num, m + 1, t);
        return node;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
