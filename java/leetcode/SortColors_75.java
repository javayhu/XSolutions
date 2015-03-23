import sun.misc.Sort;

import java.util.Arrays;

/**
 * hujiawei - 15/3/24.
 * <p/>
 * 排序
 * <p/>
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors_75 {

    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 0, 2, 1, 0, 2, 1, 0};
        new SortColors_75().sortColors(A);
        System.out.println(Arrays.toString(A));
    }

    public void sortColors(int[] A) {
        // 一个是red的index，一个是blue的index，两边往中间走
        // 其实red（或者blue）代表的是当有0（或者2）要放的话，red（或者blue）真是那个可以放的位置
        int red = 0, blue = A.length - 1;

        for (int i = 0; i < blue + 1; ) {//不用超过blue，因为后面的元素都是放好的（2）
            if (A[i] == 0)
                swap(A, i++, red++);
            else if (A[i] == 2)
                swap(A, i, blue--);
            else
                i++;
        }
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

}
