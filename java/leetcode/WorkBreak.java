import java.util.HashSet;
import java.util.Set;

/**
 * hujiawei - 10/19/14.
 */

//https://oj.leetcode.com/problems/word-break/

//动态规划，t[i]表示 0 -> i-1 可以

public class WorkBreak {

    public static void main(String[] args) {
        String s = "leetcode";
        Set<String> dict = new HashSet<String>();
        dict.add("leet");
        dict.add("code");
        System.out.println(new WorkBreak().wordBreak(s, dict));
    }

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
