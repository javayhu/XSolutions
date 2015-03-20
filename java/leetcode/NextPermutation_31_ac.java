import java.util.Arrays;

/**
 * hujiawei - 15/3/15.
 * <p/>
 * 数组
 * <p/>
 * https://leetcode.com/problems/next-permutation/
 * <p/>
 * AC
 */
public class NextPermutation_31_ac {

    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3};
        new NextPermutation_31_ac().nextPermutation(num);
        System.out.print(Arrays.toString(num));
        num = new int[]{3, 2, 1};
        new NextPermutation_31_ac().nextPermutation(num);
        System.out.print(Arrays.toString(num));
        num = new int[]{1, 3, 2};
        new NextPermutation_31_ac().nextPermutation(num);
        System.out.print(Arrays.toString(num));
    }

    public void nextPermutation(int[] num) {
        int p = num.length - 1, k;

        while ((p > 0)) {
            if (num[p] > num[p - 1]) {//后面的元素大于前面的元素
                // 找到从p到末尾的最小的但是大于num[p-1]的元素的位置
                for (k = num.length - 1; k >= p; k--) {
                    if (num[k] > num[p - 1]) {
                        break;
                    }
                }
                // 将这个元素和p-1位置的元素进行交换
                swap(num, p - 1, k);
                // 将p-1位置之后的所有元素进行反转
                reverse(num, p, num.length - 1);
                return;
            }
            p--;
        }
        //不存在上面的情况，反转数组即可
        reverse(num, 0, num.length - 1);
    }

    // 将数组从l到r（两边都包括）进行反转
    private void reverse(int[] num, int l, int r) {
        while ((l < r)) {
            swap(num, l, r);
            l++;
            r--;
        }
    }

    // 交换数组位置i和位置j上的元素
    private void swap(int[] num, int i, int j) {
        int t = num[j];
        num[j] = num[i];
        num[i] = t;
    }

}
