/**
 * hujiawei 15/5/1
 * <p/>
 * 二叉树
 * <p/>
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRoottoLeafNumbers_129_2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(5);
        System.out.println(new SumRoottoLeafNumbers_129_2().sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) return 0;//空节点
        if (root.left == null && root.right == null) {//叶子节点
            return sum * 10 + root.val;
        }
        return dfs(root.left, sum * 10 + root.val) + dfs(root.right, sum * 10 + root.val);
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
