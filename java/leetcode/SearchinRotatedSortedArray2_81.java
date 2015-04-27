/**
 * hujiawei 15/4/26
 * <p/>
 * 查找
 * <p/>
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchinRotatedSortedArray2_81 {

    public static void main(String[] args) {
        System.out.println(new SearchinRotatedSortedArray2_81().search(new int[]{2, 5, 6, 0, 1, 2}, 2));
        //System.out.println(new SearchinRotatedSortedArray_33().search(new int[]{3, 1}, 0));
    }

    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {//首先处理等于的情况
                return true;//mid
            }
            if (nums[mid] < nums[left]) {//
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[left]) {//
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {//nums[mid] == nums[left]
                left++;
            }
        }
        return nums[left] == target ? true : false;//nums[left] == target ? left : -1
    }

}
