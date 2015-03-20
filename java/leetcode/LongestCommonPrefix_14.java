/**
 * hujiawei - 15/3/20.
 * <p/>
 * 字符串
 * <p/>
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix_14 {

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix_14().longestCommonPrefix(new String[]{"11", "112", "113"}));
    }

    // 纵向扫描
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String str = strs[0];
        for (int i = 0; i < str.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != str.charAt(i)) {
                    return str.substring(0, i);
                }
            }
        }
        return str;
    }
}
