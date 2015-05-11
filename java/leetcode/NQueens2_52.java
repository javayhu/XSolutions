/**
 * hujiawei 15/5/2
 * <p/>
 * dfs
 * <p/>
 * https://leetcode.com/problems/n-queens-ii/
 */
public class NQueens2_52 {

    public static void main(String[] args) {
        System.out.println(new NQueens2_52().totalNQueens(4));
    }

    public int totalNQueens(int n) {
        if (n <= 0) return 0;
        path = new int[n];
        dfs(n, 0);
        return result;
    }

    int result;
    int[] path;

    //row表示当前处理第row行
    private void dfs(int n, int row) {
        if (row == n) {//到了这一行说明前面放置好了已经
            result++;
        } else {//每次只要考虑当前行皇后放在哪一列可以就行了
            for (int i = 0; i < n; i++) {
                path[row] = i;
                if (check(row)) {
                    dfs(n, row + 1);
                }
            }
        }
    }

    private boolean check(int row) {//检查第row行是否可行
        for (int i = 0; i < row; i++) {
            if (path[i] == path[row] || Math.abs(row - i) == Math.abs(path[i] - path[row])) {
                return false;
            }
        }
        return true;
    }

}
