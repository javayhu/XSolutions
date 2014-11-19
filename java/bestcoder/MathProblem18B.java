import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * hujiawei - 14/11/15.
 */
public class MathProblem18B {

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
        double result;

        if (a == 0) {
            //double delta = c * c - 4 * b * d;
            double x = -c / 2 / b;
            double fl = cal(l);
            double fr = cal(r);
            result = Math.max(fl, fr);
            System.out.println(Math.max(result, cal(x)));
        } else {
            double delta = 4 * b * b - 12 * a * c;
            double fl = cal(l);
            double fr = cal(r);
            result = Math.max(fl, fr);
            if (delta <= 0) {
                print(result);
                return;
            }
            double r1 = ((-2) * b + Math.sqrt(delta)) / (6 * a);
            double r2 = ((-2) * b - Math.sqrt(delta)) / (6 * a);

            double fx1 = cal(r1);
            double fx2 = cal(r2);//
            System.out.println(Math.max(Math.max(result, fx1),fx2));

            //if (a > 0) {
            //    double x1 = Math.min(r1, r2);
            //    double x2 = Math.max(r1, r2);
            //    double fx1 = cal(x1);
            //    double fx2 = cal(x2);//
            //    if (r <= x1) {
            //        print(Math.max(fl, fr));//
            //    } else if (l >= x2) {
            //        print(fr);//
            //    } else if (l <= x1 && x1 <= r && r <= x2) {
            //        print(Math.max(fl, fx1));//
            //    } else if (l <= x1 && x2 <= r) {
            //        print(Math.max(Math.max(fl, fx1), fr));//
            //    } else if (x1 <= l && r <= x2) {
            //        print(fl);//
            //    } else if (x1 <= l && x2 <= r) {
            //        print(Math.max(fl, fx1));//
            //    } else {
            //        print(fr);//
            //    }
            //} else {
            //    double x1 = Math.max(r1, r2);
            //    double x2 = Math.min(r1, r2);
            //    double fx1 = cal(x1);
            //    double fx2 = cal(x2);//
            //    if (r <= x2) {
            //        print(fl);//
            //    } else if (l >= x2) {
            //        print(Math.max(fl, fr));//
            //    } else if (l <= x2 && x2 <= r && r <= x1) {
            //        print(Math.max(fl, fr));//
            //    } else if (l <= x2 && x1 <= r) {
            //        print(Math.max(Math.max(fl, fx1), fr));//
            //    } else if (x2 <= l && r <= x1) {
            //        print(fr);//
            //    } else if (x2 <= l && x1 <= r) {
            //        print(Math.max(fr, fx1));//
            //    } else {
            //        print(Math.max(fl, fr));//
            //    }
            //}
        }
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
