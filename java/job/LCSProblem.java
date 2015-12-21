import java.util.Arrays;

public class LCSProblem {

    public static void main(String[] args) {
        //保留空字符串是为了getLength()方法的完整性也可以不保留
        //但是在getLength()方法里面必须额外的初始化c[][]第一个行第一列
        //String[] x = {"", "A", "B", "C", "B", "D", "A", "B"};
        //String[] y = {"", "B", "D", "C", "A", "B", "A"};

        int[] x = {1, 2, 3, 4};
        int[] y = {2, 3, 4, 5};

        int[][] b = getLength(x, y);

        Display(b, x, x.length - 1, y.length - 1);
    }

    /**
     *
     */
    public static int[][] getLength(int[] x, int[] y) {
        int[][] b = new int[x.length][y.length];
        int[][] c = new int[x.length][y.length];

        for (int i = 1; i < x.length; i++) {
            for (int j = 1; j < y.length; j++) {
                //对应第一个性质
                if (x[i] == y[j]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                }
                //对应第二或者第三个性质
                else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 0;
                }
                //对应第二或者第三个性质
                else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = -1;
                }
            }
        }

        System.out.println("C:" + Arrays.toString(c));

        return b;
    }

    //回溯的基本实现，采取递归的方式
    public static void Display(int[][] b, int[] x, int i, int j) {
        if (i == 0 || j == 0)
            return;

        if (b[i][j] == 1) {
            Display(b, x, i - 1, j - 1);
            System.out.print(x[i] + " ");
        } else if (b[i][j] == 0) {
            Display(b, x, i - 1, j);
        } else if (b[i][j] == -1) {
            Display(b, x, i, j - 1);
        }
    }
}