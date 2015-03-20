/**
 * hujiawei - 15/3/20.
 * <p/>
 * 字符串
 * <p/>
 * https://leetcode.com/problems/valid-number/
 */
public class ValidNumber_65 {

    public static void main(String[] args) {
        System.out.println(new ValidNumber_65().isNumber(".1"));//true
        System.out.println(new ValidNumber_65().isNumber("."));//false
        System.out.println(new ValidNumber_65().isNumber(".2e2"));//true
        System.out.println(new ValidNumber_65().isNumber("-1."));//true
        System.out.println(new ValidNumber_65().isNumber(".-4"));//false
        System.out.println(new ValidNumber_65().isNumber("+.8"));//true
        System.out.println(new ValidNumber_65().isNumber(" -."));//false
        System.out.println(new ValidNumber_65().isNumber(" 277707e26"));//true
    }

    // 我的解法，结合正则表达式直接处理
    // 其他解法：状态转移的判断 http://www.acmerblog.com/leetcode-solution-valid-number-6347.html
    public boolean isNumber(String s) {
        s = s.trim().toLowerCase();//统一成小写
        char ch;
        for (int i = 0; i < s.length(); i++) {//基本的字符检测
            ch = s.charAt(i);//只有正负号和.和e还有数字是可以的
            if (ch != '+' && ch != '-' && ch != '.' && ch != 'e' && !Character.isDigit(ch))
                return false;//如果有空格或者其他的字母或者特殊字符都是不合法的
        }

        // 模式匹配
        if (s.contains("e")) {//包含e的情况
            return isExponent(s);
        } else {//不包含e
            if (s.contains(".")) {//包含.
                return isFloat(s);
            } else {//不包含.
                return isInteger(s);
            }
        }
    }

    private boolean isExponent(String s) {//是否是一个合法的科学计数法表示的数字
        if (!s.contains("e")) return false;
        if (s.length() <= 1) return false;
        int indexe = s.indexOf("e");//左边是浮点数，右边是整数
        //正确的  错误的 "3e"
        //e的位置在最后面或者最前面
        if ((indexe == s.length() - 1 || indexe == 0))
            return false;
        //e的位置在中间
        return isInteger(s.substring(indexe + 1)) && (isFloat(s.substring(0, indexe)) || isInteger(s.substring(0, indexe)));
    }

    public boolean isFloat(String s) {//是否是一个浮点数
        return s.contains(".") && s.length() > 1 && (s.matches("[\\+|\\-]?[\\d]+\\.[\\d]*") || s.matches("[\\+|\\-]?[\\d]*\\.[\\d]+"));
    }

    public boolean isInteger(String s) {
        return s.matches("[\\+|\\-]?[\\d]+");//全部都是数字，而且必须至少有一个数字，前面可以有正负号
    }

}
