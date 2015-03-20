/**
 * Created by hujiawei on 10/17/14.
 */

//https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/

/**
 * 1.去掉首项和末项，中间部分使用二分查找，如果没有找到的话是加入首项和末项进行比较，谁最小就是最小项
 */

/**
 * 2.加入双向循环比较策略，首项和左边项比较时用末项比较，末项和右边项比较时用首项比较
 * 因为原有数组是进行了rotate操作的
 */

public class FindMinimuminRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(new FindMinimuminRotatedSortedArray().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    public int findMin(int[] num) {
        int len = num.length;
        if (len == 1) {
            return num[0];
        } else if (len == 2) {
            return Math.min(num[0], num[1]);
        }
        int min = subFindMin(num, 0, len - 1);
        return min;
    }

    private int subFindMin(int[] num, int start, int end) {
        if (start > end) return Integer.MAX_VALUE;
        int mid = (end + start) / 2;
        int left = mid - 1, right = mid + 1;
        if (left < 0) left = num.length - 1;
        if (right >= num.length) right = 0;
        if (((num[left] < num[mid]) && (num[mid] > num[right]))) {// a<b>c -> min(c,a)
            return Math.min(num[left], num[right]);
        } else if (((num[left] > num[mid]) && (num[mid] < num[right]))) {//a>b<c -> b
            return num[mid];
        }
        //recursive
        int min1 = subFindMin(num, start, mid - 1);
        if (min1 != Integer.MAX_VALUE) {
            return min1;
        }
        int min2 = subFindMin(num, mid + 1, end);
        if (min2 != Integer.MAX_VALUE) {
            return min2;
        }
        return Integer.MAX_VALUE;//not found
    }

}
