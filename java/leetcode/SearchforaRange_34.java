import java.util.Arrays;

/**
 * hujiawei - 15/3/24.
 * <p/>
 * 查找
 * <p/>
 * https://leetcode.com/problems/search-for-a-range/
 */
public class SearchforaRange_34 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SearchforaRange_34().searchRange(new int[]{6, 7, 8, 8, 9, 10}, 8)));
        System.out.println(Arrays.toString(new SearchforaRange_34().searchRange(new int[]{6, 6}, 6)));
        System.out.println(Arrays.toString(new SearchforaRange_34().searchRange(new int[]{1, 6}, 1)));
        System.out.println(Arrays.toString(new SearchforaRange_34().searchRange(new int[]{1}, 0)));
    }

    public int[] searchRange(int[] A, int target) {
        int left = lSearch(A, A.length, target);
        int right = rSearch(A, A.length, target);
        return new int[]{left, right};
    }

    // 参考网址 http://www.cnblogs.com/xinsheng/p/3510989.html
    //2. 二分法的框架, 需要考虑的位置有 3 个, 在代码中我标了出来, 分别为 q1, q2, q3
    //3. q1 是取 <= 还是取 <. 我的经验是, 若是题目要求找到 target, 那么就用 <=, 否则用 <. 我记得在二分搜索题时, 都是用 < 的
    //4. q2 比较容易, 考虑当 low == high 时, 我们希望游标往哪里走
    //5. q3, 返回 low/high. q3 的选取与 q2 有关. 还是需要考虑当 low == high 时, 游标会往哪走
    int lSearch(int[] A, int n, int target) {
        int low = 0, high = n - 1;
        while (low <= high) { // q1
            int mid = (low + high) >> 1;
            if (A[mid] < target) { // q2
                low = mid + 1;
            } else {//这里表示当low==high时向左走
                high = mid - 1;
            }
        }
        if (low < 0 || low >= n || A[low] != target)
            return -1;
        return low; // q3
    }

    int rSearch(int[] A, int n, int target) {
        int low = 0, high = n - 1;
        while (low <= high) { // q1
            int mid = (low + high) >> 1;
            if (A[mid] > target) { // q2
                high = mid - 1;
            } else {//这里表示当low==high时向右走
                low = mid + 1;
            }
        }
        if (high < 0 || high >= n || A[high] != target)
            return -1;
        return high; // q3
    }

    // 我的有错误版本
    private int searchRight(int[] A, int target) {
        int start = 0, end = A.length - 1, mid;
        while (start != end) {//
            mid = (start + end) / 2;
            //mid = start + (end - start + 1) / 2;
            if (A[mid] <= target) {
                start = mid + 1;//
            } else {
                end = mid;
            }
        }
        return start;
    }

    private int searchLeft(int[] A, int target) {
        int start = 0, end = A.length - 1, mid;
        while (start != end) {//
            mid = (start + end) / 2;//
            //mid = start + (end - start + 1) / 2;
            if (A[mid] < target) {//相等了也还是向左继续找
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

}
