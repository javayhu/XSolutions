import java.util.ArrayList;
import java.util.Arrays;

/**
 * hujiawei - 14/11/18.
 */
public class TestCodeForces {

    public static void main(String[] args) {
        //int[][] a = new int[3][2];
        //System.out.println(a[0]);

        int n = 10;
        ArrayList<ArrayList<Integer>> nodes = new ArrayList<ArrayList<Integer>>(n);
        for (int i = 0; i < n; i++) {
            nodes.add(new ArrayList<Integer>());
        }
        System.out.println(nodes.get(0));

        //a[0] = new int[]{1, 2, 3};
        //a[1] = new int[]{1, 2, 3, 4, 5};
        //
        //System.out.println(Arrays.toString(a));
        //System.out.println(a[0].length);
        //System.out.println(Arrays.toString(a[0]));
        //System.out.println(Arrays.toString(a[1]));
        //System.out.println(Arrays.toString(a[2]));
    }

}
