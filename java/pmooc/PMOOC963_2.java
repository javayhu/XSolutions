import java.util.*;

/**
 * hujiawei - 14/11/4.
 */

//http://dsalgo.openjudge.cn/linearlists/5/

//this is a wrong method!!! acaac acaac a:6 c:4   t=10/gcd(6,4)=5

public class PMOOC963_2 {

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
        boolean flag;
        String prefix;
        int min, offset = 0, t = 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();//char and times
        map.put(chars[0], 1);//put the first char
        for (int l = 1; l < len; l++) {
            if (map.containsKey(chars[l])) {
                map.put(chars[l], map.get(chars[l]) + 1);//add one
            } else {
                map.put(chars[l], 1);
            }
            if (map.entrySet().size() == 1) {//currently only one char
                System.out.println((l + 1) + " " + (l + 1));
                continue;
            }
            //actually here can be more efficient
            min = Integer.MAX_VALUE;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() < min) {
                    min = entry.getValue();//the char which occurs the min times
                }
            }
            if (min < 2 || (l + 1) % min != 0) {//impossible
                continue;
            } else {//maybe
                flag = true;
                //if (min % 2 == 0) {//TODO here how to determine the right 'min'
                //    min = min / 2;
                //}
                t = (l + 1) / min;//suppose the length of prefix is t!!!
                prefix = s.substring(0, t);
                offset = t;
                while (offset < (l + 1)) {
                    if (!s.startsWith(prefix, offset)) {
                        flag = false;
                        break;
                    }
                    offset += t;
                }
                if (flag) {
                    System.out.println((l + 1) + " " + min);
                }
            }
        }
    }

}
