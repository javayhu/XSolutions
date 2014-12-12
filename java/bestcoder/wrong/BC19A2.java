package wrong;

import java.util.Arrays;
import java.util.Scanner;

/**
 * hujiawei - 14/11/22.
 */
public class BC19A2 {

    private static final int maxn = 1000000;//10^6 ok 10^9 out
    private static int pn;
    private static int[] p;
    private static boolean[] isnp;

    public static void main(String[] args) {
        pn = 0;
        p = new int[maxn + 1];
        isnp = new boolean[maxn + 1];
        isnp[0] = isnp[1] = true;//isnp[i]=true表示i不是素数
        for (int i = 2; i <= maxn; ++i) {
            if (!isnp[i]) {//默认都是false的
                p[pn++] = i;//添加一个素数
            }
            for (int j = 0; j < pn && i * p[j] <= maxn; ++j) {
                isnp[i * p[j]] = true;
                if (i % p[j] == 0) break;
            }
        }

        int[] tp = new int[pn];
        System.arraycopy(p, 0, tp, 0, pn);

        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();

            if (n <= maxn) {
                if (!isnp[n]) {//n就是素数
                    System.out.println("1");
                } else {//n不是素数
                    int index = Arrays.binarySearch(tp, n);
                    if (index < 0) index = -index - 2;
                    //System.out.println("index=" + index);//
                    boolean f = false;
                    for (int i = index; i >= 0; i--) {
                        if (n % tp[i] == 0) {
                            f = true;
                            System.out.println(n / tp[i]);
                            break;
                        }
                    }
                    if (!f) {
                        System.out.println("0");//no result
                    }
                }
            } else {
                int k = 1, t;
                boolean f = false;
                while (k <= n) {
                    if (n % k == 0) {
                        t = n / k;
                        if ((t < maxn && !isnp[t]) || (t > maxn && isPrime(t))) {
                            f = true;
                            System.out.println(k);
                            break;
                        }
                    }
                    k++;
                }
                if (!f) {
                    System.out.println("0");//no result
                }
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0) return false;
        return true;
    }
}
