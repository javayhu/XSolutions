import java.util.Arrays;

/**
 * 美团编程题第二题
 */
public class TestMT2 {

    public int limitedMaxSum(int[] arr, int length, int limit) {
        Arrays.sort(arr);
        int max = Integer.MIN_VALUE, s = 0;
        for (int i = length - 1; i >= 0; i--) {
            for (int j = length - 1; j >= 0; j--) {
                s = arr[i] + arr[j];
                if (s <= limit && s > max) {
                    max = s;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new TestMT2().limitedMaxSum(new int[]{1}, 1, 2));
    }
}