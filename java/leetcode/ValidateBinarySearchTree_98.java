/**
 * hujiawei 15/5/1
 * <p/>
 * 二叉树
 * <p/>
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree_98 {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);

        System.out.println(new ValidateBinarySearchTree_98().isValidBST(root));
    }

    //2147483647
    //参考: https://leetcode.com/discuss/31562/simple-java-solution
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;
        else if ((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;
        else
            return helper(root.left, min, root.val) && helper(root.right, root.val, max);
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
