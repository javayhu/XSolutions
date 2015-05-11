/**
 * hujiawei 15/5/1
 * <p/>
 * 二叉树
 * <p/>
 * https://leetcode.com/problems/path-sum/
 */
public class PathSum_112 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        System.out.println(new PathSum_112().hasPathSum(root, 10));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;//空节点
        if (root.left == null && root.right == null) return sum == root.val;//叶子节点
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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
