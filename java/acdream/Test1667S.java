import java.math.BigInteger;
import java.util.*;
import java.io.*;

//http://acdream.info/problem?pid=1667

//http://mathlover.info/archives/acdream_java#comment-4148

//

public class Test1667S {

    public static void main(String arg[]) throws IOException {
        Scanner in = new Scanner(System.in);
        BigInteger ans[] = new BigInteger[1005];
        ans[0] = BigInteger.ONE;
        ans[1] = BigInteger.ONE;
        for (int i = 2; i <= 1000; ++i)
            ans[i] = ans[i - 1].multiply(BigInteger.valueOf(2 * i + 1)).add(ans[i - 2].multiply(BigInteger.valueOf(3 * i - 3))).divide(BigInteger.valueOf(i + 2));
        while (in.hasNext()) {
            int n = in.nextInt();
            byte[] buff = (String.valueOf(ans[n]) + "\n").getBytes();
            System.out.write(buff);
        }
    }
}