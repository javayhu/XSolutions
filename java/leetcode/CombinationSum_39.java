import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * hujiawei 15/4/25
 * <p/>
 * dfs
 * <p/>
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum_39 {

    public static void main(String[] args) {
        System.out.println(new CombinationSum_39().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);//先排序
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<Integer> path = new LinkedList<Integer>();
        dfs(result, path, candidates, 0, 0, target);
        return result;
    }

    private void dfs(List<List<Integer>> result, LinkedList<Integer> path, int[] candidates, int start, int sum, int target) {
        if (sum == target) {//达到目标
            result.add(new LinkedList<Integer>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] + sum <= target) {//检查当前位置start上的元素加上去之后能否行，能加上去的话就加上去
                path.addLast(candidates[i]);
                dfs(result, path, candidates, i, sum + candidates[i], target);//
                path.removeLast();
            }
        }
    }

}
