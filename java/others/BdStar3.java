import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * hujiawei 15/5/25
 * <p/>
 * 百度之星
 */
public class BdStar3 {

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream("data/bd1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int t = scanner.nextInt();
        for (int k = 1; k <= t; k++) {
            System.out.println("Case #" + k + ":");

            int tmp = 0;
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                tmp = scanner.nextInt();
                a[i] = tmp;
                b[i] = tmp;
            }

            Arrays.sort(b);

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (Math.abs(b[i] - a[i]) > max) {
                    max = Math.abs(b[i] - a[i]);
                }
            }

            System.out.println(max);
        }

    }

}
