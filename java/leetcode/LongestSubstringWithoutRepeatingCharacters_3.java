/**
 * hujiawei - 15/3/22.
 * <p/>
 * 贪心
 * <p/>
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * <p/>
 * 假设子串里含有重复字符，则父串一定含有重复字符，单个子问题就可以决定父问题，因此可以用贪心法。
 * 跟动规不同，动规里，单个子问题只能影响父问题，不足以决定父问题。
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters_3().lengthOfLongestSubstring("b"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters_3().lengthOfLongestSubstring("bbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] hash = new int[256];//假设字符串中的字符就是256个[有些解法认为是26个字母]
        for (int i = 0; i < 256; i++) {
            hash[i] = -1;
        }
        int max = 0, start = 0;//最长的无重复子串的长度，当前正在记录的子串的起点
        for (int i = 0; i < n; i++) {
            if (hash[s.charAt(i)] >= start) {//该字符上次出现的地方正是在当前记录的子串中，即出现了重复字符
                if (i - start > max) max = i - start;//计算下当前的长度
                start = hash[s.charAt(i)] + 1;//start设置为从那个重复字符的下一位开始
            }
            hash[s.charAt(i)] = i;//记录该字符出现的位置
        }
        if (n - start > max) max = n - start;//最后多计算一次，因为有可能最后一个子串没有出现重复字符
        return max;
    }

}
