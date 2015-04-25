import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * hujiawei 15/3/28
 * <p/>
 * 数组
 * <p/>
 * https://leetcode.com/problems/4sum/
 */
public class Sum4_18 {

    public static void main(String[] args) {
        System.out.println(new Sum4_18().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    // 超时
    public List<List<Integer>> fourSum(int[] num, int target) {
        int len = num.length;
        Arrays.sort(num);
        List<TwoSum> cache = new ArrayList<TwoSum>();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                cache.add(new TwoSum(i, j, num[i] + num[j]));//数组元素i和元素j，以及它们的和
            }
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Quadruplet> quadruplets = new ArrayList<Quadruplet>();

        len = cache.size();//cache实际上是排好序的
        for (int i = 0; i < len - 1; i++) {
            //这里还要继续优化！根据first和target计算出second的sum然后找出等于该值的范围
            TwoSum first = cache.get(i);
            //Integer key = target - first.sum;
            //Collections.binarySearch(cache, key);
            for (int j = i + 1; j < len; j++) {
                TwoSum second = cache.get(j);
                if (first.sum + second.sum == target) {
                    if (first.i != second.i && first.i != second.j && first.j != second.i && first.j != second.j) {
                        Quadruplet quardruplet = new Quadruplet(num[first.i], num[first.j], num[second.i], num[second.j]);
                        if (!quadruplets.contains(quardruplet)) {
                            quadruplets.add(quardruplet);
                            result.add(quardruplet.getList());
                        }
                    }
                }
            }
        }

        return result;
    }

    static class Quadruplet {
        int a, b, c, d;

        Quadruplet(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        public List<Integer> getList() {
            List<Integer> list = new ArrayList<Integer>();
            list.add(a);
            list.add(b);
            list.add(c);
            list.add(d);
            return list;
        }

        @Override
        public String toString() {
            int[] nums = new int[]{a, b, c, d};
            Arrays.sort(nums);
            return "Quadruplet{" +
                    "a=" + nums[0] +
                    ", b=" + nums[1] +
                    ", c=" + nums[2] +
                    ", d=" + nums[3] +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Quadruplet that = (Quadruplet) o;
            return (this.toString().equals(that.toString()));
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            result = 31 * result + c;
            result = 31 * result + d;
            return result;
        }
    }

    static class TwoSum {
        int i, j, sum;

        TwoSum(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }

}
