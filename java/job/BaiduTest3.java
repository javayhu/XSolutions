import java.util.Scanner;

/**
 * hujiawei 15/9/28
 */
public class BaiduTest3 {

    static int l;
    static int[] a;
    static int[] b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            l = scanner.nextInt();
            a = new int[l];
            b = new int[l];
            for (int i = 0; i < l; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(dp());
        }
    }

    private static int dp() {
        int i, j, k, t;
        t = 0;
        b[0] = 1;
        for (i = 0; i < l; i++) {
            k = 0;
            for (j = 0; j < i; j++) {
                if (a[i] < a[j] && k < b[j]) {
                    k = b[j];
                }
            }
            b[i] = k + 1;
        }
        for (i = 0; i < l; i++) {
            if (t < b[i]) {
                t = b[i];
            }
        }
        return t;
    }
}
