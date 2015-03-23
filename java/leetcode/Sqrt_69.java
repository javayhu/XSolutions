import java.math.BigInteger;

/**
 * hujiawei - 15/3/22.
 * <p/>
 * 分治
 * <p/>
 * https://leetcode.com/problems/sqrtx/
 */
public class Sqrt_69 {

    public static void main(String[] args) {
        System.out.println(new Sqrt_69().sqrt(2));
        System.out.println(new Sqrt_69().sqrt(24));
        System.out.println(new Sqrt_69().sqrt(2147395599));
    }

    public int sqrt(int x) {
        return search(0, x, x);
    }

    private int search(int l, int r, int x) {
        int intm = (l + r) / 2;
        BigInteger m, m2;
        if (l <= r) {
            intm = (l + r) / 2;
            m = BigInteger.valueOf(intm);
            m2 = m.multiply(m);//m2超了整数范围会变成负数
            if (m2.compareTo(BigInteger.valueOf(x)) == 0) {
                return m.intValue();
            } else if (m2.compareTo(BigInteger.valueOf(x)) > 0) {
                return search(l, intm - 1, x);
            } else {
                return search(intm + 1, r, x);
            }
        }
        return intm;
    }

}
