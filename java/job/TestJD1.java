import java.util.Scanner;

/**
 * 京东笔试第一题
 */
public class TestJD1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[][] s = new int[6][6];
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    s[i][j] = scanner.nextInt();
                }
            }
            func(s);
        }
    }

    private static void func(int[][] s) {
        int[][] w = new int[6][6];
        w[0][0] = s[0][0];
        for (int i = 1; i < 6; i++) {
            w[i][0] = w[i - 1][0] + s[i][0];
            w[0][i] = w[0][i - 1] + s[0][i];
        }

        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                w[i][j] = Math.max(w[i - 1][j], w[i][j - 1]) + s[i][j];
            }
        }

        System.out.println(w[5][5]);
    }

}