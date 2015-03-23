/**
 * hujiawei - 15/3/22.
 * <p/>
 * 分治
 * <p/>
 * https://leetcode.com/problems/powx-n/
 */
public class Pow_50 {

    public static void main(String[] args) {
        System.out.println(new Pow_50().pow(2.1, 4));
    }

    // 参考解法 http://www.acmerblog.com/leetcode-solution-powx-n-6240.html
    public double pow(double x, int n) {
        if (n < 0) return 1.0 / power(x, -n);//处理负数的情况
        return power(x, n);
    }

    // x^n = x^{n/2} * x^{n/2} * x^{n%2}
    private double power(double x, int n) {
        if (n == 0) return 1;
        double v = power(x, n / 2);//先计算出x的n/2次方，这样可以减少重复的计算
        return n % 2 == 0 ? v * v : v * v * x;
    }

}
