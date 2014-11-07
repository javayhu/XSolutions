import java.util.Scanner;

/**
 * hujiawei - 14/11/2.
 */

//http://dsalgo.openjudge.cn/linearlists/2/

public class PMOOC1936 {

    private static final Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {
        String line, str, substr;
        String[] tokens = new String[2];
        while ((line = cin.nextLine()) != null) {
            tokens = line.split(" ");
            str = tokens[0];
            substr = tokens[1];
            dealString(str, substr);
        }
    }

    private static void dealString(String str, String substr) {
        int len = str.length();
        int maxindex = 0;
        int max = str.charAt(0);
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) > max) {
                max = str.charAt(i);
                maxindex = i;
            }
        }
        String result = str.substring(0, maxindex + 1) + substr + str.substring(maxindex + 1);
        System.out.println(result);
    }

}
