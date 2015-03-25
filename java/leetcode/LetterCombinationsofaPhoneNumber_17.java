import java.util.ArrayList;
import java.util.List;

/**
 * hujiawei - 15/3/24.
 * <p/>
 * 枚举
 * <p/>
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsofaPhoneNumber_17 {

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsofaPhoneNumber_17().letterCombinations("23"));
    }

    public String[][] keyboard = new String[][]{
            {" "},//0是空格
            {""},//1是空字符串，有区别
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"},
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (null == digits || "".equalsIgnoreCase(digits)) return result;
        List<String> path = new ArrayList<String>();
        dfs(digits, 0, path, result);
        return result;
    }

    private void dfs(String s, int start, List<String> path, List<String> result) {
        // 达到了字符串的长度，这个时候就得到了一个解
        if (start == s.length()) {
            StringBuilder builder = new StringBuilder();
            for (String str : path) {
                builder.append(str);
            }
            result.add(builder.toString());
            return;
        }
        // 否则的话在该位置的可能选项中进行选择
        String[] options = keyboard[Integer.parseInt(s.substring(start, start + 1))];//
        for (String option : options) {
            path.add(option);
            dfs(s, start + 1, path, result);//
            path.remove(path.size() - 1);
        }
    }


}

