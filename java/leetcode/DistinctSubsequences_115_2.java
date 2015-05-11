/**
 * hujiawei 15/5/2
 * <p/>
 * dp 字符串
 * <p/>
 * https://leetcode.com/problems/distinct-subsequences/
 */
public class DistinctSubsequences_115_2 {

    public static void main(String[] args) {
        System.out.println(new DistinctSubsequences_115_2().numDistinct("rabbbit", "rabbit"));
        System.out.println(new DistinctSubsequences_115_2().numDistinct("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc", "bcddceeeebecbc"));
    }

    //参考网址：https://leetcode.com/discuss/26680/easy-to-understand-dp-in-java
    public int numDistinct(String S, String T) {
        // array creation
        //mem[i+1][j+1] means that S[0..j] contains T[0..i] that many times as distinct subsequences.
        int[][] mem = new int[T.length() + 1][S.length() + 1];

        // filling the first row: with 1s
        // the empty string is a subsequence of any string but only 1 time.
        for (int j = 0; j <= S.length(); j++) {
            mem[0][j] = 1;
        }

        // the first column is 0 by default in every other rows but the first, which we need.
        for (int i = 0; i < T.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (T.charAt(i) == S.charAt(j)) {
                    mem[i + 1][j + 1] = mem[i][j] + mem[i + 1][j];
                } else {
                    mem[i + 1][j + 1] = mem[i + 1][j];
                }
            }
        }

        return mem[T.length()][S.length()];
    }

}
