import java.util.ArrayList;
import java.util.List;

/**
 * hujiawei 15/5/1
 * <p/>
 * 二叉树
 * <p/>
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal_94 {

    public static void main(String[] args) {
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

        System.out.println(new BinaryTreeInorderTraversal_94().inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        inorder(result, root);
        return result;
    }

    private void inorder(List<Integer> result, TreeNode root) {
        if (root.left != null) inorder(result, root.left);
        result.add(root.val);
        if (root.right != null) inorder(result, root.right);
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
