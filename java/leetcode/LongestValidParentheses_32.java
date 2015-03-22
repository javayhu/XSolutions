import java.util.Stack;

/**
 * hujiawei - 15/3/20.
 * <p/>
 * 栈
 * <p/>
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses_32 {

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses_32().longestValidParentheses("()()()"));
    }

    // 动规解法
    // http://www.acmerblog.com/leetcode-solution-longest-valid-parentheses-6260.html
    public int longestValidParentheses(String s) {
        int max_len = 0, n = s.length(), last = -1;//the position of the last ')'
        Stack<Integer> lefts = new Stack<Integer>();//keep track of the positions of non-matching '('s
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') {
                lefts.push(i);//左括号只需要入栈就行
            } else {
                if (lefts.empty()) {// no matching left
                    last = i;//右括号没有匹配的左括号，那么就更新last为该右括号的位置
                } else {// find a matching pair
                    lefts.pop();
                    if (lefts.empty()) {//更新max_len的值
                        max_len = Math.max(max_len, i - last);//
                    } else {//因为并非一定会出现左括号有剩余的情况，所以需要每次更新下max_len
                        max_len = Math.max(max_len, i - lefts.peek());//
                    }
                }
            }
        }
        return max_len;
    }

}
