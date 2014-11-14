import java.util.Arrays;
import java.util.Scanner;

/**
 * hujiawei - 14/11/8.
 */

//http://acm.hdu.edu.cn/showproblem.php?pid=5101

//Accepted 思路：将满足条件的所有组合减去每个班级中满足条件的所有组合，求解时可以将所有学生视为一个班

//先对所有班级的学生IQ值排序，某个班满足条件的组合数目类似插入排序，就是要找到数组的某个子序列中大于等于某个数的所有数字的个数

public class Select17B2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            int[][] vs = new int[n][];
            int allm = 0;
            for (int i = 0; i < n; i++) {//获取数据
                int m = scanner.nextInt();
                allm += m;
                vs[i] = new int[m];
                for (int j = 0; j < m; j++) {
                    vs[i][j] = scanner.nextInt();
                }
            }
            //排序每个班级
            for (int i = 0; i < n; i++) {
                Arrays.sort(vs[i]);
            }
            //排序所有学生
            int offset = 0;
            int[] all = new int[allm];
            for (int i = 0; i < n; i++) {
                System.arraycopy(vs[i], 0, all, offset, vs[i].length);
                offset += vs[i].length;
            }
            Arrays.sort(all);

            long sum = getCount(all, s);
            //System.out.println(sum);
            for (int i = 0; i < n; i++) {
                sum -= getCount(vs[i], s);
            }
            System.out.println(sum);
        }
    }

    //得到一个数组中满足两个元素之和大于s的组合数
    private static long getCount(int[] all, int s) {
        long res = 0;
        for (int i = 0, l = all.length; i < l; i++) {
            if (all[i] >= s) {//这个数比s+1更大，那么后面的数都可以和它组合
                res += l - i - 1;//
            } else {//否则的话找到从后面哪个数字开始可以和它进行组合
                int r = s + 1 - all[i];
                res += bs(all, r, i + 1, l-1);
            }
        }
        return res;
    }

    //得到一个数组从from到end之间满足大于等于r的数字的个数 [二分查找]
    private static int bs(int[] vs, int r, int from, int end) {
        int len = end - from + 1;//
        if (len <= 0) return 0;
        int left = from, right = end, mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (r <= vs[mid]) {
                right = mid - 1;
            } else if (r > vs[mid]) {
                left = mid + 1;
            }
        }
        return end - left + 1;
    }

}
