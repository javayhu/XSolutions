import java.util.Scanner;

/**
 * hujiawei - 14/11/2.
 */

//http://dsalgo.openjudge.cn/linearlists/4/

//递推 http://www.slyar.com/blog/poj-1664-c.html

public class PMOOC666 {


    private static final Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {

        int t = cin.nextInt();
        int m, n;
        while (t-- > 0) {
            m = cin.nextInt();
            n = cin.nextInt();
            System.out.println(dealApples(m, n));
        }
    }

    private static int dealApples(int m, int n) {
        if (m < 0) return 0;
        if (m == 0) return 1;
        if (n == 1) return 1;
        return dealApples(m, n - 1) + dealApples(m - n, n);
    }

}
