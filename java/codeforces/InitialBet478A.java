import java.math.BigInteger;
import java.util.Scanner;

//http://codeforces.com/problemset/problem/478/A

/**
 * 5个数之和是否是5的倍数
 */

public class InitialBet478A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();
        int sum = a + b + c + d + e;
        if (sum == 0 || sum % 5 != 0) {
            System.out.println("-1");
        } else {
            System.out.println(sum / 5);
        }

    }
}
