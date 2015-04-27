/**
 * hujiawei 15/4/25
 * <p/>
 * dfs，回溯
 * <p/>
 * https://leetcode.com/problems/sudoku-solver/
 */
public class SudokuSolover_37 {

    //Input:	["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]
    //Output:	["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]
    //Expected:	["519748632","783652419","426139875","357986241","264317598","198524367","975863124","832491756","641275983"]

    public static void main(String[] args) {

    }

    //参考：http://www.acmerblog.com/leetcode-solution-sudoku-solver-6299.html
    public void solveSudoku(char[][] board) {
        canSolveSudoku(board);
    }

    public boolean canSolveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {//如果该位置为空白
                    for (int k = 0; k < 9; k++) {//从1到9中按照顺序尝试
                        board[i][j] = (char) ('1' + k);
                        if (isValid(board, i, j) && canSolveSudoku(board)) {
                            return true;
                        }
                        board[i][j] = '.';//没有返回成功的话
                    }
                    return false;//9个数字都试过了都不行的话那就解不出这个数独
                }
            }
        }
        return true;//注意，如果到达了这里说明数独已经解决了，而不是没有解决
    }

    private boolean isValid(char[][] board, int x, int y) {
        for (int i = 0; i < 9; i++) {//只要要修改的[x][y]位置上的数字没有在原来的行和列中出现就可以
            if (i != y && board[x][i] == board[x][y]) {//检查第x行
                return false;
            }
            if (i != x && board[i][y] == board[x][y]) {//检查第y列
                return false;
            }
        }

        //再保证[x][y]所在的小格子中没有出现重复的数字
        int r = x / 3, c = y / 3;
        for (int i = 3 * r; i <= 3 * r + 2; i++) {
            for (int j = 3 * c; j <= 3 * c + 2; j++) {
                if (board[i][j] == board[x][y] && ((i != x) || (j != y))) {
                    return false;
                }
            }
        }

        return true;
    }

}
