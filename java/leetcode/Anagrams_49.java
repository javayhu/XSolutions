import java.util.*;

/**
 * hujiawei - 15/3/20.
 * <p/>
 * 字符串
 * <p/>
 * https://leetcode.com/problems/anagrams/
 */
public class Anagrams_49 {

    public static void main(String[] args) {

    }

    // 貌似LeetCode中不能使用Java中的Vector
    public List<String> anagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String tmp = String.valueOf(chars);
            if (groups.containsKey(tmp)) {
                groups.get(tmp).add(str);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                groups.put(tmp, list);
            }
        }

        List<String> result = new ArrayList<String>();
        for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.addAll(entry.getValue());
            }
        }

        return result;
    }

}
