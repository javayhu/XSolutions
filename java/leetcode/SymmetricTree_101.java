/**
 * hujiawei 15/5/1
 * <p/>
 * 二叉树
 * <p/>
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree_101 {

    public static void main(String[] args){
        test2();
    }

    private static void test2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = null;
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(3);
        root.right.right = null;

        System.out.println(new SymmetricTree_101().isSymmetric(root));
    }

    private static void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        System.out.println(new SymmetricTree_101().isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;//都是空节点
        //都不是空节点而且值相同，递归比较它们的左右子树
        if (left != null && right != null && left.val == right.val) {
            //注意这里的比较，本题是判断二叉树对称，左右子树相同不一定是对称
            return isSame(left.left, right.right) && isSame(left.right, right.left);
        }
        return false;
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
