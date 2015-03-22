/**
 * hujiawei - 10/18/14.
 */

//https://oj.leetcode.com/problems/maximum-subarray/

//最大子数组之和

public class MaximumSubarray_53 {

    public static void main(String[] args) {
        System.out.print(new MaximumSubarray_53().maxSubArray(new int[]{1,2}));
    }

    public int maxSubArray(int[] A) {
        if (A.length == 1) return A[0];
        int global = A[0];
        int local = A[0];
        for (int i = 1; i < A.length; i++) {
            local = Math.max(A[i], local + A[i]);
            global = Math.max(global, local);
        }
        return global;
    }

}
