import java.math.BigInteger;
import java.util.Scanner;

/**
 * hujiawei - 14/11/22.
 */
public class BC19B {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int a = cin.nextInt();
            String s = cin.next();

            int b = 1;
            if (s.length() > 1) {
                if (s.startsWith("0")) {
                    b = ((int) Math.pow(10, s.length())) / a;
                } else {
                    b = ((int) Math.pow(10, s.length() - 1)) / a;
                }
            }

            BigInteger ba = new BigInteger(a + "");
            BigInteger bb = new BigInteger(b + "");
            BigInteger t = ba.multiply(bb);
            String st = t.toString();
            while (!st.contains(s)) {
                bb = bb.add(BigInteger.ONE);
                t = ba.multiply(bb);
                st = t.toString();
            }
            System.out.println(bb.toString());
        }
    }
}
