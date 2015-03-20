/**
 * hujiawei - 15/3/20.
 * <p/>
 * <p/>
 * https://leetcode.com/problems/implement-strstr/
 */
public class ImplementstrStr_28 {

    public static void main(String[] args) {
        System.out.println(new ImplementstrStr_28().strStr("abcds", "cd"));
    }

    // 暴力解法
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        for (int i = 0; i <= m - n; i++) {
            if (haystack.substring(i, i + n).equalsIgnoreCase(needle)) {
                return i;
            }
        }
        return -1;
    }

    // KMP算法
    //http://www.acmerblog.com/leetcode-solution-implement-strstr-6220.html

}
