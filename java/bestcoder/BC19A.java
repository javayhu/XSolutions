import java.util.Scanner;

/**
 * hujiawei - 14/11/22.
 *
 * ac
 */



//http://bbs.itheima.com/thread-28035-1-1.html

//http://emuch.net/html/201105/3172382.html

public class BC19A {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            int tn = n;

            if (n == 1) {
                System.out.println("0");
                continue;
            }

            int d = 2;
            while (d < n / d) {
                if (n % d == 0)
                    n /= d;
                else
                    d += 1;
            }
            //if (n == 1) n = d;
            System.out.println(tn / n);

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
