/**
 * hujiawei - 15/3/20.
 * <p/>
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome_125 {

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome_125().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome_125().isPalindrome("1a2"));
    }

    public boolean isPalindrome(String s) {
        if (null == s || "".equalsIgnoreCase(s)) {
            return true;
        }
        s = s.toLowerCase();
        int len = s.length(), i = 0, j = len - 1;
        while (i < j) {
            char lchar = 0, rchar = 0;
            while (i < len && !Character.isLetterOrDigit(lchar = s.charAt(i))) {
                i++;
            }
            while (j >= 0 && !Character.isLetterOrDigit(rchar = s.charAt(j))) {
                j--;
            }
            if (i < j && lchar != rchar) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
