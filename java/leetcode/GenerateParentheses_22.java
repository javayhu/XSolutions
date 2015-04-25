import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * hujiawei 15/4/24
 * <p/>
 * 字符串，回溯法
 * <p/>
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses_22 {

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses_22().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        LinkedList<String> path = new LinkedList<String>();
        dfs(result, path, n, 0, 0, 0);
        return result;
    }

    //start 当前扩展到的位置，即开始考虑这个位置上放左括号还是右括号
    //left 已经使用的左括号个数 right 右括号个数
    private void dfs(List<String> result, LinkedList<String> path, int n, int start, int left, int right) {
        if (start == 2 * n) {//dfs到长度为n的时候说明一条路径已经生成了
            result.add(getPath(path));
            return;
        }
        //进行dfs扩展，保证右括号少于等于左括号
        if (left < n) {//只要左括号还没有用完，那么任何时候都还可以放左括号
            path.addLast("(");
            dfs(result, path, n, start + 1, ++left, right);
            path.removeLast();
            --left;
        }
        //放左括号和右括号都是可以尝试的，只要满足条件
        if (left > right && right < n) {//放上一个右括号
            path.addLast(")");
            dfs(result, path, n, start + 1, left, ++right);
            path.removeLast();
            --right;
        }
    }

    private String getPath(List<String> path) {
        StringBuilder builder = new StringBuilder();
        for (String s : path) {
            builder.append(s);
        }
        return builder.toString();
    }

}
