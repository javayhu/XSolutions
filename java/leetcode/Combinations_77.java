import java.util.ArrayList;
import java.util.List;

/**
 * hujiawei - 15/3/24.
 * <p/>
 * 枚举 类似Subsets
 * <p/>
 * https://leetcode.com/problems/combinations/
 */
public class Combinations_77 {

    public static void main(String[] args) {
        System.out.println(new Combinations_77().combine(10, 7));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs(n, k, 1, path, result);//这次从1开始
        return result;
    }

    private void dfs(int n, int k, int start, List<Integer> path, List<List<Integer>> result) {
        // 长度达到k
        if (path.size() == k) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        // 特殊情况条件：由于前面有些元素没有选择导致后面的元素即使全部选择也还是不够长度k
        if (path.size() + n - start + 1 < k) return;//

        // 不选择start
        dfs(n, k, start + 1, path, result);

        // 选择start
        path.add(start);
        dfs(n, k, start + 1, path, result);
        path.remove(path.size() - 1);
    }
}
