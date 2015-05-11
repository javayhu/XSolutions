/**
 * hujiawei 15/5/1
 * <p/>
 * 二叉树
 * <p/>
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthofBinaryTree_111 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        root.right.right = new TreeNode(3);
        //root.right.right.right = new TreeNode(4);

        System.out.println(new MinimumDepthofBinaryTree_111().minDepth(root));
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int dleft = Integer.MAX_VALUE, dright = Integer.MAX_VALUE;
        if (root.left != null) {
            dleft = minDepth(root.left);
        }
        if (root.right != null) {
            dright = minDepth(root.right);
        }
        return Math.min(dleft, dright) + 1;
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
