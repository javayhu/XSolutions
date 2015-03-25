import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * hujiawei - 15/3/24.
 * <p/>
 * 枚举
 * <p/>
 * https://leetcode.com/problems/subsets-ii/
 */
public class Subsets2_90 {

    public static void main(String[] args) {
        List<List<Integer>> result = new Subsets2_90().subsetsWithDup(new int[]{0,1, 1, 2});
        System.out.println(result);
    }

    //参考解法 增量构造法
    //这题有重复元素，但本质上，跟上一题很类似，上一题中元素没有重复，相当于每个元素只能
    //选0 或1 次，这里扩充到了每个元素可以选0 到若干次而已。
    //http://www.acmerblog.com/leetcode-solution-subsets-ii-6250.html
    public List<List<Integer>> subsetsWithDup(int[] S) {
        if (null == S || S.length == 0) return null;
        Arrays.sort(S);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        dfs(S, 0, path, result);
        return result;
    }

    // 深搜
    private void dfs(int[] s, int start, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(path));

        for (int i = start; i < s.length; i++) {
            //因为数组s是排序了的，所以如果出现s[i - 1] == s[i]的话，此时不需要再深搜，因为前面的已经处理了
            if (i != start && s[i - 1] == s[i]) {//
                continue;
            }
            path.add(s[i]);
            dfs(s, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

}
