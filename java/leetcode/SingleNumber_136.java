/**
 * hujiawei 15/4/27
 * <p/>
 * 位运算
 * <p/>
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber_136 {

    public static void main(String[] args) {
        System.out.println(new SingleNumber_136().singleNumber(new int[]{1, 2, 3, 3, 1}));
    }

    //二进制异或运算
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }

}
