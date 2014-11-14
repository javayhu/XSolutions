import java.math.BigInteger;
import java.util.Scanner;

/**
 * hujiawei - 14/11/12.
 */

//http://acdream.info/problem?pid=1669

//数学规律，sqrt(n)%2，用二分法求n的平方根

public class Test1669 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger n;
        while (scanner.hasNext()) {
            n = scanner.nextBigInteger();
            solve(n);
        }
    }

    private static void solve(BigInteger n) {
        BigInteger l = BigInteger.ONE;
        BigInteger r = n;
        BigInteger mid;
        while (l.compareTo(r) <= 0) {
            mid = l.add(r).shiftRight(1);
            if (mid.multiply(mid).add(mid).add(mid).compareTo(n) < 0) {
                l = mid.add(BigInteger.ONE);
            } else {
                r = mid.subtract(BigInteger.ONE);
            }
        }
        System.out.println(l.remainder(BigInteger.valueOf(2)));
    }

}
