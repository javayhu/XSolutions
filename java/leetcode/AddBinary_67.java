import java.util.Stack;

/**
 * hujiawei - 15/3/20.
 * <p/>
 * 字符串
 * <p/>
 * https://leetcode.com/problems/add-binary/
 */
public class AddBinary_67 {

    public static void main(String[] args) {
        System.out.println(new AddBinary_67().addBinary("11","1"));
    }

    public String addBinary(String a, String b) {
        int la = a.length(), lb = b.length();
        Stack<String> result = new Stack<String>();

        int i = la - 1, j = lb - 1, carry = 0;
        int ia, jb, val;
        while (i >= 0 || j >= 0) {
            ia = 0;//每次初始化成0
            jb = 0;
            if (i >= 0)//后面重新赋值
                ia = a.charAt(i) - '0';
            if (j >= 0)
                jb = b.charAt(j) - '0';
            // 这样就不用考虑哪个字符串已经没有字符了，当成0就行
            val = (ia + jb + carry) % 2;//计算该位的值
            result.push("" + val);
            carry = (ia + jb + carry) / 2;//重新计算进位
            i--;
            j--;
        }
        if (carry == 1) {//完了之后还有进位，补1
            result.push("1");
        }

        StringBuilder builder = new StringBuilder();
        while (!result.empty()) {
            builder.append(result.pop());
        }
        return builder.toString();
    }
}
