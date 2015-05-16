import java.util.Scanner;

/**
 * hujiawei - 15/3/25.
 */
public class XiaoMa2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String[] strs = s.split(",");
        int size = strs.length;
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        boolean[] f = new boolean[size];
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (!f[j] && nums[j] % nums[i] == 0) {
                    f[j] = true;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (f[i]) {
                builder.append(nums[i]).append(" ");
            }
        }

        System.out.println(builder.toString());
    }

}
