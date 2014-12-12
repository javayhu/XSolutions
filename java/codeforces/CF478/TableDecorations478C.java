package CF478;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

//http://codeforces.com/problemset/problem/478/C

/**
 * 考虑如果其中有一种颜色的气球特别多！如果不满足这个条件则都构造出这个条件！
 */

public class TableDecorations478C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger[] data = new BigInteger[3];
        data[0] = scanner.nextBigInteger();
        data[1] = scanner.nextBigInteger();
        data[2] = scanner.nextBigInteger();
        Arrays.sort(data);
        if (data[0].add(data[1]).multiply(new BigInteger("2")).max(data[2]).equals(data[2]) ) {
            System.out.println(data[0].add(data[1]));
        } else {
            System.out.println((data[0].add(data[1]).add(data[2])).divide(new BigInteger("3")));
        }
    }

}
