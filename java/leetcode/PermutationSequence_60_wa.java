import java.util.Arrays;

/**
 * hujiawei 15/3/28
 * <p/>
 * 数组 no
 * <p/>
 * https://leetcode.com/problems/permutation-sequence/
 */
public class PermutationSequence_60_wa {

    public static void main(String[] args) {
        System.out.println(new PermutationSequence_60_wa().getPermutation(4, 2));
    }

    public String getPermutation(int n, int k) {
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i] = i * f[i - 1];
        }
        System.out.println(Arrays.toString(f));

        char[] result = new char[n];
        //for (int i = 0; i < n; i++) {
        //    result[i] = (char) ('1' + i);
        //}
        int d;
        for (int i = n - 1; i >= 0; i--) {
            d = k / f[i];
            k = k % f[i];
            result[i] = (char) ('1' + d);
        }

        return new String(result);
    }

}
