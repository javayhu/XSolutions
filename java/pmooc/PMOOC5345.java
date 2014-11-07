import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * hujiawei - 14/11/2.
 */

//http://dsalgo.openjudge.cn/linearlists/3/

public class PMOOC5345 {

    private static final Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {
        int n = cin.nextInt();
        int m = cin.nextInt();
        ArrayList list = new ArrayList();
        while (n-- > 0) {
            list.add(cin.nextInt());
        }
        while (m-- > 0) {
            if (cin.next().trim().equalsIgnoreCase("Q")) {
                doQ(list, cin.nextInt());
            } else {
                doC(list, cin.nextInt());
            }
        }
    }

    private static void doC(ArrayList list, int d) {
        int item;
        for (int i = 0, size = list.size(); i < size; i++) {
            item = ((Integer) list.get(i)).intValue() + d;
            if (item > 65535) {
                item = item % 65535;
            }
            list.set(i, item);
        }
    }

    private static void doQ(ArrayList list, int d) {
        int item, result = 0;
        for (int i = 0, size = list.size(); i < size; i++) {
            item = ((Integer) list.get(i)).intValue();
            if (((((item >> d) & 0x1)) == 1) ) {// && (((item << (32-d)) & 0x1)) == 1
                result++;
            }
        }
        System.out.println(result);
    }

}
