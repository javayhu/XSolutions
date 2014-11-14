import java.math.BigDecimal;
import java.util.Scanner;

//http://acdream.info/problem?pid=1668

//dp，理解期望时间，处理BigDecimal的精度问题

public class Test1668 {
    public static void main(String arg[]) {
        int n;
        BigDecimal p[] = new BigDecimal[5];
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            n = cin.nextInt();
            for (int i = 0; i < 3; ++i) {
                int a = cin.nextInt();
                int c = cin.nextInt();
                p[i] = BigDecimal.valueOf(a).divide(BigDecimal.valueOf(c), 100, BigDecimal.ROUND_HALF_EVEN);
            }
            //a=p[0], b=p[1], c=p[2], a+c/2=p[3], b+c/2=p[4]
            p[3] = p[0].add(p[2].divide(BigDecimal.valueOf(2), 100, BigDecimal.ROUND_HALF_EVEN));
            p[4] = p[1].add(p[2].divide(BigDecimal.valueOf(2), 100, BigDecimal.ROUND_HALF_EVEN));
            //
            BigDecimal[][] dp = new BigDecimal[n + 2][n + 2];
            for (int i = 0; i <= n + 1; ++i)
                for (int j = 0; j <= n + 1; ++j)
                    dp[i][j] = BigDecimal.valueOf(0.0).setScale(100);
            //dp[n][1] = BigDecimal.valueOf(0.0).setScale(100);//多余
            for (int i = 2; i <= n; ++i)
                dp[n][i] = dp[n][i].add(dp[n][i - 1].add(BigDecimal.ONE));//no += here!
            //从上往下，从左往右依次递推
            for (int i = n - 1; i >= 1; --i) {
                dp[i][1] = dp[i][1].add(p[3].multiply(dp[i + 1][1].add(BigDecimal.ONE))).add(p[4].multiply(dp[i + 1][2].add(BigDecimal.ONE)));
                for (int j = 2; j <= n; ++j)
                    dp[i][j] = dp[i][j].add(p[0].multiply(dp[i + 1][j].add(BigDecimal.ONE)).add(p[1].multiply(dp[i + 1][j + 1].add(BigDecimal.ONE))).add(p[2].multiply(dp[i][j - 1].add(BigDecimal.ONE))));
            }
            System.out.println(dp[1][1].setScale(50, BigDecimal.ROUND_HALF_EVEN).toString());
        }
    }
}