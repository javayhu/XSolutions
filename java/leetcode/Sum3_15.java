import java.util.*;

/**
 * hujiawei - 15/3/24.
 * <p/>
 * 数组
 * <p/>
 * https://leetcode.com/problems/3sum/
 */
public class Sum3_15 {

    public static void main(String[] args) {
        System.out.println(new Sum3_15().threeSum(new int[]{0, 0, 0}));
        //System.out.println(new Sum3_15().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (null == num || num.length < 3) return result;//[] not null
        List<Triplet> triplets = new ArrayList<Triplet>();
        Arrays.sort(num);

        int a, b, c;
        int target = 0, len = num.length;
        for (int i = 0; i < len - 2; i++) {
            a = i;
            b = i + 1;
            c = len - 1;

            while (b < c) {
                if (num[a] + num[b] + num[c] < target) {
                    b++;
                } else if (num[a] + num[b] + num[c] > target) {
                    c--;
                } else {
                    Triplet triplet = new Triplet(num[a], num[b], num[c]);
                    if (!triplets.contains(triplet)) {
                        triplets.add(triplet);
                        result.add(triplet.getList());
                    }
                    b++;
                    c--;
                }
            }
        }

        return result;
    }

    static class Triplet {
        int a, b, c;

        Triplet(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public List<Integer> getList() {
            List<Integer> list = new ArrayList<Integer>();
            list.add(a);
            list.add(b);
            list.add(c);
            return list;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Triplet triplet = (Triplet) o;

            if (a != triplet.a) return false;
            if (b != triplet.b) return false;
            if (c != triplet.c) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            result = 31 * result + c;
            return result;
        }
    }
}
