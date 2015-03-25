/**
 * hujiawei - 15/3/24.
 * <p/>
 * 查找
 * <p/>
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class Searcha2DMatrix_74 {

    public static void main(String[] args) {
        System.out.println(new Searcha2DMatrix_74().searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}}, 2));
        System.out.println(new Searcha2DMatrix_74().searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}}, 0));
        System.out.println(new Searcha2DMatrix_74().searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}}, 56));
        System.out.println(new Searcha2DMatrix_74().searchMatrix(new int[][]{
                {1},
                {2}}, 2));
    }

    // 很巧妙的解法，从右上角开始比较判断，如果大于目标值，那么就在该行向左找，如果小于目标值，那么就到该列下一行去找
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        while (row < m && col >= 0) {
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] < target)
                row++;
            else col--;
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        if (m <= 0) return false;
        int n = matrix[0].length;

        // 先确定是哪一行
        int start = 0, end = m - 1, mid;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (target > matrix[mid][0]) {
                start = mid + 1;
            } else if (target < matrix[mid][0]) {
                end = mid - 1;
            } else {
                return true;//遇到相等的话就直接可以返回了
            }
        }

        // 特殊情况处理
        int row = start;
        if (row >= m) {//处理为最后一行 0 <= start <= m
            row = m - 1;
        }
        if (matrix[row][0] > target) {//该行的第一个元素还是比目标值大，那么换为上一行
            row = row - 1;
        }
        if (row < 0) {//如果换为上一行变成了第一行前面，那么肯定没有这个目标值
            return false;
        }
        //System.out.println("row2=" + row);

        // 再确定是哪一列
        start = 0;
        end = n - 1;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (target > matrix[row][mid]) {
                start = mid + 1;
            } else if (target < matrix[row][mid]) {
                end = mid - 1;
            } else {
                return true;//遇到相等的话就直接可以返回了
            }
        }

        return start < n && matrix[row][start] == target;//注意start有可能超出范围
    }

}
