import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * hujiawei - 15/3/24.
 * <p/>
 * 枚举
 * <p/>
 * https://leetcode.com/problems/permutations/
 */
public class Permutations_46 {

    public static void main(String[] args) {
        System.out.println(new Permutations_46().permute(new int[]{1, 2, 4, 5}));
        System.out.println(new Permutations_46().permute(new int[]{}));
    }

    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs(num, path, result);//
        return result;
    }

    private void dfs(int[] num, List<Integer> path, List<List<Integer>> result) {
        // 长度达到了
        if (path.size() == num.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        // 还没达到长度
        for (int option : num) {
            if (path.contains(option)) {
                continue;
            }
            path.add(option);
            dfs(num, path, result);
            path.remove(path.size() - 1);
        }
    }
}
