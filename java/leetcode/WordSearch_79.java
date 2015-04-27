/**
 * hujiawei 15/4/26
 * <p/>
 * dfs
 * <p/>
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch_79 {

    //[
    //["ABCE"],
    //["SFCS"],
    //["ADEE"]
    //]

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(new WordSearch_79().exist(board, "SEEB"));
        char[][] board2 = {{'A', 'A'}};
        System.out.println(new WordSearch_79().exist(board2, "AAA"));
    }

    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        if (word == null || word.length() == 0) return false;
        char start = word.charAt(0);

        int m = board.length;//行
        int n = board[0].length;//列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == start) {//从任何可以作为起点的位置开始
                    boolean[][] visit = new boolean[m][n];
                    visit[i][j] = true;
                    if (dfs(visit, board, word, 1, i, j)) return true;
                    visit[i][j] = false;
                }
            }
        }
        return false;
    }

    //[x][y]是当前位置，start是当前要处理的字符的位置
    private boolean dfs(boolean[][] visit, char[][] board, String word, int start, int x, int y) {
        if (start == word.length()) {
            return true;
        }

        //[x][y]
        char target = word.charAt(start);
        if (x - 1 >= 0 && board[x - 1][y] == target && !visit[x - 1][y]) {
            visit[x - 1][y] = true;
            if (dfs(visit, board, word, start + 1, x - 1, y)) return true;
            visit[x - 1][y] = false;
        }
        if (y - 1 >= 0 && board[x][y - 1] == target && !visit[x][y - 1]) {
            visit[x][y - 1] = true;
            if (dfs(visit, board, word, start + 1, x, y - 1)) return true;
            visit[x][y - 1] = false;
        }
        if (x + 1 < board.length && board[x + 1][y] == target && !visit[x + 1][y]) {
            visit[x + 1][y] = true;
            if (dfs(visit, board, word, start + 1, x + 1, y)) return true;
            visit[x + 1][y] = false;
        }
        if (y + 1 < board[0].length && board[x][y + 1] == target && !visit[x][y + 1]) {
            visit[x][y + 1] = true;
            if (dfs(visit, board, word, start + 1, x, y + 1)) return true;
            visit[x][y + 1] = false;
        }

        return false;
    }

}
