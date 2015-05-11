/**
 * hujiawei 15/5/2
 * <p/>
 * 动规
 * <p/>
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths_62 {

    public static void main(String[] args) {
        System.out.println(new UniquePaths_62().uniquePaths(3,2));
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
