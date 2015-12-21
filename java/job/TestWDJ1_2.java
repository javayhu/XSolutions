import java.util.ArrayList;
import java.util.HashMap;

/**
 * 豌豆荚1：树的深度 解法二
 */
public class TestWDJ1_2 {

    public static void main(String[] args) {
        int[] array = {3, 3, 3, -1, 2};
        System.out.println(getDepth(array));
    }

    public static int visited = 0;

    public static int getDepth(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 0; i < array.length; i++) {
            int k = array[i];
            if (map.containsKey(k)) {
                map.get(k).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(k, list);
            }
        }

        //int depth = 0;
        //depth = findRoot(array, -1, depth);

        //depth = dfs(map, -1, depth);
        dfs(map,-1);

        return depth;
    }

    static int depth=0;

    // 返回以root为根的子树的高度，depth是从根到root的高度
    private static int dfs(HashMap<Integer, ArrayList<Integer>> map, int root) {
        if (!map.containsKey(root)) return 0;//map中不存在该root
        ArrayList<Integer> list = map.get(root);//map中存在root
        for (int i = 0; i < list.size(); i++) {
            depth = Math.max(dfs(map, list.get(i)), depth);
        }
        return depth;
    }

    /*// 返回以root为根的子树的高度，depth是从根到root的高度
    private static int dfs(HashMap<Integer, ArrayList<Integer>> map, int root, int depth) {
        if (!map.containsKey(root)) return 0;//map中不存在该root
        ArrayList<Integer> list = map.get(root);//map中存在root
        for (int i = 0; i < list.size(); i++) {
            depth = Math.max(dfs(map, list.get(i), depth + 1), depth);
        }
        return depth;
    }*/

    public static int findRoot(int[] array, int root, int depth) {
        int temp = depth;
        if (array.length == visited)
            return depth;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == root) {
                visited++;
                depth = Math.max(depth, findRoot(array, i, temp + 1));
            }
        }
        return depth;
    }
}