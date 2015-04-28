import java.util.Arrays;

/**
 * hujiawei 15/4/27
 * <p/>
 * 数组
 * <p/>
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne_66 {

    public static void main(String[] args) {
        int[] res = new PlusOne_66().plusOne(new int[]{1, 2, 3, 9});
        System.out.println(Arrays.toString(res));
    }

    public int[] plusOne(int[] digits) {
        int k = digits.length - 1;
        for (; k >= 0; k--)
            if (digits[k] != 9) break;

        if (k == -1) {
            int newDigits[] = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        } else {
            int newDigits[] = new int[digits.length];
            //for (int i = 0; i <= k; i++)
            //    newDigits[i] = digits[i];
            System.arraycopy(digits, 0, newDigits, 0, k + 1);
            newDigits[k]++;
            return newDigits;
        }
    }

}
