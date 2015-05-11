/**
 * hujiawei 15/5/2
 * <p/>
 * 二叉树
 * <p/>
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {

    public static void main(String[] args) {
        int[] preorder = new int[]{1, 2, 4, 3, 5};
        int[] inorder = new int[]{4, 2, 1, 3, 5};
        TreeNode root = new ConstructBinaryTreefromPreorderandInorderTraversal_105().buildTree(preorder, inorder);
        System.out.println(root.val);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);

        int v = preorder[0], i = 0, len = preorder.length;//preorder的第一个元素是根
        for (; i < inorder.length; i++) {
            if (inorder[i] == v) {
                break;
            }
        }
        //System.out.println("i=" + i);//i=2

        //inorder的[0,i-1]个数字是左子树 0,1,2
        int[] leftPreorder = new int[i];
        int[] leftInorder = new int[i];
        System.arraycopy(preorder, 1, leftPreorder, 0, i);//i-1+1
        System.arraycopy(inorder, 0, leftInorder, 0, i);

        int[] rightPreorder = new int[len - i - 1];
        int[] rightInorder = new int[len - i - 1];
        System.arraycopy(preorder, i + 1, rightPreorder, 0, len - i - 1);//
        System.arraycopy(inorder, i + 1, rightInorder, 0, len - i - 1);

        //System.out.println(Arrays.toString(leftPreorder));
        //System.out.println(Arrays.toString(leftInorder));
        //System.out.println(Arrays.toString(rightPreorder));
        //System.out.println(Arrays.toString(rightInorder));

        TreeNode root = new TreeNode(preorder[0]);
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
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
