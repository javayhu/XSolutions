/**
 * hujiawei - 15/3/22.
 * <p/>
 * 数组 排序
 * <p/>
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray_88 {

    public static void main(String[] args) {

    }

    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1, j = n - 1, index = m + n - 1;
        while (i >= 0 && j >= 0) {
            A[index--] = A[i] > B[j] ? A[i--] : B[j--];
        }
        while (i >= 0) A[index--] = A[i--];
        while (j >= 0) A[index--] = B[j--];
    }

}
