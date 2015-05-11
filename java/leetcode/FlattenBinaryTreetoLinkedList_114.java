/**
 * hujiawei 15/5/1
 * <p/>
 * 二叉树
 * <p/>
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreetoLinkedList_114 {

    public void flatten(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            TreeNode leftNode = root.left;
            TreeNode rightNode = root.right;

            root.left = null;
            root.right = leftNode;

            TreeNode p = leftNode;
            while (p.right != null) {//找到左子树的最右边的节点，把它链接到root的右子树
                p = p.right;
            }
            p.right = rightNode;
        }
        flatten(root.right);//如果root.left!=null那么这里实际上是递归左子树
        //如果root.left==null那么这里实际上是递归右子树
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
