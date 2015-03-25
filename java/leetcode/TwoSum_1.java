import java.util.Arrays;
import java.util.HashMap;

/**
 * hujiawei - 15/3/24.
 * <p/>
 * 数组
 * <p/>
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum_1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum_1().twoSum(new int[]{0, 3, 2, 0}, 0)));
        System.out.println(Arrays.toString(new TwoSum_1().twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(new TwoSum_1().twoSum(new int[]{1, 4, 9, 8, 3, 6}, 11)));
    }

    // 参考解法：https://leetcode.com/discuss/27634/java-solution-using-hash-table
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {//如果已经保存过了，说明的是前面有个数字和它加起来就是target
                result[0] = map.get(numbers[i])+1;
                result[1] = i+1;
                return result;
            }
            map.put(target - numbers[i], i);//有意思的是这里保存的是差值
        }
        return result;
    }

    // 下面的这种方法是错误的，对于有重复元素而且又是结果中的重要部分的话该方法得不到正确的解，例如{0, 3, 2, 0}, 0
    public int[] twoSum2(int[] numbers, int target) {
        //先用Hash表把每个数字的下标位置保存起来
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);//数组中的元素可以有重复的！而且有时候和正是这两个重复的元素之和
        }
        //然后再判断
        for (int k : numbers) {
            if (map.containsKey(target - k) && !map.get(target - k).equals(map.get(k))) {//不能是同一个位置
                return new int[]{map.get(k) + 1, map.get(target - k) + 1};
            }
        }
        return null;
    }

}
