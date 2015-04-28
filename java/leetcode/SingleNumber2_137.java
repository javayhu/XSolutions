/**
 * hujiawei 15/4/27
 * <p/>
 * 位运算
 * <p/>
 * https://leetcode.com/problems/single-number-ii/
 */
public class SingleNumber2_137 {

    public static void main(String[] args) {
        System.out.println(new SingleNumber2_137().singleNumber(new int[]{1, 1, 3, 2, 3, 3, 1}));
    }

    //解法实际上就是用数组模拟三进制异或运算
    public int singleNumber(int[] nums) {
        int bitcount = 32;
        int[] res = new int[bitcount];

        for (int key : nums) {
            for (int i = 0; i < bitcount; i++) {
                res[i] += (key >> i) & 1;//加上0或者1
                res[i] %= 3;//对3取摸
            }
        }
        int result = 0;
        for (int i = 0; i < bitcount; i++) {
            result += (res[i] << i);//
        }
        return result;
    }

}
