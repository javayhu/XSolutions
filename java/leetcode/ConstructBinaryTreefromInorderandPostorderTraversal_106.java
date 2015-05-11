/**
 * hujiawei 15/5/2
 * <p/>
 * 二叉树
 * <p/>
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal_106 {

    public static void main(String[] args) {
        //int[] preorder = new int[]{1, 2, 4, 3, 5};
        //int[] inorder = new int[]{4, 2, 1, 3, 5};
        //int[] postorder = new int[]{4, 2, 5, 3, 1};

        int[] inorder = new int[]{1, 2, 3, 4, 5};
        int[] postorder = new int[]{4, 5, 3, 2, 1};

        TreeNode root = new ConstructBinaryTreefromInorderandPostorderTraversal_106().buildTree(inorder, postorder);
        System.out.println(root.val);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) return null;
        if (postorder.length == 1) return new TreeNode(postorder[0]);

        int len = postorder.length, i = 0, v = postorder[len - 1];//postorder最后一个元素是根
        for (; i < inorder.length; i++) {
            if (inorder[i] == v) {
                break;
            }
        }
        //System.out.println("i=" + i);//i=2

        TreeNode root = new TreeNode(v);

        //inorder的[0,i-1]个数字是左子树 0,1
        if (i > 0) {
            int[] leftPostorder = new int[i];
            int[] leftInorder = new int[i];
            System.arraycopy(postorder, 0, leftPostorder, 0, i);//i-1+1
            System.arraycopy(inorder, 0, leftInorder, 0, i);
            root.left = buildTree(leftInorder, leftPostorder);
        }

        if (len - i - 1 > 0) {
            int[] rightPostorder = new int[len - i - 1];
            int[] rightInorder = new int[len - i - 1];
            System.arraycopy(postorder, i, rightPostorder, 0, len - i - 1);//
            System.arraycopy(inorder, i + 1, rightInorder, 0, len - i - 1);
            root.right = buildTree(rightInorder, rightPostorder);
        }

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
