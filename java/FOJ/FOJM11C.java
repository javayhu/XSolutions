import java.util.Scanner;

/**
 * hujiawei - 14/11/16.
 */

//http://acm.fzu.edu.cn/contest/problem.php?cid=140&sortid=3

public class FOJM11C {

    private static int n;
    private static int[] s;
    private static int[][] dp;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            n = cin.nextInt();
            s = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = cin.nextInt();
            }
            solve();
        }
    }

    private static void solve() {
        dp = new int[n][n];
        int[][] max = new int[n][n];
        int[][] min = new int[n][n];
        for (int i = 0; i < n; i++) {
            max[i][i] = s[i];
            min[i][i] = s[i];
            dp[i][i] = 0;
        }
        //
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s[j] > max[i][j - 1]) {
                    max[i][j] = s[j];
                } else {
                    max[i][j] = max[i][j - 1];
                }
                if (s[j] < min[i][j - 1]) {
                    min[i][j] = s[j];
                } else {
                    min[i][j] = min[i][j - 1];
                }
            }
        }

        int j, m, r, x, y;
        for (int l = 1; l < n; l++) {//len from 1 -> n-1
            for (int i = 0; i < n - l; i++) {
                j = i + l;
                dp[i][j] = (max[i][j] - min[i][j]) * (max[i][j] - min[i][j]);
                for (int k = i; k < j; k++) {
                    r = dp[i][k] + dp[k + 1][j];
                    if (r > dp[i][j]) {
                        dp[i][j] = r;
                    }
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }

}
