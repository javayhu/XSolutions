/**
 * hujiawei 15/5/1
 * <p/>
 * 二叉树
 * <p/>
 * https://leetcode.com/problems/unique-binary-search-trees/
 */
public class UniqueBinarySearchTrees_96 {

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTrees_96().numTrees(3));
    }

    public int numTrees(int n) {
        if (n == 0 || n == 1) return 1;
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        //求出f数组，从0到f[n-1]
        for (int i = 2; i <= n; i++) {
            for (int k = 0; k < i; k++) {
                f[i] += f[k] * f[i - 1 - k];//f[2]=f[0]*f[1]+f[1]*f[0]
            }
        }
        return f[n];
    }

}
