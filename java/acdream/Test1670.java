import java.math.BigInteger;
import java.util.Scanner;

//http://acdream.info/problem?pid=1670

//数学，素数筛选

public class Test1670 {
    public static void main(String arg[]) {
        int p[] = new int[10000];//存储素数 2 3 5 7 11 13 17 19 23 29 ...
        boolean isnp[] = new boolean[10001];//标记是否为素数
        int pn = 0;//标记是第pn个素数，结合p[]可以得到对应的素数，2是第0个
        isnp[0] = isnp[1] = true;//isnp[i]=true表示i不是素数
        for (int i = 2; i <= 10000; ++i) {
            if (!isnp[i]) {//默认都是false的
                p[pn++] = i;//添加一个素数
            }
            //for (int j = 0; j < pn && i * p[j] <= 10000; ++j) {
            //    isnp[i * p[j]] = true;
            //    if (i % p[j] == 0)
            //        break;
            //}
            for (int j = 0; i * j <= 10000; ++j) {
                isnp[i * j] = true;//给定范围的数字中素数的整数倍一定不是素数
            }
        }

        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int i = 0;
            BigInteger n = cin.nextBigInteger(), now = BigInteger.ONE;
            while (now.multiply(BigInteger.valueOf(p[i])).compareTo(n) <= 0) {
                now = now.multiply(BigInteger.valueOf(p[i]));
                i++;
            }
            System.out.println(now.toString());
        }
    }
}