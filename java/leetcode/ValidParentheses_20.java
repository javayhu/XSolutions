import java.util.Stack;

/**
 * hujiawei - 15/3/20.
 * <p/>
 * 栈
 * <p/>
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses_20 {

    public static void main(String[] args) {
        System.out.println(new ValidParentheses_20().isValid("()[]{}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                if (stack.empty()) return false;
                if ((ch == '}' && stack.peek() == '{')
                        || (ch == ']' && stack.peek() == '[')
                        || (ch == ')' && stack.peek() == '(')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

}
