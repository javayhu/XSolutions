import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * hujiawei 15/5/1
 * <p/>
 * 二叉树
 * <p/>
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreLevelOrderTraversal_102 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        System.out.println(new BinaryTreLevelOrderTraversal_102().levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;

        TreeNode flag = new TreeNode(0);//作为标志，标志行结束
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        queue.addLast(flag);

        TreeNode node;
        List<Integer> level = new ArrayList<Integer>();
        while (queue.size() > 1) {//注意，这里不是判断isEmpty，因为flag会一直存在
            node = queue.removeFirst();
            if (node == flag) {
                result.add(level);
                queue.add(flag);
                level = new ArrayList<Integer>();
            } else {
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        result.add(level);//最后一层
        return result;
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
