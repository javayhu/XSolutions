import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * hujiawei 15/5/2
 * <p/>
 * dfs
 * <p/>
 * https://leetcode.com/problems/n-queens/
 */
public class NQueens_51 {

    public static void main(String[] args) {
        List<String[]> result = new NQueens_51().solveNQueens(4);
        System.out.println(result.size());
    }

    int[] path;

    //n皇后题目有个特点，每行肯定有且只有一个皇后
    //java解法 http://www.acmerblog.com/leetcode-solution-n-queens-6254.html
    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        if (n <= 0) return result;
        //int[][] matrix = new int[n][n];//不用二维数组，只用一维数组就可以保存棋盘状态
        path = new int[n];
        dfs(result, n, 0);
        return result;
    }

    //row表示当前处理第row行
    private void dfs(List<String[]> result, int n, int row) {
        if (row == n) {//到了这一行说明前面放置好了已经
            String[] strings = new String[n];
            //char[][] board = new char[n][n];
            char[] board = new char[n];
            for (int i = 0; i < n; i++) {//遍历行
                Arrays.fill(board, '.');
                board[path[i]] = 'Q';
                strings[i] = new String(board);
            }
            result.add(strings);
        } else {//每次只要考虑当前行皇后放在哪一列可以就行了
            for (int i = 0; i < n; i++) {
                path[row] = i;
                if (check(row)) {
                    dfs(result, n, row + 1);
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
