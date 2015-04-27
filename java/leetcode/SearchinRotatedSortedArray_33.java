/**
 * hujiawei 15/4/25
 * <p/>
 * 查找
 * <p/>
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchinRotatedSortedArray_33 {

    public static void main(String[] args) {
        System.out.println(new SearchinRotatedSortedArray_33().search(new int[]{3, 5, 6, 7, 1, 2}, 2));
        //System.out.println(new SearchinRotatedSortedArray_33().search(new int[]{3, 1}, 0));
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {//首先处理等于的情况
                return mid;
            }
            if (nums[mid] <= nums[right]) {//右边部分是递增的
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {//左边部分是递增的
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }

}
