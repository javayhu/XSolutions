/**
 * hujiawei - 15/3/20.
 * <p/>
 * <p/>
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring_5 {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring_5().longestPalindrome("gahdgdhab"));
    }

    // 动规解法，复杂度O(n^2)。设状态为{f(i,j)}，表示区间[i,j]是否为回文串
    // http://www.acmerblog.com/leetcode-solution-longest-palindromic-substring-6233.html
    public String longestPalindrome(String s) {
        int n = s.length(), max = 1, start = 0;
        boolean[][] f = new boolean[n][n];

        for (int j = 0; j < n; j++) {
            f[j][j] = true;
            for (int i = 0; i < j; i++) {//f[i,j]  f[i+1,j-1]
                f[i][j] = (s.charAt(j) == s.charAt(i)) && (j - i < 2 || f[i + 1][j - 1]);
                if (f[i][j] && max < (j - i + 1)) {
                    max = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start, start + max);
    }

}
