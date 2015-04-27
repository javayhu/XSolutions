/**
 * hujiawei 15/4/25
 * <p/>
 * 模拟
 * <p/>
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku_36 {

    public static void main(String[] args) {

    }

    //参考：http://www.acmerblog.com/leetcode-solution-valid-sudoku-6211.html
    public boolean isValidSudoku(char[][] board) {
        boolean[] flag;

        for (int i = 0; i < 9; i++) {
            flag = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (!check(board[i][j], flag)) {//检查第i行
                    return false;
                }
            }

            flag = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (!check(board[j][i], flag)) {//检查第i列
                    return false;
                }
            }
        }

        for (int r = 0; r < 3; r++) {//检查9个小格子，注意遍历小格子的写法
            for (int c = 0; c < 3; c++) {
                flag = new boolean[9];
                for (int i = 3 * r; i <= 3 * r + 2; i++) {
                    for (int j = 3 * c; j <= 3 * c + 2; j++) {
                        if (!check(board[i][j], flag)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    private boolean check(char c, boolean[] flag) {
        if (c == '.') return true;
        if (flag[c - '1']) return false;
        flag[c - '1'] = true;
        return true;
    }

}
