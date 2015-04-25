/**
 * hujiawei - 15/3/20.
 * <p/>
 * 递归
 * <p/>
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatching_10_2 {

    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching_10_2().isMatch("aab", "c*a*b"));
    }

    // 递归
    // https://leetcode.com/discuss/22034/share-a-short-java-solution
    public boolean isMatch(String s, String p) {
        if (p.contains(".") || p.contains("*")) {
            //如果p的长度为1，那么就是.或者*
            //如果p的长度大于1，那么如果第二个字符是*
            //上面两种情况下，都只需要判断s的第一个字符和p的第一个字符是否匹配，以及递归判断后面的字符串是否match
            if (p.length() == 1 || p.charAt(1) != '*')
                return comp(s, p, s.length(), 0) && isMatch(s.substring(1), p.substring(1));

            //
            for (int i = 0; i == 0 || comp(s, p, s.length(), i - 1); i++) {
                if (isMatch(s.substring(i), p.substring(2)))
                    return true;
            }
        }
        return s.equals(p);
    }

    //判断s的第i位和p的第1位是否匹配
    private boolean comp(String s, String p, int sLen, int i) {
        return sLen > i && (p.charAt(0) == s.charAt(i) || p.charAt(0) == '.');
    }

}
