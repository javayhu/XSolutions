import java.util.ArrayList;
import java.util.List;

//求数组中最长递增子序列
public class Test {
    public static void main(String[] args) {
        int a[] = {1, -1, 2, -3, 4, -5, 6, -7};
        find1(a);
    }

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

        return b;
    }

    // [1, -1, 2, -3, 4, -5, 6, -7]
    // [1, 1, 2, 1, 3, 1, 4, 1]
    // 时间复杂度:O(N*N)
    public static void find1(int[] a) {
        int length = a.length;
        int[] list = new int[length];// 存储第i个元素之前的最长递增序列值
        List<Integer> result = new ArrayList<Integer>(); // 存储最长递增序列
        for (int i = 0; i < length; i++) {
            list[i] = 1;
            for (int j = 0; j < i; j++) {
                //if (a[j] < a[i] && list[j] + 1 > list[i]) {
                if (a[j] > a[i] && list[j] + 1 > list[i]) {
                    list[i] = list[j] + 1;
                    if (result.isEmpty()) {
                        result.add(list[j]);
                    }
                    if (!result.contains(list[i])) {
                        result.add(list[i]);
                    }
                }
            }
        }
        //System.out.println("第i个元素时最长递增序列：" + Arrays.toString(list));
        // 寻找list中最大值
        int max = list[0];
        for (int i = 0; i < length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
        System.out.println("最长递增序列长度：" + max);
        System.out.println("最长递增序列：" + result);
    }
}
