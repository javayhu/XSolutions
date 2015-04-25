/**
 * hujiawei 15/4/24
 * <p/>
 * 数组
 * <p/>
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 参考https://leetcode.com/discuss/28491/java-log-m-n-by-recursion
 */
public class MedianofTwoSortedArrays_4 {

    public static void main(String[] args) {
        //int[] a = new int[]{1, 2, 3, 4};
        //int[] b = new int[]{1, 2, 3, 4, 5};
        int[] a = new int[]{1};
        int[] b = new int[]{};
        System.out.println(new MedianofTwoSortedArrays_4().findMedianSortedArrays(a, b));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {//奇数个数字
            return findMedianSortedArrays(nums1, 0, nums1.length, nums2, 0, nums2.length, len / 2 + 1);
        } else {
            return (findMedianSortedArrays(nums1, 0, nums1.length, nums2, 0, nums2.length, len / 2 + 1) + findMedianSortedArrays(nums1, 0, nums1.length, nums2, 0, nums2.length, len / 2)) / 2;
        }
    }

    private double findMedianSortedArrays(int[] a, int aStart, int aEnd, int[] b, int bStart, int bEnd, int k) {
        if (aEnd - aStart > bEnd - bStart) {//保证数组a是较短的那个数组
            return findMedianSortedArrays(b, bStart, bEnd, a, aStart, aEnd, k);
        }
        if (aEnd == aStart) {//数组a是空数组
            return b[bStart + k - 1];
        }
        if (k == 1) {//很重要
            return a[aStart] < b[bStart] ? a[aStart] : b[bStart];//数组a和b肯定至少有一个元素
        }

        int pa = aEnd - aStart > k / 2 ? k / 2 : aEnd - aStart;//取a[aStart+0] -> a[aStart+pa-1] 共pa个数字
        int pb = k - pa;//取b[bStart+0] -> b[bStart+pb-1] 共pb个数字
        if (a[aStart + pa - 1] == b[bStart + pb - 1]) {
            return a[aStart + pa - 1];
        } else if (a[aStart + pa - 1] > b[bStart + pb - 1]) {
            return findMedianSortedArrays(a, aStart, aEnd, b, bStart + pb, bEnd, k - pb);
        } else {
            return findMedianSortedArrays(a, aStart + pa, aEnd, b, bStart, bEnd, k - pa);
        }
    }

}
