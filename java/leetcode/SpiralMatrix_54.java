import java.util.ArrayList;
import java.util.List;

/**
 * hujiawei 15/4/27
 * <p/>
 * 模拟
 * <p/>
 * https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix_54 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new SpiralMatrix_54().spiralOrder(matrix));
    }

    //参考：http://www.acmerblog.com/leetcode-solution-spiral-matrix-6261.html
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) return result;

        int beginRow = 0, endRow = matrix.length - 1;
        int beginCol = 0, endCol = matrix[0].length - 1;

        while (true) {
            //从左到右
            for (int i = beginCol; i <= endCol; i++) {
                result.add(matrix[beginRow][i]);
            }
            if (++beginRow > endRow) break;//开始行增加1
            //从上到小
            for (int i = beginRow; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }
            if (--endCol < beginCol) break;//结束列减少1
            //从右到左
            for (int i = endCol; i >= beginCol; i--) {
                result.add(matrix[endRow][i]);
            }
            if (--endRow < beginRow) break;//结束行减少1
            //从下到上
            for (int i = endRow; i >= beginRow; i--) {
                result.add(matrix[i][beginCol]);
            }
            if (++beginCol > endCol) break;//开始列增加1
        }

        return result;
    }

}
