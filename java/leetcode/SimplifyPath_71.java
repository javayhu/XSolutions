import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * hujiawei - 15/3/20.
 * <p/>
 * 字符串
 * <p/>
 * https://leetcode.com/problems/simplify-path/
 */
public class SimplifyPath_71 {

    public static void main(String[] args) {
        System.out.println(new SimplifyPath_71().simplifyPath("/a/./b/../../c/"));
        System.out.println(new SimplifyPath_71().simplifyPath("/home/../../.."));
        System.out.println(new SimplifyPath_71().simplifyPath("/"));
    }

    // 使用栈结构来处理路径
    public String simplifyPath(String path) {
        path = path.replaceAll("[/]+", "/");
        String[] ps = path.split("/");
        Stack<String> stack = new Stack<String>();

        for (String p : ps) {
            if (p.equalsIgnoreCase(".")) continue;//当前路径
            if (p.equalsIgnoreCase("..")) {
                if (!stack.empty()) {//如果栈顶有元素就弹出
                    stack.pop();
                }
            } else {
                stack.push(p);
            }
        }

        LinkedList<String> list = new LinkedList<String>();
        while (!stack.empty()) {
            list.addFirst(stack.pop());
        }
        StringBuilder result = new StringBuilder();
        for (String str : list) {
            result.append("/").append(str);
        }
        path = result.toString().replaceAll("[/]+", "/");
        if (path.equalsIgnoreCase("")) {//如果为空的话就默认为根目录
            path = "/";
        }
        return path;
    }

}
