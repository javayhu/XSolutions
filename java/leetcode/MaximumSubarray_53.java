/**
 * hujiawei - 10/18/14.
 * <p/>
 * 动规 最大子数组之和
 * <p/>
 * https://oj.leetcode.com/problems/maximum-subarray/
 */

public class MaximumSubarray_53 {

    public static void main(String[] args) {
        System.out.print(new MaximumSubarray_53().maxSubArray(new int[]{1, 2}));
    }

    public int maxSubArray(int[] A) {
        if (A.length == 1) return A[0];
        int global = A[0];
        int local = A[0];
        for (int i = 1; i < A.length; i++) {
            //前者是从i开始重新计算，后者是将A[i]加入到前面的子数组中
            local = Math.max(A[i], local + A[i]);
            global = Math.max(global, local);//更新全局最大值
        }
        return global;
    }

}
