import java.util.HashSet;
import java.util.Set;

/**
 * hujiawei - 10/19/14.
 */

//https://oj.leetcode.com/problems/word-break-ii/

public class WorkBreak2_140_no {

    public static void main(String[] args) {
        String s = "leetcode";
        Set<String> dict = new HashSet<String>();
        dict.add("leet");
        dict.add("cde");
        System.out.println(new WorkBreak2_140_no().wordBreak(s, dict));
    }

    // 参考网址 http://www.acmerblog.com/leetcode-solution-word-break-ii-6327.html
    public boolean wordBreak(String s, Set<String> dict) {
        int l = s.length();
        boolean[] f = new boolean[l + 1];
        f[0] = true;
        int len, end;
        for (int i = 0; i < l; i++) {
            if (!f[i]) continue;//before condition not meet
            for (String t : dict) {//try every string in the dict
                len = t.length();
                end = i + len;
                if (end > l) continue;
                if (s.substring(i, end).equals(t)) {//mark the end to be true
                    f[end] = true;
                }
            }
        }
        return f[l];//the last element
    }

}
