/**
 * 豌豆荚1：树的深度
 */
public class TestWDJ1 {

    public static void main(String[] args) {
        int[] array = {3, 3, 3, -1, 2};
        System.out.println(getDepth(array));
    }

    public static int visited = 0;

    public static int getDepth(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int depth = 0;
        depth = findRoot(array, -1, depth);
        return depth;
    }

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