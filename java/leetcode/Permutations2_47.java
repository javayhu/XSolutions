import java.util.*;

/**
 * hujiawei - 15/3/24.
 * <p/>
 * 枚举
 * <p/>
 * https://leetcode.com/problems/permutations-ii/
 */
public class Permutations2_47 {

    public static void main(String[] args) {
        System.out.println(new Permutations2_47().permuteUnique(new int[]{1, 2, 1, 3}));
    }

    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(num);
        for (int k : num) {//统计每个数字共有多少个
            if (countMap.containsKey(k)) {
                countMap.put(k, countMap.get(k) + 1);
            } else {
                countMap.put(k, 1);
            }
        }
        //System.out.println(countMap);
        Set<Map.Entry<Integer, Integer>> entries = countMap.entrySet();
        dfs(num.length, entries, path, result);
        //dfs(num, path, result);//
        return result;
    }

    private Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

    private void dfs(int len, Set<Map.Entry<Integer, Integer>> entries, List<Integer> path, List<List<Integer>> result) {
        // 长度达到了
        if (path.size() == len) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        // 还没达到长度
        int count;
        for (Map.Entry<Integer, Integer> entry : entries) {
            //之前是用path.contains(option)判断该数字是否出现过了，现在要根据它出现的次数判断是否还能出现
            //首先统计数字option在path中出现的次数
            count = 0;
            for (int k : path) {
                if (entry.getKey() == k) {
                    count++;
                }
            }
            //如果还有出现机会那么就试着出现
            if (count < entry.getValue()) {
                path.add(entry.getKey());
                dfs(len, entries, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    // 错误的版本
    //private void dfs2(int[] num, List<Integer> path, List<List<Integer>> result) {
    //    // 长度达到了
    //    if (path.size() == num.length) {
    //        result.add(new ArrayList<Integer>(path));
    //        return;
    //    }
    //    // 还没达到长度
    //    int count;
    //    //-> 错误的原因在于这里！这里不应该是遍历数组num，因为这样遍历的话很多相同的数字会重复出现导致结果有重复
    //    for (int option : num) {
    //        //之前是用path.contains(option)判断该数字是否出现过了，现在要根据它出现的次数判断是否还能出现
    //        //首先统计数字option在path中出现的次数
    //        count = 0;
    //        for (int k : path) {
    //            if (option == k) {
    //                count++;
    //            }
    //        }
    //        //如果还有出现机会那么就试着出现
    //        if (count < countMap.get(option)) {
    //            path.add(option);
    //            dfs(num, path, result);
    //            path.remove(path.size() - 1);
    //        }
    //    }
    //}
}
