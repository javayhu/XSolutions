import java.util.Scanner;

/**
 * hujiawei - 14/11/8.
 */

//http://bestcoder.hdu.edu.cn/contests/contest_showproblem.php?pid=1002&cid=546

//http://acm.hdu.edu.cn/showproblem.php?pid=5087

//DP，思路是在求LIS时维护另一个数组sum[]，sum[i]表示当达到序列的第i个数字时，求得以它结尾的LIS后统计该LIS中前面有哪些可以被其他子序列替换
//如果sum[n]=1表示没有可以替换的，那么第二长递增序列的长度是LIS的长度减1，否则就是LIS的长度

//

public class RevengeofLISII16B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n+1];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            a[n++] = Integer.MAX_VALUE;
            int[] dp = new int[n];
            int[] sum = new int[n];
            dp[0] = 1;
            sum[0] = 1;//
            for (int i = 1; i < n; i++) {
                int max = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (a[j] < a[i] && dp[j] > max) {
                        max = dp[j];
                    }
                }
                for (int j = i - 1; j >= 0; j--) {
                    if (a[j] < a[i] && dp[j] == max) {
                        sum[i] += sum[j];
                    }
                }
                if (sum[i] == 0) {//
                    sum[i] = 1;
                }
                dp[i] = max + 1;//
            }
            int result = 0;
            for (int i = 0; i < n; i++) {
                result = Math.max(result, dp[i]);
            }
            if (sum[n - 1] == 1) {//
                result--;
            }
            System.out.println(result - 1);
        }
    }
}
