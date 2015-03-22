import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * hujiawei - 15/3/22.
 * <p/>
 * 动规
 * <p/>
 * https://leetcode.com/problems/triangle/
 */
public class Triangle_120 {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<Integer>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        System.out.println(new Triangle_120().minimumTotal(list));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size(), n = triangle.get(m - 1).size();//
        List<Integer> list = triangle.get(m - 1);
        int[] f = new int[n];
        for (int k = 0; k < n; k++) {
            f[k] = list.get(k);
        }
        //System.out.println(Arrays.toString(f));

        for (int i = m - 2; i >= 0; i--) {//操作的次数
            list = triangle.get(i);
            for (int j = 0; j <= n + i - m; j++) {
                f[j] = list.get(j) + Math.min(f[j], f[j + 1]);
            }
            //System.out.println(Arrays.toString(f));
        }
        return f[0];
    }

}
