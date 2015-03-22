/**
 * hujiawei - 15/3/21.
 * <p/>
 * 动规
 * <p/>
 * https://leetcode.com/problems/edit-distance/
 */
public class EditDistance_72 {

    public static void main(String[] args) {
        System.out.println(new EditDistance_72().minDistance("str1c", "str2d"));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] f = new int[m + 1][n + 1];//长度为m的字符串需要m+1个隔板
        for (int i = 0; i <= m; i++) {//做一些数据初始化工作，方便后面代码不用判断边界值
            f[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            f[0][j] = j;
        }

        char chi, chj;
        for (int i = 1; i <= m; i++) {
            chi = word1.charAt(i-1);//
            for (int j = 1; j <= n; j++) {
                chj = word2.charAt(j-1);
                if (chi == chj) {
                    f[i][j] = i > 0 && j > 0 ? f[i - 1][j - 1] : 0;
                } else {
                    f[i][j] = 1 + Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1]));
                }
            }
        }
        return f[m][n];
    }

}
