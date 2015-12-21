import java.util.Arrays;

/**
 * hujiawei 15/9/15
 */
public class Temp {

    public static void main(String[] args) {

        int[] s = new int[501];
        for (int i = 0; i < 501; i++) {
            s[i] = i;
        }
        System.out.println("s=" + Arrays.toString(s));

        while (true) {
            int[] t = new int[s.length / 2];
            if (t.length <= 1) {
                System.out.println(Arrays.toString(t));
                return;
            }

            for (int k = 0, i = 1; k < t.length && i < s.length; k++, i += 2) {
                t[k] = s[i];
            }
            System.out.println("t=" + Arrays.toString(t));
            s = t;
        }

       /* System.out.println(Math.pow(3.1,2.1));
        System.out.println(Math.pow(2.1,3.1));
        System.out.println(Math.pow(4.1,2.1));
        System.out.println(Math.pow(2.1,4.1));*/


        /*ArrayList<Integer> result  = new ArrayList<Integer>();
        result.add(3);
        result.add(0,1);
        System.out.println(result.get(0));
        System.out.println(result.get(1));*/

        /*Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            sum(n, m);
        }*/

    }

    private static void sum(int n, int m) {
        double dn = n;
        double sum = 0f;
        while (m > 0) {
            sum += dn;
            dn = Math.sqrt(dn);
            m--;
        }
        System.out.println(sum);
    }

}
