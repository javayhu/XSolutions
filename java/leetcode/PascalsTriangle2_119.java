import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * hujiawei 15/5/2
 * <p/>
 * 模拟
 * <p/>
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalsTriangle2_119 {

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle2_119().getRow(1));
    }

    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        Integer[] cur = new Integer[rowIndex];//
        for (int row = 0; row < rowIndex; row++) {//从第0行到第numRows-1行
            int rowSize = row + 1;//该行最多有多少个元素
            int last = 0, nextLast = 0;
            for (int i = 0; i < rowSize; i++) {
                if (i == 0 || i == rowSize - 1) {//为1的两种情况
                    cur[i] = 1;
                    nextLast = cur[i];
                } else {
                    nextLast = cur[i];
                    cur[i] = cur[i] + last;
                }
                last = nextLast;
            }
        }
        return Arrays.asList(cur);//为了方便这个方法，cur要定义成Integer[]
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int row = 0; row < numRows; row++) {//从第0行到第numRows-1行
            int rowSize = row + 1;//该行最多有多少个元素
            List<Integer> preRow = row > 1 ? result.get(row - 1) : null;
            List<Integer> curRow = new ArrayList<Integer>();
            for (int i = 0; i < rowSize; i++) {
                if (i == 0 || i == rowSize - 1) {
                    curRow.add(1);//为1的两种情况
                } else {
                    curRow.add(preRow.get(i - 1) + preRow.get(i));
                }
            }
            result.add(curRow);
        }
        return result;
    }

}
