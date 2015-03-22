/**
 * hujiawei - 15/3/20.
 * <p/>
 * 字符串
 * <p/>
 * https://leetcode.com/problems/count-and-say/
 */
public class CountandSay_38 {

    public static void main(String[] args) {
        System.out.println(new CountandSay_38().countAndSay(4));
    }

    public String countAndSay(int n) {
        String str = "1";
        while (--n > 0) {
            str = generateNext(str);
        }
        return str;
    }

    private String generateNext(String str) {
        int count = 0;//初始化为0
        char key = str.charAt(0);//初始化为第一个字符
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (key == str.charAt(i)) {
                count++;
            } else {
                result.append(String.valueOf(count)).append(String.valueOf(key));
                key = str.charAt(i);
                count = 1;
            }
        }
        result.append(String.valueOf(count)).append(String.valueOf(key));
        return result.toString();
    }

}
