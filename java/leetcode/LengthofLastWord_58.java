/**
 * hujiawei - 15/3/20.
 * <p/>
 * 字符串
 * <p/>
 * https://leetcode.com/problems/length-of-last-word/
 */
public class LengthofLastWord_58 {

    public static void main(String[] args) {
        System.out.println(new LengthofLastWord_58().lengthOfLastWord("Hello World"));
        System.out.println(new LengthofLastWord_58().lengthOfLastWord("d "));//1
    }

    public int lengthOfLastWord(String s) {
        //if (!s.contains(" ")) return 0;
        s = s.trim();
        int len = s.length(), result = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                return result;
            } else {
                result++;
            }
        }
        return result;
    }

}
