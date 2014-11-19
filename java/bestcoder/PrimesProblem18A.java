import java.math.BigInteger;
import java.util.Scanner;

/**
 * hujiawei - 14/11/15.
 */
public class PrimesProblem18A {

    private static int[] p;
    private static int pn;
    private static boolean[] isnp;

    public static void main(String[] args) {
        pn = 0;
        p = new int[10001];
        isnp = new boolean[10001];
        isnp[0] = isnp[1] = true;//isnp[i]=true表示i不是素数
        for (int i = 2; i <= 10000; ++i) {
            if (!isnp[i]) {//默认都是false的
                p[pn++] = i;//添加一个素数
            }
            //for (int j = 0; i * j <= 10000; ++j) {
            //    isnp[i * j] = true;//给定范围的数字中素数的整数倍一定不是素数
            //}
            for (int j = 0; j < pn && i * p[j] <= 10000; ++j) {
                isnp[i * p[j]] = true;
                if (i % p[j] == 0) break;
            }
        }
        //System.out.println(pn);//1229

        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            solve(n);
        }
    }

    private static void solve(int n) {
        int count = 0;
        int r;
        for (int i = 0; i < pn; i++) {
            for (int j = i; j < pn; j++) {
                if (p[i] + p[j] >= n) {
                    break;
                } else {//p[i] + p[j] < n
                    r = n - p[i] - p[j];
                    if (r >= p[j] && !isnp[r]) {
                        count++;
                    }
                }
                //for (int k = j; k < pn; k++) {
                //    if (p[i] + p[j] + p[k] == n) {
                //        count++;
                //    } else if (p[i] + p[j] + p[k] > n) {
                //        break;
                //    }
                //}
            }
        }
        System.out.println(count);
    }

}
