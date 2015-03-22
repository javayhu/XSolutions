/**
 * hujiawei - 15/3/21.
 * <p/>
 * 动规
 * <p/>
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum_64 {

    public static void main(String[] args) {
        int[][] grid = new int[1][1];
        grid[0][0] = 1;
        System.out.println(new MinimumPathSum_64().minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] f = new int[m][n];//f[i][j]表示到(i,j)的最小路径和
        f[0][0] = grid[0][0];//数据初始化
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];//一直竖着走
        }
        for (int j = 1; j < n; j++) {
            f[0][j] = f[0][j - 1] + grid[0][j];//一直横着走
        }

        for (int i = 1; i < m; i++) {//行
            for (int j = 1; j < n; j++) {//列
                f[i][j] = grid[i][j] + Math.min(f[i - 1][j], f[i][j - 1]);
            }
        }

        return f[m - 1][n - 1];//注意结果是f[m - 1][n - 1]
    }

}
