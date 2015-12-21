import java.util.ArrayList;
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

    public String getPermutation1(int n, int k) {
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

    public String getPermutation(int n, int k) {

        // initialize all numbers
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            numberList.add(i);
        }

        // change k to be index
        k--;

        // set factorial of n
        int mod = 1;
        for (int i = 1; i <= n; i++) {
            mod = mod * i;
        }

        String result = "";

        // find sequence
        for (int i = 0; i < n; i++) {
            mod = mod / (n - i);
            // find the right number(curIndex) of
            int curIndex = k / mod;
            // update k
            k = k % mod;

            // get number according to curIndex
            result += numberList.get(curIndex);
            // remove from list
            numberList.remove(curIndex);
        }

        return result.toString();
    }

}
