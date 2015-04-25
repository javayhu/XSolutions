/**
 * hujiawei 15/4/24
 * <p/>
 * 模拟
 * <p/>
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger_5 {

    public static void main(String[] args) {
        System.out.println(new ReverseInteger_5().reverse(-123));
        System.out.println(new ReverseInteger_5().reverse(1534236469));
    }

    public int reverse(int x) {
        int y = Math.abs(x);
        int max = Integer.MAX_VALUE;
        int max10 = max / 10;
        int lastDigit = max % 10;

        int z = 0;
        while (y > 0) {
            z = z * 10 + y % 10;
            y = y / 10;

            if (y > 0 && (z > max10 || (z == max10 && y % 10 > lastDigit))) {//will overflow
                return 0;
            }
        }

        return x > 0 ? z : -z;
    }

}
