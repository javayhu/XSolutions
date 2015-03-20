/**
 * Created by hujiawei on 10/17/14.
 */

//https://oj.leetcode.com/problems/maximum-product-subarray/

/**
 * https://oj.leetcode.com/discuss/11923/sharing-my-solution-o-1-space-o-n-running-time
 * 没有必要动态规划，因为不需要给出具体的位置，只要给出最大的乘积即可
 * 直接遍历一遍数组即可
 */

public class MaximumProductSubarray {

    public static void main(String[] args) {
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{-5, 2, 4, 1, -2, 2, -6, 3, -1, -1, -1, -2, -3, 5, 1, -3, -4, 2, -4, 6, -1, 5}));
    }

    public int maxProduct(int[] A) {
        int maxherepre = A[0];
        int minherepre = A[0];
        int maxhere = A[0];
        int minhere = A[0];
        int maxsofar = A[0];

        for (int i = 1; i < A.length; i++) {
            maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]);
            minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);
            maxsofar = Math.max(maxhere, maxsofar);
            maxherepre = maxhere;
            minherepre = minhere;
        }

        return maxsofar;
    }

}

//动规：超时
//public int maxProduct(int[] A) {
//    int len = A.length;
//    int[][] s = new int[len][len];
//    int[][] t = new int[len][len];
//    int[][] r = new int[len][len];
//    int l = 0, i = 0, j = 0;
//    for (l = 0; l < len; l++) {
//        for (i = 0; i < len - l; i++) {
//            if (l == 0) {
//                r[i][i] = A[i];
//                s[i][i] = i;
//                t[i][i] = i;
//            } else {
//                j = l + i;
//                if (r[i][j - 1] > r[i + 1][j]) {
//                    r[i][j] = r[i][j - 1];
//                    s[i][j] = s[i][j - 1];
//                    t[i][j] = t[i][j - 1];
//                } else {
//                    r[i][j] = r[i + 1][j];
//                    s[i][j] = s[i + 1][j];
//                    t[i][j] = t[i + 1][j];
//                }
//                if (t[i][j - 1] == j - 1 && r[i][j - 1] * A[j] >= r[i][j]) {
//                    r[i][j] = r[i][j - 1] * A[j];
//                    s[i][j] = s[i][j - 1];
//                    t[i][j] = j;
//                }
//                if (s[i + 1][j] == i + 1 && r[i + 1][j] * A[i] >= r[i][j]) {
//                    r[i][j] = r[i + 1][j] * A[i];
//                    s[i][j] = i;
//                    t[i][j] = t[i + 1][j];
//                }
//            }
//        }
//    }
//    return r[0][len - 1];
//}