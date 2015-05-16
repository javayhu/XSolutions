import java.util.HashMap;
import java.util.Scanner;

/**
 * hujiawei 15/4/26
 */
public class BC39D {

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
            int k = scanner.nextInt();

            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }
            scanner.nextLine();

            int q = scanner.nextInt();
            while (q-- > 0) {
                int l1 = scanner.nextInt();
                int r1 = scanner.nextInt();
                int l2 = scanner.nextInt();
                int r2 = scanner.nextInt();

                //System.out.println(l1 + " " + r1 + " " + l2 + " " + r2);

                HashMap<Integer, Integer> leftMap = new HashMap<Integer, Integer>();
                HashMap<Integer, Integer> rightMap = new HashMap<Integer, Integer>();

                for (int i = l1; i <= r1; i++) {
                    if (leftMap.containsKey(a[i])) {
                        leftMap.put(a[i], leftMap.get(a[i]) + 1);
                    } else {
                        leftMap.put(a[i], 1);
                    }
                }
                for (int i = l2; i <= r2; i++) {
                    if (rightMap.containsKey(a[i])) {
                        rightMap.put(a[i], rightMap.get(a[i]) + 1);
                    } else {
                        rightMap.put(a[i], 1);
                    }
                }

                int target, sum = 0;
                if (r1-l1<r2-l2) {
                    for (int i = l1; i <= r1; i++) {
                        target = k - a[i];
                        if (rightMap.containsKey(target)) {
                            sum += rightMap.get(target);
                        }
                    }
                }else{
                    for (int i = l2; i <= r2; i++) {
                        target = k - a[i];
                        if (leftMap.containsKey(target)) {
                            sum += leftMap.get(target);
                        }
                    }
                }
                System.out.println(sum);
            }
        }
    }

}
