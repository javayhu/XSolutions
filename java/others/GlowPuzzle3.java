import java.util.ArrayList;
import java.util.List;

/**
 * hujiawei 15/9/8
 */
public class GlowPuzzle3 {

    //0 for white, 1 for red, 2 for blue
    public static final int SIZE = 4;//rows=cols=4
    public static List<String> historyMoves = new ArrayList<String>();//all the history moves, for we don't want try again
    public static final String START = "0122112211221122";//matrix to string, concatenating the rows
    public static final String END = "0212212112122121";//RRDLLURRRDLLURDDLDRURDLULLDRUULU --> it takes time to run
    public static long startTime, endTime;//

    public static void main(String[] args) {
        startTime = System.currentTimeMillis();
        int x, y, cx = 0, cy = 0;//current location
        String current = START;//from start
        List<Path> moves = new ArrayList<Path>();//current paths (specific steps)
        List<String> sequence = new ArrayList<String>();//the sequence we go
        Path pathStart = new Path(cx, cy, current, sequence);//new a path
        moves.add(pathStart);
        historyMoves.add(current);
        while (!moves.isEmpty()) {//util no way to go
            showTempMoves(moves);
            List<Path> newMoves = new ArrayList<Path>();
            for (Path path : moves) {//try all the path, each path move forward one step
                x = path.x;
                y = path.y;
                if (x - 1 >= 0 && nextStep(x, y, x - 1, y, "U", path, newMoves)) {//turn up
                    return;
                }
                if (x + 1 < SIZE && nextStep(x, y, x + 1, y, "D", path, newMoves)) {//turn down
                    return;
                }
                if (y - 1 >= 0 && nextStep(x, y, x, y - 1, "L", path, newMoves)) {//turn left
                    return;
                }
                if (y + 1 < SIZE && nextStep(x, y, x, y + 1, "R", path, newMoves)) {//turn right
                    return;
                }
            }
            moves = newMoves;//
        }
    }

    //
    private static void showTempMoves(List<Path> moves) {
        for (Path path : moves) {
            System.out.print(path.current + " ");
        }
        System.out.println();
    }

    //go forward with direction
    private static boolean nextStep(int cx, int cy, int nx, int ny, String direction, Path path, List<Path> newMoves) {
        String cur = swap(path.current, cx, cy, nx, ny);
        List<String> seq = new ArrayList<String>(path.sequence);
        seq.add(direction);
        if (isEnd(cur)) {//check result
            showResult(seq);
            return true;
        } else if (!historyMoves.contains(cur)) {//not try this path yet
            newMoves.add(new Path(nx, ny, cur, seq));
            historyMoves.add(cur);//
            return false;
        } else {//already tried
            return false;
        }
    }

    //show the result sequence
    private static void showResult(List<String> seq) {
        System.out.println("=====================================================================");
        System.out.print("the result: ");
        for (String s : seq) {
            System.out.print(s);
        }
        System.out.println();
        endTime = System.currentTimeMillis();
        System.out.println("time used: " + (endTime - startTime) / 1000 + " seconds");
        System.out.println("=====================================================================");
    }

    //the path
    static class Path {
        int x, y;//current location in matrix
        String current;//current string -> matrix
        List<String> sequence;//

        Path(int x, int y, String current, List<String> sequence) {
            this.x = x;
            this.y = y;
            this.current = current;
            this.sequence = sequence;
        }

        @Override
        public boolean equals(Object o) {//if current is same, then path is same
            if (this == o) return true;
            if (!(o instanceof Path)) return false;

            Path path = (Path) o;

            if (current != null ? !current.equals(path.current) : path.current != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return current != null ? current.hashCode() : 0;
        }
    }

    //swap two cells
    private static String swap(String current, int x, int y, int i, int j) {
        char[] chars = current.toCharArray();
        char t = chars[x * SIZE + y];
        chars[x * SIZE + y] = chars[i * SIZE + j];
        chars[i * SIZE + j] = t;
        return new String(chars);
    }

    //comes to the end
    private static boolean isEnd(String current) {
        return current.equalsIgnoreCase(END);
    }

}
