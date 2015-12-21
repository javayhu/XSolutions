import java.util.ArrayList;
import java.util.List;

/**
 * hujiawei 15/9/15
 */
public class WanDouJia {

    private static List<Character> characters;

    public static void main(String[] args) {
        characters = new ArrayList<Character>();
        characters.add('0');
        characters.add('1');
        characters.add('2');
        characters.add('3');
        characters.add('4');
        characters.add('5');
        characters.add('6');
        characters.add('7');
        characters.add('8');
        characters.add('9');

        String s1 = "-123";
        String s2 = "3456";
        String s3 = "+6898";
        String s4 = "1*23";

        try {
            System.out.println(parseLong(s1));
            System.out.println(parseLong(s2));
            System.out.println(parseLong(s3));
            System.out.println(parseLong(s4));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static long parseLong(String s) throws Exception {
        char[] chars = s.toCharArray();
        long sum = 0;
        int c = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 && (chars[0] == '-' || chars[0] == '+')) {
                continue;
            } else if (!characters.contains(chars[i])) {
                throw new Exception("can not parse this string");
            }
            c = chars[i] - '0';
            sum = sum * 10 + c;
        }
        if (chars[0] == '-') sum = -sum;
        return sum;
    }

}
