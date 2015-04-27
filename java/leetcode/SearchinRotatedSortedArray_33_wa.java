/**
 * hujiawei 15/4/25
 * <p/>
 * 查找
 * <p/>
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchinRotatedSortedArray_33_wa {

    public static void main(String[] args) {
        System.out.println(new SearchinRotatedSortedArray_33_wa().search(new int[]{3, 5, 6, 7, 1, 2}, 2));
    }

    public int search(int[] nums, int target) {
        return searchInRange(nums, target, 0, nums.length - 1);
    }

    // 错误的解法，例如测试例子，{3, 5, 6, 7, 1, 2}, 2，对于中间值6，虽然右边7比它大，但是因为数组是翻转了的，右边还是有可能存在比中间值6更小的数字
    public int searchInRange(int[] nums, int target, int left, int right) {
        if (left > right || (left == right && nums[left] != target)) {
            return -1;
        }
        int mid = (left + right) / 2, resRight = -1, resLeft = -1;
        if (nums[mid] == target) {//找到了
            return mid;//index
        } else if (nums[mid] > target) {//中间值比目标值大
            if (mid + 1 < nums.length && nums[mid + 1] <= nums[mid]) {//如果中间值右边的数字比中间值小
                resRight = searchInRange(nums, target, mid + 1, right);
                if (resRight != -1) return resRight;
            }//注意这里，向左或者向右查找之间不是if-else的关系
            if (mid - 1 >= 0 && nums[mid - 1] <= nums[mid]) {//如果中间值左边的数字比中间值小
                resLeft = searchInRange(nums, target, left, mid - 1);
                if (resLeft != -1) return resLeft;
            }
        } else {//中间值比目标值小
            if (mid + 1 < nums.length && nums[mid + 1] >= nums[mid]) {//如果中间值右边的数字比中间值大
                resRight = searchInRange(nums, target, mid + 1, right);
                if (resRight != -1) return resRight;
            }
            if (mid - 1 >= 0 && nums[mid - 1] >= nums[mid]) {//如果中间值左边的数字比中间值大
                resLeft = searchInRange(nums, target, left, mid - 1);
                if (resLeft != -1) return resLeft;
            }
        }
        return -1;
    }
}
