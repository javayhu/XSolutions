import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * hujiawei 15/4/25
 * <p/>
 * 模拟，字符串
 * <p/>
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class SubstringwithConcatenationofAllWords_30 {

    public static void main(String[] args) {
        System.out.println(new SubstringwithConcatenationofAllWords_30().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (s == null || words == null || words.length == 0) return result;
        int stringLen = s.length();//字符串的长度
        int wordLen = words[0].length();//每个模式串的长度
        int catLen = wordLen * words.length;//完整的匹配的子串的长度
        if (stringLen < catLen) return result;

        //words中字符串可能有重复 map记录每个word总共需要出现多少次
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }

        boolean flag;
        String subString;
        for (int i = 0; i <= stringLen - catLen; i++) {
            flag = true;
            HashMap<String, Integer> usedMap = new HashMap<String, Integer>(map);
            for (int j = i; j <= i + catLen - wordLen; j += wordLen) {
                subString = s.substring(j, j + wordLen);
                if (!usedMap.containsKey(subString) || usedMap.get(subString) < 1) {
                    flag = false;
                    break;//break for loop
                } else {//包含这个子串并且这个子串还有出现次数
                    usedMap.put(subString, usedMap.get(subString) - 1);//减少一次
                }
            }
            if (flag) {
                result.add(i);
            }
        }

        return result;
    }
}
