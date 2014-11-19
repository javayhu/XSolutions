import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * hujiawei - 14/11/15.
 */
public class MathProblem18B2 {

    private static double a, b, c, d, l, r;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            a = cin.nextDouble();
            b = cin.nextDouble();
            c = cin.nextDouble();
            d = cin.nextDouble();
            l = cin.nextDouble();
            r = cin.nextDouble();
            solve();
        }
    }

    private static void solve() {
        double result = Math.max(cal(l), cal(r));
        while (r - l >= 0.01) {
            result = Math.max(result, cal(l));
            l += 0.01;
        }
        print(result);
    }

    private static double cal(double x) {
        return Math.abs(a * x * x * x + b * x * x + c * x + d);
    }

    private static void print(double result) {
        //System.out.printf("%2f", result);
        DecimalFormat fmt = new DecimalFormat("0.00");
        System.out.println(fmt.format(result));
    }

}
