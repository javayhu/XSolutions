import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * hujiawei - 15/3/22.
 * <p/>
 * 动规
 * <p/>
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 */
public class PalindromePartitioning2_132 {

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning2_132().minCut("bb"));
        System.out.println(new PalindromePartitioning2_132().minCut("aab"));
        System.out.println(new PalindromePartitioning2_132().minCut("ccaacabacb"));
    }

    // 二维DP转换成一维DP，变成两个一维DP问题
    // http://www.acmerblog.com/leetcode-solution-palindrome-partitioning-ii-6228.html
    public int minCut(String s) {
        int n = s.length();
        boolean[][] p = new boolean[n][n];
        // 第一个DP：初始化，计算从i到j是否是回文字符串 (字符i和字符j都包括在内)
        for (int j = 0; j < n; j++) {
            p[j][j] = true;//其实也就是j==i的时候
            for (int i = 0; i < j; i++) {
                //更加精简版本的用于判断是否是回文字符串的代码
                p[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 2 || p[i + 1][j - 1]);
            }
        }
        //System.out.println(Arrays.toString(p));

        // 第二个DP：f[i]表示从i到n-1要完成题目要求所需的最小的切割数
        // 注意这里f[i]是从i到n-1而不是从0到i -> f[i]=min{f[j+1]+1}, i<=j<n
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = Integer.MAX_VALUE;
        }

        f[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {//每个循环内计算出f[i]，从后往前
            for (int j = n - 1; j >= i; j--) {
                //从i到j是回文字符串，然后f[i]=f[j]+1，在这些满足条件的j中找到一个使得f[i]最小的
                if (p[i][j]) {
                    if (j == n - 1) {
                        f[i] = 0;//特殊情况，此时p[i][n-1]就是一个回文字符串
                    } else if (j + 1 <= n - 1 && f[j + 1] + 1 < f[i]) {
                        f[i] = f[j + 1] + 1;
                    }
                }
            }
            if (f[i] == Integer.MAX_VALUE) {//如果没有任何地方可以分割的话，那就分割这个字符吧
                f[i] = f[i + 1] + 1;
            }
        }
        return f[0];
    }
}
