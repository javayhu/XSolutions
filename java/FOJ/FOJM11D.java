import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * hujiawei - 14/11/16.
 */
public class FOJM11D {

    private static int n;
    private static int[] v;
    private static int[] w;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        while (t-- > 0) {
            n = cin.nextInt();
            v = new int[n];
            w = new int[n];
            for (int i = 0; i < n; i++) {
                v[i] = cin.nextInt();
            }
            for (int i = 0; i < n; i++) {
                w[i] = cin.nextInt();
            }
            solve();
        }
    }

    private static void solve() {
        PriorityQueue<DItem> queue = new PriorityQueue<DItem>();
        DItem item = new DItem(0, 0, 0, 0, -1, Integer.MAX_VALUE);
        queue.add(item);

        int cn, cd, od = Integer.MAX_VALUE;
        int max = n % 2 == 0 ? n / 2 : (n + 1) / 2;
        DItem current, new1, new2;
        while (!queue.isEmpty()) {
            current = queue.poll();
            cn = current.n + 1;
            if (cn >= n || current.cv + 1 > max || current.cw + 1 > max) {
                if (current.d < od) od = current.d;
                continue;
            }
            cd = Math.abs(current.sv + v[cn] - current.sw);
            new1 = new DItem(current.sv + v[cn], current.sw, current.cv + 1, current.cw, cn, cd);
            cd = Math.abs(current.sw + w[cn] - current.sv);
            new2 = new DItem(current.sv, current.sw + w[cn], current.cv, current.cw + 1, cn, cd);
            queue.add(new1);
            queue.add(new2);
        }
        System.out.println(od);
    }

    static class DItem implements Comparable<DItem> {

        int sv, sw, cv, cw, n, d = Integer.MAX_VALUE;

        DItem(int sv, int sw, int cv, int cw, int n, int d) {
            this.sv = sv;
            this.sw = sw;
            this.cv = cv;
            this.cw = cw;
            this.n = n;
            this.d = d;
        }

        @Override
        public int compareTo(DItem o) {
            if (this.d > o.d) {
                return 1;
            } else if (this.d < o.d) {
                return -1;
            }
            return 0;
        }
    }
}



