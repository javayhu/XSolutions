/**
 * hujiawei - 15/3/20.
 * <p/>
 * 栈
 * <p/>
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses_32_wa {

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses_32_wa().longestValidParentheses("()[]{}"));
    }

    // 错误的动规
    // 不能通过f[i+1][j-1]来判断f[i][j]，例如 ()()，f[1][2]=false，但是f[0][3]=true
    public int longestValidParentheses(String s) {
        int max = 0, n = s.length();
        boolean[][] f = new boolean[n][n];
        // f[i][j]表示字符串从i到j是合法的
        for (int j = 0; j < n; j++) {
            f[j][j] = false;
            char charj = s.charAt(j);
            for (int i = 0; i < j; i++) {
                char chari = s.charAt(i);

                // 下面两种情况下有一个成立就说明f[i][j]是合法的
                f[i][j] = (j == i + 1 && isPair(chari, charj))
                        || (j >= i + 2 && isPair(chari, charj) && f[i + 1][j - 1]);

                if (f[i][j] && j - i + 1 > max) {//修改最大长度
                    max = j - i + 1;
                }
            }
        }
        return max;
    }

    private boolean isPair(char chari, char charj) {
        return (charj == '}' && chari == '{')
                || (charj == ']' && chari == '[')
                || (charj == ')' && chari == '(');
    }

}
