import java.util.Arrays;

/**
 * hujiawei - 15/3/15.
 * <p/>
 * <p/>
 * https://leetcode.com/problems/next-permutation/
 *
 * Wrong Answer
 *
 * Input:	[1,3,2]
 * Output:	[3,1,2]
 * Expected:[2,1,3]
 */
public class NextPermutation_31_wa {

    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3};
        new NextPermutation_31_wa().nextPermutation(num);
        System.out.print(Arrays.toString(num));
        num = new int[]{3, 2, 1};
        new NextPermutation_31_wa().nextPermutation(num);
        System.out.print(Arrays.toString(num));
        num = new int[]{1, 3, 2};
        new NextPermutation_31_wa().nextPermutation(num);
        System.out.print(Arrays.toString(num));
    }

    public void nextPermutation(int[] num) {
        int p = num.length - 1, t;

        // 错误的原因在于这里，如果后面的元素A[i]大于前面的元素A[i-1]，并不是直接交换这两个元素
        // 而是从A[i]开始一直到最后的元素A[n-1]中找出最小的并且大于A[i-1]的元素与A[i-1]交换
        // 剩下的就是将交换后的位置为[i-1]后的元素倒置过来(变成升序)
        while ((p > 0)) {
            if (num[p] > num[p - 1]) {//后面的元素大于前面的元素
                t = num[p - 1];
                num[p - 1] = num[p];
                num[p] = t;
                return;
            }
            p--;
        }
        //不存在上面的情况，反转数组即可
        int l = 0, r = num.length - 1;
        while ((l < r)) {
            t = num[l];
            num[l] = num[r];
            num[r] = t;
            l++;
            r--;
        }
    }

}
