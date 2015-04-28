/**
 * hujiawei 15/4/27
 * <p/>
 * 模拟
 * <p/>
 * https://leetcode.com/problems/spiral-matrix-ii/
 */
public class SpiralMatrix2_59 {

    public static void main(String[] args) {
        int[][] result = new SpiralMatrix2_59().generateMatrix(1);
        System.out.println();
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n < 1) return matrix;

        int beginRow = 0, endRow = matrix.length - 1;
        int beginCol = 0, endCol = matrix[0].length - 1;

        int k = 1;
        while (true) {
            //从左到右
            for (int i = beginCol; i <= endCol; i++) {
                matrix[beginRow][i] = k++;
            }
            if (++beginRow > endRow) break;//开始行增加1
            //从上到小
            for (int i = beginRow; i <= endRow; i++) {
                matrix[i][endCol] = k++;
            }
            if (--endCol < beginCol) break;//结束列减少1
            //从右到左
            for (int i = endCol; i >= beginCol; i--) {
                matrix[endRow][i] = k++;
            }
            if (--endRow < beginRow) break;//结束行减少1
            //从下到上
            for (int i = endRow; i >= beginRow; i--) {
                matrix[i][beginCol] = k++;
            }
            if (++beginCol > endCol) break;//开始列增加1
        }

        return matrix;
    }

}
