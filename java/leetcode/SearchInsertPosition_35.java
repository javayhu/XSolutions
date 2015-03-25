/**
 * hujiawei - 15/3/24.
 * <p/>
 * 查找
 * <p/>
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition_35 {

    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition_35().searchInsert(new int[]{1,2,3},1));
        System.out.println(new SearchInsertPosition_35().searchInsert(new int[]{0,2,3},1));
        System.out.println(new SearchInsertPosition_35().searchInsert(new int[]{1,2,3},4));
        System.out.println(new SearchInsertPosition_35().searchInsert(new int[]{2,2,3},1));
    }

    public int searchInsert(int[] A, int target) {
        int start = 0, end = A.length - 1, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (target > A[mid]) {
                start = mid + 1;
            } else {//向左走
                end = mid - 1;
            }
        }
        return start;
    }

}
