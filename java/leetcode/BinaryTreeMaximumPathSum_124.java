/**
 * hujiawei 15/5/1
 * <p/>
 * 二叉树
 * <p/>
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum_124 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        System.out.println(new BinaryTreeMaximumPathSum_124().maxPathSum(root));
    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }

    private int maxSum(TreeNode root) {
        if (root == null) return 0;

        int tmax = root.val;//tmax是记录如果以当前节点root为中心加上左右子树的maxpathsum的最大值
        int maxLeft = maxSum(root.left);
        if (maxLeft > 0) tmax += maxLeft;
        int maxRight = maxSum(root.right);
        if (maxRight > 0) tmax += maxRight;
        //System.out.println("val=" + root.val + " left=" + maxLeft + " right=" + maxRight + " tmax=" + tmax);

        max = Math.max(max, tmax);//如果上面的情况大于最大值，那么更新最大值
        return Math.max(maxLeft, maxRight) > 0 ? Math.max(maxLeft, maxRight) + root.val : root.val;
        //返回时只能返回其中某个分支加上root.val
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
