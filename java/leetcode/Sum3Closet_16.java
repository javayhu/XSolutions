import java.util.Arrays;

/**
 * hujiawei, 15/3/28
 * <p/>
 * 数组
 * <p/>
 * https://leetcode.com/problems/3sum-closest/
 */
public class Sum3Closet_16 {

    public static void main(String[] args) {
        System.out.println(new Sum3Closet_16().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public int threeSumClosest(int[] num, int target) {
        int min = Integer.MAX_VALUE, result = 0;
        if (null == num || num.length < 3) return min;//[] not null
        Arrays.sort(num);

        int a, b, c, len = num.length;
        for (int i = 0; i < len - 2; i++) {
            a = i;
            b = i + 1;
            c = len - 1;

            while (b < c) {
                if (Math.abs(num[a] + num[b] + num[c] - target) < min) {
                    min = Math.abs(num[a] + num[b] + num[c] - target);
                    result = num[a] + num[b] + num[c];
                }
                if (num[a] + num[b] + num[c] < target) {
                    b++;
                } else if (num[a] + num[b] + num[c] > target) {
                    c--;
                } else {
                    return target;//
                }
            }
        }

        return result;
    }

}
