/**
 * hujiawei 15/5/1
 * <p/>
 * 二叉树
 * <p/>
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthofBinaryTree_104 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        System.out.println(new MaximumDepthofBinaryTree_104().maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int dleft = Integer.MIN_VALUE, dright = Integer.MIN_VALUE;
        if (root.left != null) {
            dleft = maxDepth(root.left);
        }
        if (root.right != null) {
            dright = maxDepth(root.right);
        }
        return Math.max(dleft, dright) + 1;
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
