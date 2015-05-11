import java.util.Arrays;
import java.util.LinkedList;

/**
 * hujiawei 15/5/2
 * <p/>
 * bfs
 * <p/>
 * https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundedRegions_130 {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        new SurroundedRegions_130().solve(board);
        System.out.println(Arrays.toString(board[0]));
        System.out.println(Arrays.toString(board[1]));
        System.out.println(Arrays.toString(board[2]));
        System.out.println(Arrays.toString(board[3]));
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        //从原来的上下左右四个边界上找到O出现的位置，并加入到队列中，只有从这些位置往里走能够到达的位置才是活的！
        LinkedList<Point> points = new LinkedList<Point>();
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') points.addLast(new Point(0, i));
            if (board[m - 1][i] == 'O') points.addLast(new Point(m - 1, i));
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O') points.addLast(new Point(i, 0));
            if (board[i][n - 1] == 'O') points.addLast(new Point(i, n - 1));
        }

        boolean[][] flag = new boolean[m][n];
        while (!points.isEmpty()) {
            Point cur = points.removeFirst();
            if (flag[cur.x][cur.y]) continue;//之前访问过的话就不用再访问了
            flag[cur.x][cur.y] = true;//标记这个位置最终应该是O
            //上下左右
            if (cur.x - 1 >= 0 && board[cur.x - 1][cur.y] == 'O') points.addLast(new Point(cur.x - 1, cur.y));
            if (cur.x + 1 < m && board[cur.x + 1][cur.y] == 'O') points.addLast(new Point(cur.x + 1, cur.y));
            if (cur.y - 1 >= 0 && board[cur.x][cur.y - 1] == 'O') points.addLast(new Point(cur.x, cur.y - 1));
            if (cur.y + 1 < n && board[cur.x][cur.y + 1] == 'O') points.addLast(new Point(cur.x, cur.y + 1));
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (flag[i][j]){
                    board[i][j]='O';
                }else{
                    board[i][j]='X';
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
