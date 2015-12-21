import java.util.HashMap;
import java.util.Scanner;

/**
 * hujiawei 15/9/17
 */
public class Dianping1 {

    public static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    private final int a = 1;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            System.out.println(fun(n));
        }
    }

    public static int fun(int n) {
        if (n <= 1) return 1;
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            return fun(n - 1) * n;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
