import java.util.Scanner;

/**
 * hujiawei - 14/11/8.
 */

//http://acm.hdu.edu.cn/showproblem.php?pid=5100

//思路，根据n%k和k/2的大小关系来判断如何覆盖

public class Cheeseboard17A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            if (k > n) {
                System.out.println("0");
                continue;
            }
            int m = n % k;
            if (m > k / 2) {
                System.out.println(n * n - (k - m) * (k - m));
            } else {
                System.out.println(n * n - m * m);
            }
        }
    }

}
