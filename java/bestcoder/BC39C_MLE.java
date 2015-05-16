import java.util.HashMap;
import java.util.Scanner;

/**
 * hujiawei 15/4/26
 */
public class BC39C_MLE {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner = null;
        //try {
        //    scanner = new Scanner(new FileInputStream("data/in5.txt"));
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //}

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }
            scanner.nextLine();
            System.out.println(calc(a, n));
        }
    }

    public static int calc(int[] a, int n) {
        //int[][] cache = new int[n + 1][n + 1];
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int tmp;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                tmp = gcd(a[i], a[j]);
                //cache[i][j] = tmp;
                //cache[j][i] = tmp;
                map.put(i + "_" + j, tmp);
            }
        }

        int res = 0;
        String key;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i <= j) {
                    key = i + "_" + j;
                } else {
                    key = j + "_" + i;
                }
                //res += cache[i][j] * (cache[i][j] - 1);
                res += map.get(key) * (map.get(key) - 1);
                res %= 10007;
            }
        }
        return res;
    }

    public static int gcd(int a, int b) {
        int min = a;
        int max = b;
        if (a > b) {
            min = b;
            max = a;
        }
        if (min == 0)
            return max;
        else
            return gcd(min, max - min);
    }

}
