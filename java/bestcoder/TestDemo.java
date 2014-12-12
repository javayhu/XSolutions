import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * hujiawei - 14/11/8.
 */
public class TestDemo {

    public static void main(String[] args) {

        System.out.println("659115".contains("911"));

        int a = 1000000;
        BigInteger ba = new BigInteger(a+"");
        BigInteger bb = new BigInteger(a+"");
        System.out.println(ba.multiply(bb).toString());

        //int[] vs = new int[]{1, 2, 3, 4, 6, 7};
        //int index = Arrays.binarySearch(vs,5);
        //if (index < 0) index = -index - 2;
        //System.out.println(index);
        //Math.sqrt()

        //System.out.println(bs_f(vs, 0));
        //System.out.println(bs_f(vs, 3));
        //System.out.println(bs_f(vs, 7));//
        //System.out.println(bs_f(vs, 8));
        //
        //System.out.println("---");
        //vs = new int[]{1, 2, 3, 3, 4, 6, 7};
        //System.out.println(bs_f(vs, 0));
        //System.out.println(bs_f(vs, 3));
        //System.out.println(bs_f(vs, 7));
        //System.out.println(bs_f(vs, 8));
        //
        //System.out.println("......");
        //
        //ArrayList list = new ArrayList();
        //list.add(1);
        //list.add(2);
        //list.add(3);
        //list.add(4);
        //list.add(5);
        //list.add(6);
        //List sublist = list.subList(0, 0);
        //System.out.println(sublist.size());

    }

    private static int bs_f(int[] vs, int r) {
        int len = vs.length;
        int left = 0, right = len - 1, mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (r < vs[mid]) {
                right = mid - 1;
            } else if (r >= vs[mid]) {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int bs_t(int[] vs, int r) {
        int len = vs.length;
        int left = 0, right = len - 1, mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (r <= vs[mid]) {
                right = mid - 1;
            } else if (r > vs[mid]) {
                left = mid + 1;
            }
        }
        return left;
    }


    //得到一个数组从from到end之间满足大于等于r的数字的个数
    private static int bs(int[] vs, int r, int from, int end) {
        int len = end - from + 1;//
        if (len <= 0) return 0;
        int left = from, right = end, mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (r <= vs[mid]) {
                right = mid - 1;
            } else if (r > vs[mid]) {
                left = mid + 1;
            }
        }
        System.out.println("left=" + left + " right=" + right);
        return end - left + 1;
    }

}
