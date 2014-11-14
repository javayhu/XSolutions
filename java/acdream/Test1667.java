import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * hujiawei - 14/11/12.
 */

//http://acdream.info/problem?pid=1667

//f[k][t]表示第k步在t跑道，f[k][t]=f[k-1][t-1]+f[k-1][t]+f[k-1][t+1]

public class Test1667 {

    private static BigInteger[][] f;

    public static void main(String[] args) {
        cal();
        Scanner scanner = new Scanner(System.in);
        int n;
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            System.out.println(f[n][1]);
        }
    }

    private static void cal() {
        int len = 1001;
        f = new BigInteger[len][len + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len + 1; j++) {
                f[i][j] = BigInteger.ZERO;
            }
        }
        f[0][1] = BigInteger.ONE;
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= i + 1; j++) {
                f[i][j] = f[i - 1][j - 1].add(f[i - 1][j]).add(j + 1 > len ? BigInteger.ZERO : f[i - 1][j + 1]);
            }
        }
    }

}
