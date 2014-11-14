import java.math.BigInteger;
import java.util.Scanner;

//http://acdream.info/problem?pid=1670


public class Test1670S {
    public static void main(String arg[]) {
        int p[] = new int[10000];
        boolean isnp[] = new boolean[10001];
        int pn = 0;
        isnp[0] = isnp[1] = true;
        for (int i = 2; i <= 10000; ++i) {
            if (!isnp[i])
                p[pn++] = i;
            for (int j = 0; j < pn && i * p[j] <= 10000; ++j) {
                isnp[i * p[j]] = true;
                if (i % p[j] == 0)
                    break;
            }
        }
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            BigInteger n = cin.nextBigInteger(), now = BigInteger.ONE;
            int i = 0;
            while (now.multiply(BigInteger.valueOf(p[i])).compareTo(n) <= 0) {
                now = now.multiply(BigInteger.valueOf(p[i]));
                i++;
            }
            System.out.println(now.toString());
        }
    }
}