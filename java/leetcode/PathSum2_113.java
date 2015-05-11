import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * hujiawei 15/5/1
 * <p/>
 * 二叉树
 * <p/>
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSum2_113 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        System.out.println(new PathSum2_113().pathSum(root, 10));
    }

    //路径上的数字序列可以是相同
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;//wrong:|| root.val > sum 可能存在负数

        LinkedList<TreeNode> path = new LinkedList<TreeNode>();
        path.add(root);
        genPath(result, path, root, sum - root.val);

        return result;
    }

    //
    private void genPath(List<List<Integer>> result, LinkedList<TreeNode> path, TreeNode root, int sum) {
        //root是叶子节点，sum此时刚好为0了
        if (root != null && root.left == null && root.right == null) {
            if (sum==0) {
                result.add(genListFromPath(path));
            }//如果sum不等于0，也可以返回了
            return;
        }

        //进入genPath方法能够保证root参数不为null，下面是root不是叶子节点的情况
        if (root.left != null) {
            path.add(root.left);
            genPath(result, path, root.left, sum - root.left.val);
            path.removeLast();
        }
        if (root.right != null) {
            path.add(root.right);
            genPath(result, path, root.right, sum - root.right.val);
            path.removeLast();
        }
    }

    private List<Integer> genListFromPath(LinkedList<TreeNode> path) {
        List<Integer> list = new ArrayList<Integer>();
        for (TreeNode node : path) {
            list.add(node.val);
        }
        return list;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;//空节点
        if (root.left == null && root.right == null) return sum == root.val;//叶子节点
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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
