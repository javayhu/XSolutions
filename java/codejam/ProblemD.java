import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * hujiawei - 14/11/9.
 */

//https://code.google.com/codejam/contest/6214486/dashboard#s=p3

public class ProblemD {

    private static int[][] board;
    private static List<Chess> chesses;

    public static void main(String[] args) throws Exception {
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("data/out.txt")));
        System.setOut(out);
        System.setErr(out);
        Scanner scanner = new Scanner(new FileInputStream("data/D-large-practice.in.txt"));

        int t = scanner.nextInt();
        for (int w = 1; w <= t; w++) {
            System.out.print("Case #" + w + ": ");
            board = new int[9][9];
            chesses = new ArrayList<Chess>();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board[i][j] = 0;//默认是空的字符
                }
            }
            int n = scanner.nextInt();
            String line;
            int x, y;
            char c;
            for (int i = 0; i < n; i++) {
                line = scanner.next();
                x = line.charAt(1) - '1' + 1;//行
                y = 8 - (line.charAt(0) - 'A');//列
                c = line.charAt(3);
                board[x][y] = 1;
                chesses.add(new Chess(x, y, c));
            }

            //for (int i = 0; i < 9; i++) {
            //    for (int j = 0; j < 9; j++) {
            //        System.out.print(board[i][j] + " ");
            //    }
            //    System.out.println();
            //}

            solve();

            System.out.println();
        }

        out.flush();
        out.close();
    }

    private static void solve() {
        int sum = 0;
        for (int i = 0, l = chesses.size(); i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (kill(chesses.get(i), chesses.get(j))) {
                    sum++;
                    //System.out.println(" ko");
                } //else System.out.println();
            }
        }
        System.out.print(sum);
    }

    //判断棋子c1是否能够杀死c2
    private static boolean kill(Chess c1, Chess c2) {
        if (c1.x == c2.x && c1.y == c2.y) return false;
        //System.out.print(c1.c + " (" + c1.x + "," + c1.y + ") " + c2.c + " (" + c2.x + "," + c2.y + ")");
        switch (c1.c) {
            case 'K':
                return k_kill(c1, c2);
            case 'Q':
                return q_kill(c1, c2);
            case 'R':
                return r_kill(c1, c2);
            case 'B':
                return b_kill(c1, c2);
            case 'N':
                return n_kill(c1, c2);
            case 'P':
                return p_kill(c1, c2);
        }
        return false;
    }

    //王
    private static boolean k_kill(Chess c1, Chess c2) {
        if (((Math.abs(c1.x - c2.x) == 1) || (Math.abs(c1.x - c2.x) == 0))
                && ((Math.abs(c1.y - c2.y) == 1) || (Math.abs(c1.y - c2.y) == 0))) return true;
        return false;
    }

    //后
    private static boolean q_kill(Chess c1, Chess c2) {
        if (r_kill(c1, c2) || b_kill(c1, c2)) return true;
        return false;
    }

    //车
    private static boolean r_kill(Chess c1, Chess c2) {
        if (c2.x != c1.x && c2.y != c1.y) return false;
        if (c2.x == c1.x) {//同一行
            int from = Math.min(c2.y, c1.y);
            int to = Math.max(c2.y, c1.y);
            for (int k = from + 1; k < to - 1; k++) {
                if (board[c1.x][k] != 0) {
                    return false;
                }
            }
            return true;
        }
        if (c2.y == c1.y) {//同一列
            int from = Math.min(c2.x, c1.x);
            int to = Math.max(c2.x, c1.x);
            for (int k = from + 1; k < to - 1; k++) {
                if (board[k][c1.y] != 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    //象
    private static boolean b_kill(Chess c1, Chess c2) {
        if (Math.abs(c1.x - c2.x) != Math.abs(c1.y - c2.y)) return false;
        int xdir = c1.x > c2.x ? -1 : 1;//direction!!!
        int ydir = c1.y > c2.y ? -1 : 1;
        for (int i = c1.x + xdir, j = c1.y + ydir; i != c2.x && j != c2.y; i = i + xdir, j = j + ydir) {
            if (board[i][j] != 0) {
                return false;
            }
        }
        return true;
    }

    //马
    private static boolean n_kill(Chess c1, Chess c2) {
        if (Math.abs(c1.x - c2.x) == 1 && Math.abs(c1.y - c2.y) == 2) {
            return true;
        }
        if (Math.abs(c1.y - c2.y) == 1 && Math.abs(c1.x - c2.x) == 2) {
            return true;
        }
        return false;
    }

    //兵
    private static boolean p_kill(Chess c1, Chess c2) {
        if (Math.abs(c1.x - c2.x) == 1 && c1.y - c2.y == 1) return true;
        return false;
    }
}

class Chess {

    int x;
    int y;
    char c;

    Chess(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }
}


