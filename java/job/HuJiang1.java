import java.util.Arrays;

/**
 * hujiawei 15/9/20
 */
public class HuJiang1 {

    public static void main(String[] args) {
        System.out.println(new HuJiang1().sumclose(new int[]{-1, 2, 1, -4}, 1));
    }

    public int sumclose(int[] num, int target) {
        int min = Integer.MAX_VALUE, result = 0;
        if (null == num || num.length < 3) return min;//[] not null
        Arrays.sort(num);

        int a, b, c, sum, len = num.length;
        for (int i = 0; i < len - 2; i++) {
            a = i;
            b = i + 1;
            c = len - 1;

            while (b < c) {
                sum = num[a] + num[b] + num[c];
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    result = sum;
                }
                if (sum < target) {
                    b++;
                } else if (sum > target) {
                    c--;
                } else {
                    return target;//
                }
            }
        }

        return result;
    }

}
