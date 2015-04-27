/**
 * hujiawei 15/4/26
 * <p/>
 * 数组
 * <p/>
 * https://leetcode.com/problems/rotate-image/
 */
public class RotateImage_48 {

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new RotateImage_48().rotate(a);
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length, t;
        //沿着水平对角线反转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                t = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];//n-1!!!
                matrix[n - 1 - i][j] = t;
            }
        }
        //System.out.println(Arrays.toString(matrix));

        //沿着主对角线反转
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

        //System.out.println(Arrays.toString(matrix));
    }

}
