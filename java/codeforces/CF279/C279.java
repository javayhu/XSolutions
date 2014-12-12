package CF279;

import java.math.BigInteger;
import java.util.Scanner;

//http://codeforces.com/contest/490/problem/C

//tle
public class C279 {


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        String s = cin.next();
        BigInteger a = cin.nextBigInteger();
        BigInteger b = cin.nextBigInteger();

        int len = s.length();
        String l, r;
        BigInteger bl, br;
        for (int i = a.toString().length(); i < len; i++) {
            l = s.substring(0, i);
            r = s.substring(i);
            //System.out.println("l=" + l + " r=" + r);
            if (r.charAt(0) == '0') {
                continue;
            }
            bl = new BigInteger(l);
            if (bl.divideAndRemainder(a)[1] == BigInteger.ZERO) {
                br = new BigInteger(r);
                if (br.divideAndRemainder(b)[1] == BigInteger.ZERO) {
                    System.out.println("YES");
                    System.out.println(l);
                    System.out.println(r);
                    return;
                }
            }
        }
        System.out.println("NO");
    }

}
