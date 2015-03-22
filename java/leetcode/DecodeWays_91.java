import javax.xml.transform.Source;

/**
 * hujiawei - 15/3/21.
 * <p/>
 * 动规
 * <p/>
 * https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays_91 {

    public static void main(String[] args) {
        System.out.println(new DecodeWays_91().numDecodings("1234"));
    }

    // 动规解法 http://www.acmerblog.com/leetcode-solution-decode-ways-6209.html
    // C++版本的解法很巧妙，Java版本的解法更易懂
    public int numDecodings(String s) {
        //特殊情况判断
        if (null == s || "".equalsIgnoreCase(s)) return 0;
        if (s.length() == 1) return s.charAt(0) == '0' ? 0 : 1;

        int pre = 0, cur = 1;//这里是指当前站在第一个元素的位置上看，pre相当于i-2,cur相当于i-1
        for (int i = 1; i <= s.length(); i++) {//从1开始，结束时在length之后
            //接着处理一些特殊情况，首先是什么时候cur没有作用 -> 前面一个元素(位置i-1)是0，那么它对应的cur没有用
            if (s.charAt(i - 1) == '0') cur = 0;
            //然后是什么时候pre没有作用 -> 反推有用的情况，即 1x (0<=x<=9) 或者 2y (0<=y<=6)
            if (i < 2 || !(s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7'))) pre = 0;
            //最后更新pre和cur的值继续推进
            int tmp = cur;
            cur = pre + cur;
            pre = tmp;
        }

        return cur;
    }

}
