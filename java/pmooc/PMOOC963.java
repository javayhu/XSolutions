import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * hujiawei - 14/11/2.
 */

//http://dsalgo.openjudge.cn/linearlists/5/

//Time Limit Exceeded

public class PMOOC963 {

    private static final Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {
        int len = 0, count = 1;
        while ((len = cin.nextInt()) != 0) {
            System.out.println("Test case #" + (count++));
            dealString(cin.next().trim());
            System.out.println();
        }
    }

    private static void dealString(String s) {
        int len = s.length();
        if (len <= 1) return;
        int offset;
        boolean flag;
        String prefix, substr;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //start from prefix with length = 2, end with the whole string
        for (int l = 2; l <= len; l++) {
            prefix = s.substring(0, l);
            for (int t = 1; t <= l / 2; t++) {
                if (l % t == 0) {
                    offset = 0;
                    if (map.containsKey(t)) {//quickly move the offset
                        offset = map.get(t);
                    }
                    flag = true;
                    substr = prefix.substring(0, t);
                    while (offset < l) {
                        if (prefix.startsWith(substr, offset)) {
                            offset += t;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {//prefix with length l have multiple (t) substr
                        map.put(t, l);//old one will be override
                        System.out.println(l + " " + l / t);
                        break;
                    }
                }
            }
        }
    }

}
