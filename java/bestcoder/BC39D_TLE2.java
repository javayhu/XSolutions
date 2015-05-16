import java.util.Arrays;
import java.util.Scanner;

/**
 * hujiawei 15/4/26
 *
 * TLE
 */
public class BC39D_TLE2 {

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

                int lenLeft = r1 - l1 + 1;
                int lenRight = r2 - l2 + 1;
                int[] left = new int[lenLeft];
                int[] right = new int[lenRight];
                System.arraycopy(a, l1, left, 0, lenLeft);
                System.arraycopy(a, l2, right, 0, lenRight);

                //System.out.println(Arrays.toString(left));
                //System.out.println(Arrays.toString(right));

                Arrays.sort(left);
                Arrays.sort(right);

                int target = 0, sum = 0;
                int[] range;
                for (int i = 0; i < lenLeft; i++) {
                    target = k - left[i];
                    range = searchRange(right, target);
                    //System.out.println("target=" + target + " " + Arrays.toString(range));
                    if (range[0] != -1) {//找到了
                        sum += range[1] - range[0] + 1;
                    }
                }
                System.out.println(sum);
            }
        }
    }

    public static int[] searchRange(int[] A, int target) {
        int left = lSearch(A, A.length, target);
        int right = rSearch(A, A.length, target);
        return new int[]{left, right};
    }

    static int lSearch(int[] A, int n, int target) {
        int low = 0, high = n - 1;
        while (low <= high) { // q1
            int mid = (low + high) >> 1;
            if (A[mid] < target) { // q2
                low = mid + 1;
            } else {//这里表示当low==high时向左走
                high = mid - 1;
            }
        }
        if (low < 0 || low >= n || A[low] != target)
            return -1;
        return low; // q3
    }

    static int rSearch(int[] A, int n, int target) {
        int low = 0, high = n - 1;
        while (low <= high) { // q1
            int mid = (low + high) >> 1;
            if (A[mid] > target) { // q2
                high = mid - 1;
            } else {//这里表示当low==high时向右走
                low = mid + 1;
            }
        }
        if (high < 0 || high >= n || A[high] != target)
            return -1;
        return high; // q3
    }

}
