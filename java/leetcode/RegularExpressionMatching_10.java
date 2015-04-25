/**
 * hujiawei - 15/3/20.
 * <p/>
 * 动规
 * <p/>
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatching_10 {

    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching_10().isMatch("aab", "c*a*b"));
    }

    // 动规
    // http://www.acmerblog.com/leetcode-solution-regular-expression-matching-6221.html
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0)
            return true;
        if (p.length() == 0)
            return false;
        boolean[][] res = new boolean[s.length() + 1][p.length() + 1];
        res[0][0] = true;
        //res[m][n]=true 表示 s[0]~s[m-1] 与 p[0]~p[m-1] 匹配
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*') {//模式串当前位置为 *
                if (j > 0 && res[0][j - 1]) res[0][j + 1] = true;
                if (j < 1) continue;
                if (p.charAt(j - 1) != '.') {//前一个位置不是 .
                    for (int i = 0; i < s.length(); i++) {
                        if (res[i + 1][j] || j > 0 && res[i + 1][j - 1]
                                || i > 0 && j > 0 && res[i][j + 1] && s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 1) == p.charAt(j - 1))
                            res[i + 1][j + 1] = true;
                    }
                } else {//前一个位置是 .
                    int i = 0;
                    while (j > 0 && i < s.length() && !res[i + 1][j - 1] && !res[i + 1][j])
                        i++;
                    for (; i < s.length(); i++) {
                        res[i + 1][j + 1] = true;
                    }
                }
            } else {//模式串当前位置不是 *
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')//匹配
                        res[i + 1][j + 1] = res[i][j];//取决于前面的匹配情况
                }
            }
        }

        return res[s.length()][p.length()];
    }

}
