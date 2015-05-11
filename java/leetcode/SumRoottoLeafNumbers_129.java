import java.util.LinkedList;

/**
 * hujiawei 15/5/1
 * <p/>
 * 二叉树
 * <p/>
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRoottoLeafNumbers_129 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(5);
        System.out.println(new SumRoottoLeafNumbers_129().sumNumbers(root));
    }

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return sum;
        LinkedList<Integer> path = new LinkedList<Integer>();
        path.add(root.val);
        genPath(path, root);
        return sum;
    }

    private void genPath(LinkedList<Integer> path, TreeNode root) {
        //root是叶子节点
        if (root != null && root.left == null && root.right == null) {
            //result.add(new LinkedList<Integer>(path));
            sum += genSumFormPath(path);
            return;
        }

        //进入genPath方法能够保证root参数不为null，下面是root不是叶子节点的情况
        if (root.left != null) {
            path.add(root.left.val);
            genPath(path, root.left);
            path.removeLast();
        }
        if (root.right != null) {
            path.add(root.right.val);
            genPath(path, root.right);
            path.removeLast();
        }
    }

    private int genSumFormPath(LinkedList<Integer> path) {
        int sum = 0;
        for (Integer p : path) {
            sum = sum * 10 + p;
        }
        return sum;
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
