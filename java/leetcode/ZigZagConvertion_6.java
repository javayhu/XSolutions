import java.util.ArrayList;
import java.util.List;

/**
 * hujiawei 15/4/24
 * <p/>
 * 字符串
 * <p/>
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConvertion_6 {

    public static void main(String[] args) {
        //PAHNAPLSIIGYIR
        System.out.println(new ZigZagConvertion_6().convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if (s == null || numRows == 0) return null;
        if (numRows == 1) return s;
        List<List<Character>> result = new ArrayList<List<Character>>();
        for (int i = 0; i < numRows; i++) {
            result.add(new ArrayList<Character>());//init
        }

        int k = 2 * numRows - 2, x;
        //找出规律即可，利用字符在字符串中的下标先对k取模，比较结果和numRows的大小，然后放到相应的list中
        for (int i = 0, n = s.length(); i < n; i++) {
            x = i % k;
            if (x < numRows) {
                result.get(x).add(s.charAt(i));
            } else {
                result.get(k - x).add(s.charAt(i));
            }
        }

        StringBuilder builder = new StringBuilder();
        for (List<Character> line : result) {
            builder.append(getLine(line));
        }
        return builder.toString();
    }

    private String getLine(List<Character> line) {
        StringBuilder builder = new StringBuilder();
        for (Character ch : line) {
            builder.append(ch);
        }
        return builder.toString();
    }
}
