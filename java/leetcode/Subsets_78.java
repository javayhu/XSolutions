import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * hujiawei - 15/3/24.
 * <p/>
 * 枚举
 * <p/>
 * https://leetcode.com/problems/subsets/
 */
public class Subsets_78 {

    public static void main(String[] args) {
        List<List<Integer>> result = new Subsets_78().subsets(new int[]{0, 1, 2});
        System.out.println(result);
    }

    //参考解法 增量构造法
    //http://www.acmerblog.com/leetcode-solution-subsets-6227.html
    public List<List<Integer>> subsets(int[] S) {
        if (null == S || S.length == 0) return null;
        Arrays.sort(S);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs(S, 0, path, result);
        return result;
    }

    // 深搜
    private void dfs(int[] s, int step, List<Integer> path, List<List<Integer>> result) {
        if (step == s.length) {
            result.add(new ArrayList<Integer>(path));//这里一定要new
            return;
        }
        //不选择s[step]
        dfs(s, step + 1, path, result);
        //选择s[step]
        path.add(s[step]);
        dfs(s, step + 1, path, result);
        path.remove(path.size() - 1);
    }

}
