import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * hujiawei 15/4/25
 * <p/>
 * 编程之美初赛第一场 第一题 彩色的树
 */
public class Main1 {

    private static int n, result;
    private static int[] colors;
    private static boolean[] visited;
    private static List<HashSet<Integer>> tree;

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream("data/in.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int t = scanner.nextInt();
        for (int k = 1; k <= t; k++) {
            System.out.println("Case #" + k + ":");

            n = scanner.nextInt();
            colors = new int[n + 1];//0没用
            tree = new ArrayList<HashSet<Integer>>();
            for (int i = 0; i <= n; i++) {//0 -> n 0没用
                tree.add(new HashSet<Integer>());//init
                colors[i] = 0;//
            }

            int a, b;
            for (int i = 1; i < n; i++) {
                a = scanner.nextInt();
                b = scanner.nextInt();
                tree.get(a).add(b);
                tree.get(b).add(a);
            }

            int q = scanner.nextInt();
            scanner.nextLine();
            String line;
            for (int j = 1; j <= q; j++) {
                line = scanner.nextLine();
                if (line.startsWith("1")) {//query
                    result = 0;//
                    visited = new boolean[n + 1];
                    calSubTrees();
                } else {
                    String[] cs = line.split(" ");
                    int x = Integer.parseInt(cs[1]);
                    int y = Integer.parseInt(cs[2]);
                    colors[x] = y;
                }
            }
        }

    }

    private static void calSubTrees() {
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, colors[i]);
                result++;
            }
        }
        System.out.println(result);
    }

    private static void dfs(int start, int color) {
        if (colors[start] != color) {
            //result++;
            return;
        }
        visited[start] = true;
        for (Integer link : tree.get(start)) {
            if (!visited[link]) {
                dfs(link, color);
            }
        }
    }

}
