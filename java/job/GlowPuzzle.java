import java.util.*;

/**
 * hujiawei 15/9/8
 */
public class GlowPuzzle {

    public static final int[][] S = {
            {0, 1, 2, 2},
            {1, 1, 2, 2},
            {1, 1, 2, 2},
            {1, 1, 2, 2}};

    public static final int[][] T = {
            {0, 2, 1, 2},
            {2, 1, 2, 1},
            {1, 2, 1, 2},
            {2, 1, 2, 1}};

    public static final int SIZE = 4;
    public static final String TMAP = map(T);
    public static final int[] DX = {0, 0, 1, -1};
    public static final int[] DY = {-1, 1, 0, 0};
    public static final String[] MOVE = {"L", "R", "D", "U"};
    public static Map<String, Integer> map = new HashMap<String, Integer>();
    public static LinkedList<State> queue = new LinkedList<State>();

    public static long startTime, endTime;

    public static void main(String[] args) {
        startTime = System.currentTimeMillis();
        State state = new State(S, 0, 0, 0, "");
        queue.addLast(state);
        while (!queue.isEmpty()) {
            state = queue.pollFirst();
            if (bfs(state.array, state.x, state.y, state.step, state.path)) {
                endTime = System.currentTimeMillis();
                System.out.println("time used: " + (endTime - startTime) / 1000 + " seconds");
                return;
            }
        }
    }

    // breath first search
    private static boolean bfs(int[][] s, int x, int y, int step, String path) {
        int nx, ny;
        for (int k = 0; k < SIZE; k++) {
            nx = x + DX[k];
            ny = y + DY[k];
            if (nx >= SIZE || nx < 0) continue;
            if (ny >= SIZE || ny < 0) continue;
            //copy array
            int[][] next = new int[SIZE][SIZE];
            for (int r = 0; r < SIZE; r++) {
                System.arraycopy(s[r], 0, next[r], 0, SIZE);
            }
            //exchange
            int t = next[x][y];
            next[x][y] = next[nx][ny];
            next[nx][ny] = t;
            //validate
            int nstep = step + 1;
            String npath = path + MOVE[k];
            String strmap = map(next);
            if (strmap.equalsIgnoreCase(TMAP)) {//reach the destination
                System.out.println(npath);
                //System.out.println(npath.length());
                return true;
            }
            if (!map.containsKey(strmap)) {//never been here before
                map.put(strmap, step);
                queue.addLast(new State(next, nx, ny, nstep, npath));
            }
        }
        return false;
    }

    // convert array to string
    public static String map(int[][] m) {
        //Arrays.toString(m);
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                builder.append(m[i][j]);
            }
        }
        return builder.toString();
    }

    //
    static class State {
        int[][] array;
        int x, y, step;
        String path;

        State(int[][] array, int x, int y, int step, String path) {
            this.array = array;
            this.x = x;
            this.y = y;
            this.step = step;
            this.path = path;
        }
    }
}
