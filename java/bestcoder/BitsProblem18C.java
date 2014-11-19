import java.math.BigInteger;

/**
 * hujiawei - 14/11/15.
 */
public class BitsProblem18C {


    public static void main(String[] args) {


    }

    public static int perfectness(int x) {
        int temp = x - (x >>> 1) & 033333333333 - (x >>> 2) & 011111111111;
        return (temp + (temp >>> 3)) & 030707070707 % 63;
    }

    //how?
    public static int perfectnessBiginteger(int x) {
        int temp = x - (x >>> 1) & 033333333333 - (x >>> 2) & 011111111111;
        return (temp + (temp >>> 3)) & 030707070707 % 63;
    }

    //num 要转换的数 from源数的进制 to要转换成的进制
    private static String changeTen2Two(String num) {
        return new BigInteger(num, 10).toString(2);
    }


    private static String changeTwo2Ten(String num) {
        return new BigInteger(num, 2).toString(10);
    }
}
