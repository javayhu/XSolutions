import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * hujiawei - 15/3/22.
 * <p/>
 * DFS
 * <p/>
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning_131 {

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning_131().partition("aab"));
    }

    private boolean[][] p;
    private List<String> path;
    private List<List<String>> result;

    public List<List<String>> partition(String s) {
        int n = s.length();
        p = new boolean[n][n];
        // 初始化，计算从i到j是否是回文字符串 (字符i和字符j都包括在内)
        for (int j = 0; j < n; j++) {
            p[j][j] = true;//其实也就是j==i的时候
            for (int i = 0; i < j; i++) {
                //更加精简版本的用于判断是否是回文字符串的代码
                p[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 2 || p[i + 1][j - 1]);
            }
        }

        // DFS得到路径
        result = new ArrayList<List<String>>();
        path = new ArrayList<String>();
        dfs(s, 0);

        return result;
    }

    private void dfs(String s, int start) {
        // 跳出深搜递归的条件
        if (start >= s.length()) {//已经出了字符串s的范围
            result.add(new ArrayList<String>(path));
            return;//记住这里要退出
        }

        // 从当前位置所有可行的搜索方案开始继续搜索
        for (int i = start; i < s.length(); i++) {
            if (p[start][i]) {//前面能够构成回文字符串
                path.add(s.substring(start, i + 1));//添加这个可行的子串
                dfs(s, i + 1);//继续深搜
                path.remove(path.size() - 1);//去掉刚刚添加的那个路径
            }
        }
    }

}
