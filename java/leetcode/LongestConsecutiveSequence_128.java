import java.util.HashMap;

/**
 * hujiawei 15/4/27
 * <p/>
 * 数组
 * <p/>
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence_128 {

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence_128().longestConsecutive(new int[]{6, 3, 9, 4, 10, 5, 1}));
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer, Boolean> used = new HashMap<Integer, Boolean>();
        for (int i : nums) {
            used.put(i, false);
        }

        int max = 0;
        for (int key : nums) {
            if (used.get(key)) continue;
            int len = 1;
            for (int i = key - 1; used.containsKey(i) && !used.get(i); i--) {//向左边扩展
                used.put(i, true);
                len++;
            }
            for (int i = key + 1; used.containsKey(i) && !used.get(i); i++) {//向右边扩展
                used.put(i, true);
                len++;
            }
            if (len > max) {
                max = len;
            }
        }

        return max;
    }

}
