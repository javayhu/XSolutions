/**
 * hujiawei 15/4/29
 * <p/>
 * 二叉树
 * <p/>
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree_110 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        System.out.println(new BalancedBinaryTree_110().isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
        //if (root == null) return true;
        //if (!isBalanced(root.left)) return false;
        //if (!isBalanced(root.right)) return false;
        //return Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;//
        int hleft = height(root.left);
        int hright = height(root.right);
        if (hleft < 0 || hright < 0 || Math.abs(hleft - hright) > 1) return -1;
        return Math.max(hleft, hright) + 1;
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
