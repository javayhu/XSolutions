import java.util.ArrayList;
import java.util.List;

/**
 * hujiawei 15/5/1
 * <p/>
 * 二叉树
 * <p/>
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBinarySearchTrees2_95 {

    public static void main(String[] args) {
        List<TreeNode> list = new UniqueBinarySearchTrees2_95().generateTrees(3);
        System.out.println(list.size());
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    //这个函数就是用来生成从start到end这个区间能够生成的二叉查找树
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end){
            result.add(null);//不可能存在这样的子树 [可以是null即为空树]
            return result;
        }
        if (start == end) {
            result.add(new TreeNode(start));//只有这种可能的子树
            return result;
        }

        for (int i = start; i <= end; i++) {//
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode node = new TreeNode(i);//把i作为根节点
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }
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
