import java.util.Scanner;

/**
 * hujiawei 15/4/26
 */
public class BC39B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner = null;
        //try {
        //    scanner = new Scanner(new FileInputStream("data/in4.txt"));
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

            int f[] = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (a[j] % a[i] == 0) {
                        f[i] = j;
                        break;
                    }
                }
            }
            int sum = 0;
            for (int k = 1; k <= n; k++) {
                sum += f[k];
            }
            //System.out.println(Arrays.toString(f));
            System.out.println(sum);
        }
    }

}
