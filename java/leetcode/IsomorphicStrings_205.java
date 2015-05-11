import java.util.HashMap;
import java.util.HashSet;

/**
 * hujiawei 15/4/29
 * <p/>
 * 字符串
 * <p/>
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings_205 {

    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings_205().isIsomorphic("ab", "aa"));//ab aa
    }

    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null || (s.equalsIgnoreCase("") && t.equalsIgnoreCase(""))) return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>(s.length());//保存字符s映射到字符t
        HashSet<Character> set = new HashSet<Character>(s.length());//保存所有被映射的字符t
        char[] source = s.toCharArray();
        char[] dest = t.toCharArray();
        for (int i = 0; i < source.length; i++) {
            if (!map.containsKey(source[i])) {//不包含
                if (set.contains(dest[i])) {//已经被映射了
                    return false;
                } else {
                    map.put(source[i], dest[i]);//
                    set.add(dest[i]);
                }
            } else {//包含
                if (map.get(source[i]) != dest[i]) {//包含但是不等于目标字符
                    return false;
                }
            }
            //System.out.println(map);
        }
        return true;//
    }

}
