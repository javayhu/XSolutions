
import java.util.Scanner;

public class LIS {

    public static int l;
    public static int maxl;
    public static int[] a;
    public static int[] b;

    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        while (sin.hasNext()) {
            l = sin.nextInt();
            a = new int[l];
            b = new int[l];//记住数组一定要初始化给定一个大小，不然后面赋值时会报空指针错误
            for (int i = 0; i < l; i++) {
                a[i] = sin.nextInt();
            }
            maxl = dp2();
            System.out.println(maxl);
        }
    }

    private static int dp() {
        int i, j, k, t;
        t = 0;
        b[0] = 1;
        for (i = 0; i < l; i++) {
            k = 0;
            for (j = 0; j < i; j++) {
                if (a[i] > a[j] && k < b[j]) {
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

    private static int dp2() {
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