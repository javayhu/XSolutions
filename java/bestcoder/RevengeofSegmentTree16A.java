import java.util.Scanner;

/**
 * hujiawei - 14/11/8.
 */

//http://bestcoder.hdu.edu.cn/contests/contest_showproblem.php?pid=1001&cid=546

//http://acm.hdu.edu.cn/showproblem.php?pid=5086

//TLE 思路是考虑序列中的第i个数出现了多少次，如果i从0开始的话，那么出现的次数为(i+1)(n-i)次

public class RevengeofSegmentTree16A {

    public static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long sum,n, k;
        while (t-- > 0) {
            sum = 0;
            n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                k = scanner.nextInt();
                sum = (sum + (k % MOD) * (i + 1) % MOD * (n - i) % MOD) % MOD;
            }
            System.out.println(sum);
        }
    }


}
