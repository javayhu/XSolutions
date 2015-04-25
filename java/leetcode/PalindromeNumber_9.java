/**
 * hujiawei 15/4/24
 * <p/>
 * 模拟
 * <p/>
 * https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber_9 {

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber_9().isPalindrome(750735));
        System.out.println(new PalindromeNumber_9().isPalindrome(75057));
    }

    //需要注意的是，简单的reverse一个int会出现overflow的情况
    //但是有意思的是，本题是考虑一个int是否是回文的，即使出现overflow的情况结果还是对的，false
    //https://leetcode.com/discuss/27108/8-lines-of-java-accepted-solution-quite-concise
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = x, z = 0;
        while (y > 0) {
            z = z * 10 + y % 10;
            y = y / 10;
        }
        return x == z;
    }

}
