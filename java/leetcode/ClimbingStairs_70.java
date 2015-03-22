/**
 * hujiawei - 15/3/21.
 * <p/>
 * 递归
 * <p/>
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs_70 {

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs_70().climbStairs(3));
    }

    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 2;
        int k = 3;
        while (k <= n) {
            f[k] = f[k - 1] + f[k - 2];
            k++;
        }
        return f[n];
    }

}
