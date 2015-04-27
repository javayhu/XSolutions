import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * hujiawei 15/4/25
 * <p/>
 * dfs
 * <p/>
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSum2_40 {

    public static void main(String[] args) {
        System.out.println(new CombinationSum2_40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);//先排序
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<Integer> path = new LinkedList<Integer>();
        dfs(result, path, candidates, 0, 0, target);
        return result;
    }

    private void dfs(List<List<Integer>> result, LinkedList<Integer> path, int[] candidates, int start, int sum, int target) {
        if (sum == target) {//达到目标
            addNewPath(result, new ArrayList<Integer>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //if (i>1 && candidates[i]==candidates[i-1])
            if (candidates[i] + sum <= target) {//检查当前位置start上的元素加上去之后能否行，能加上去的话就加上去
                path.addLast(candidates[i]);
                dfs(result, path, candidates, i + 1, sum + candidates[i], target);//
                path.removeLast();
            }
        }
    }

    private void addNewPath(List<List<Integer>> result, ArrayList<Integer> integers) {
        for (List<Integer> path : result) {
            if (path.size() != integers.size()) {
                continue;
            }
            boolean flag = true;
            for (int i = 0; i < path.size(); i++) {
                if (path.get(i).intValue() != integers.get(i).intValue()) {
                    flag = false;//存在不一样的
                    break;
                }
            }
            if (flag) {//存在一样的列表就返回
                return;
            }
        }
        result.add(integers);//遍历完了的话说明没有找到一样的列表，那么就可以添加上这条路径
    }

}
