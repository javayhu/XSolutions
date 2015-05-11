import java.math.BigInteger;

/**
 * hujiawei 15/5/2
 * <p/>
 * 模拟
 * <p/>
 * https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyStrings_43 {

    public String multiply(String num1, String num2) {
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        BigInteger c = a.multiply(b);
        return c.toString();
    }

}
