import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * hujiawei - 14/11/9.
 */

//https://code.google.com/codejam/contest/6214486/dashboard#s=p0

public class ProblemA {

    private static int s;
    private static int[][] p;

    public static void main(String[] args) throws Exception {
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("data/out.txt")));
        System.setOut(out);
        System.setErr(out);
        Scanner scanner = new Scanner(new FileInputStream("data/in.txt"));
        int t = scanner.nextInt();
        int c = 1;
        while (t-- > 0) {
            s = scanner.nextInt();
            p = new int[s][s];
            for (int i = 0; i < s; i++) {
                for (int j = 0; j < s; j++) {
                    p[i][j] = scanner.nextInt();
                }
            }
            System.out.print("Case #" + c + ": ");
            solve();
            c++;
        }
        out.flush();
        out.close();
    }

    private static void solve() {
        int r = 0, d = 1, max = s * s;
        while (max > 0 && max >= d) {
            Point maxp = findPoint(max);
            Result result = new Result(1, 1);
            dfs(maxp, result);
            if (result.d >= d) {
                r = result.r;
                d = result.d;
            }
            max = max - result.d;//
        }
        System.out.println(r + " " + d);
    }

    private static void dfs(Point current, Result result) {
        //left
        Point left = current.left();
        if (left != null && p[left.x][left.y] == p[current.x][current.y] - 1) {
            result.r = p[left.x][left.y];
            result.d++;
            dfs(left, result);
            return;
        }
        //right
        Point right = current.right();
        if (right != null && p[right.x][right.y] == p[current.x][current.y] - 1) {
            result.r = p[right.x][right.y];
            result.d++;
            dfs(right, result);
            return;
        }
        //up
        Point up = current.up();
        if (up != null && p[up.x][up.y] == p[current.x][current.y] - 1) {
            result.r = p[up.x][up.y];
            result.d++;
            dfs(up, result);
            return;
        }
        //down
        Point down = current.down();
        if (down != null && p[down.x][down.y] == p[current.x][current.y] - 1) {
            result.r = p[down.x][down.y];
            result.d++;
            dfs(down, result);
            return;
        }
    }

    private static Point findPoint(int max) {
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                if (p[i][j] == max) {
                    return new Point(s, i, j);
                }
            }
        }
        return null;
    }

}

class Point {

    int s;
    int x;
    int y;

    Point(int s, int x, int y) {
        this.s = s;
        this.x = x;
        this.y = y;
    }

    Point up() {
        if (x - 1 >= 0) return new Point(this.s, this.x - 1, this.y);
        return null;
    }

    Point down() {
        if (x + 1 < s) return new Point(this.s, this.x + 1, this.y);
        return null;
    }

    Point left() {
        if (y - 1 >= 0) return new Point(this.s, this.x, this.y - 1);
        return null;
    }

    Point right() {
        if (y + 1 < s) return new Point(this.s, this.x, this.y + 1);
        return null;
    }
}

class Result {

    int r;
    int d;

    Result(int r, int d) {
        this.r = r;
        this.d = d;
    }
}




