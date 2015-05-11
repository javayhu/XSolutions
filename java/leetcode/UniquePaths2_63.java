/**
 * hujiawei 15/5/2
 * <p/>
 * 动规
 * <p/>
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePaths2_63 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1,0},{0,0,0},{0,1,0}};
        System.out.println(new UniquePaths2_63().uniquePathsWithObstacles(grid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;//为null或者空都不行

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] f = new int[m][n];

        for (int i = 0; i < n; i++) {//第一行
            if (obstacleGrid[0][i] == 1) {
                break;//跳出来，后面的位置都是不能达到
            } else {
                f[0][i] = 1;
            }
        }
        for (int i = 0; i < m; i++) {//第一列
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                f[i][0] = 1;
            }
        }

        for (int i = 1; i < m; i++) {//行
            for (int j = 1; j < n; j++) {//列
                if (obstacleGrid[i][j] == 1) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }

        return f[m - 1][n - 1];
    }

    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];

        for (int i = 0; i < n; i++) {//第一行
            f[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {//第一列
            f[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {//行
            for (int j = 1; j < n; j++) {//列
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }

        return f[m - 1][n - 1];
    }

}
