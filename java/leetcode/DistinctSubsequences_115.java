/**
 * hujiawei 15/5/2
 * <p/>
 * dp 字符串
 * <p/>
 * 没有ac，StackOverflowError，递归太深了
 * <p/>
 * https://leetcode.com/problems/distinct-subsequences/
 */
public class DistinctSubsequences_115 {

    public static void main(String[] args) {
        System.out.println(new DistinctSubsequences_115().numDistinct("rabbbit", "rabbit"));
        System.out.println(new DistinctSubsequences_115().numDistinct("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc", "bcddceeeebecbc"));
    }

    int[][] dp;

    //参考网址：http://www.acmerblog.com/leetcode-solution-distinct-subsequences-6358.html
    public int numDistinct(String s, String t) {
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        int m = schars.length;
        int n = tchars.length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return numDistinctRec(schars, tchars, 0, 0);
    }

    //后面两个参数分别表示从schars的位置s开始和从tchars的位置t开始
    private int numDistinctRec(char[] schars, char[] tchars, int s, int t) {
        //前面四个判断条件很重要，顺序也很重要
        if (schars.length - s < tchars.length - t) return 0;//不可能有
        if (t == tchars.length) return 1;//模式串匹配完了
        if (s >= schars.length || t >= tchars.length) return 0;//s超了范围
        if (dp[s][t] >= 0) return dp[s][t];//是否缓存了结果?

        if (schars[s] == tchars[t]) {//源字符串当前位置字符等于模式字符串字符，
            return (dp[s][t] = numDistinctRec(schars, tchars, s + 1, t) + numDistinctRec(schars, tchars, s + 1, t + 1));
        } else {//不等于，向后一位
            return (dp[s][t] = numDistinctRec(schars, tchars, s + 1, t));
        }
    }

}
