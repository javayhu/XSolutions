import java.util.Scanner;

/**
 * hujiawei - 10/19/14.
 */

//http://codeforces.com/contest/479/problem/A

//简单题

public class Expression274A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int max = a * (b + c);
        if (a * b * c > max) {
            max = a * b * c;
        }
        if ((a + b) * c > max) {
            max = (a + b) * c;
        }
        System.out.println(max);
    }

}
