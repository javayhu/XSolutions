/**
 * hujiawei 15/5/3
 * <p/>
 * 字符串
 * <p/>
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring_76 {

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring_76().minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String S, String T) {
        if (S == null || S.length() == 0) return "";
        if (S.length() < T.length()) return "";

        int ASCII_MAX = 256;
        int[] appeared_count = new int[ASCII_MAX];
        int[] expected_count = new int[ASCII_MAX];

        for (int i = 0; i < T.length(); i++) expected_count[T.charAt(i)]++;

        int minWidth = Integer.MAX_VALUE, min_start = 0;  //最小窗口大小，起点
        int wnd_start = 0; //窗口的起点位置
        int appeared = 0;  //判断是否完整包含了一个T
        //尾指针不断往后扫
        for (int wnd_end = 0; wnd_end < S.length(); wnd_end++) {
            if (expected_count[S.charAt(wnd_end)] > 0) {  // this char is a part of T
                appeared_count[S.charAt(wnd_end)]++;
                if (appeared_count[S.charAt(wnd_end)] <= expected_count[S.charAt(wnd_end)])
                    appeared++;
            }
            if (appeared == T.length()) {  //完整包含了一个T
                //收缩头指针，要么是这个字符是不需要出现的，要么它的出现是多余的，因为后面该字符出现的次数也是够了的
                while (appeared_count[S.charAt(wnd_start)] > expected_count[S.charAt(wnd_start)]
                        || expected_count[S.charAt(wnd_start)] == 0) {
                    appeared_count[S.charAt(wnd_start)]--;
                    wnd_start++;
                }
                if (minWidth > (wnd_end - wnd_start + 1)) {
                    minWidth = wnd_end - wnd_start + 1;
                    min_start = wnd_start;
                }
            }
        }

        if (minWidth == Integer.MAX_VALUE) return "";
        else return S.substring(min_start, min_start + minWidth);
    }

}
