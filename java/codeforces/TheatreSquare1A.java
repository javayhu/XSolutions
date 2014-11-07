import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

//http://codeforces.com/problemset/problem/1/A

/**
 * 长至少需要多少块*宽至少需要多少块
 */

public class TheatreSquare1A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();
        BigInteger b = new BigInteger(String.valueOf((n+a-1)/a)); // (n+a-1)/a || (n+n%a)/a
        BigInteger c = new BigInteger(String.valueOf((m+a-1)/a));
        BigInteger result = b.multiply(c);
        System.out.println(result);
    }
}
