import java.math.BigInteger;
import java.util.Scanner;

//http://codeforces.com/problemset/problem/478/B

/**
 * n个人分成m组，最多最少能产生多少朋友
 */

public class RandomTeams478B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger n = scanner.nextBigInteger();
        BigInteger m = scanner.nextBigInteger();
        BigInteger max = getCombinations(n.subtract(m).add(BigInteger.ONE));
        if (m.equals(BigInteger.ONE)) {//make it fast return
            System.out.println(max + " " + max);
            return;
        }
        BigInteger min = BigInteger.ZERO;
        BigInteger[] drnm = n.divideAndRemainder(m);
        if (drnm[1].equals(BigInteger.ZERO)) {//remainder=0
            min = m.multiply(getCombinations(drnm[0]));
        } else {//remainder!=0, min=(m-r)*C(d)+r*C(d+1)
            min = m.subtract(drnm[1]).multiply(getCombinations(drnm[0]))
                    .add(drnm[1].multiply(getCombinations(drnm[0].add(BigInteger.ONE))));
        }
        System.out.println(min + " " + max);
    }

    public static BigInteger getCombinations(BigInteger n) {
        if (n.equals(BigInteger.ONE)) return BigInteger.ZERO;
        else {
            return n.multiply(n.subtract(BigInteger.ONE)).divide(new BigInteger("2"));
        }
    }

}
