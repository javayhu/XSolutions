package CF279;

import java.util.*;

//http://codeforces.com/contest/490/problem/B

//ac
public class B279 {


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int n = cin.nextInt();

        int[] q = new int[n];
        Map<Integer, Integer> beforeMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> afterMap = new HashMap<Integer, Integer>();

        int a, b;
        boolean fa = false, fb = false;
        for (int i = 0; i < n; i++) {
            a = cin.nextInt();
            b = cin.nextInt();
            beforeMap.put(b, a);
            afterMap.put(a, b);
            if (!fa && a == 0) {
                q[1] = b;
                fa = true;
                afterMap.remove(a);
            }
            if (!fb && b == 0) {
                q[n - 2] = a;
                fb = true;
                beforeMap.remove(b);
            }
        }

        a = q[1];
        b = q[n - 2];

        if (n % 2 == 0) {
            int offset = 1;
            while (afterMap.containsKey(a)) {
                if (afterMap.get(a) != 0) {
                    q[offset + 2] = afterMap.get(a);
                    afterMap.remove(a);
                    a = q[offset + 2];
                    offset += 2;
                } else {
                    afterMap.remove(a);
                    break;
                }
            }
            offset = n - 2;
            while (beforeMap.containsKey(b)) {
                if (beforeMap.get(b) != 0) {
                    q[offset - 2] = beforeMap.get(b);
                    beforeMap.remove(b);
                    b = q[offset - 2];
                    offset -= 2;
                } else {
                    beforeMap.remove(b);
                    break;
                }
            }
        } else {
            int offset = 1;
            while (afterMap.containsKey(a)) {
                if (afterMap.get(a) != 0) {
                    q[offset + 2] = afterMap.get(a);
                    afterMap.remove(a);
                    a = q[offset + 2];
                    offset += 2;
                } else {
                    afterMap.remove(a);
                    break;
                }
            }
            int t;
            while (beforeMap.containsKey(b)) {
                t = beforeMap.get(b);
                beforeMap.remove(b);
                b = t;
            }
            int v, k;
            List<Integer> r = new ArrayList<Integer>();

            int first = 0;
            for (Integer key : beforeMap.keySet()) {
                if (!beforeMap.containsKey(beforeMap.get(key))) {
                    first = beforeMap.get(key);
                    break;
                }
            }

            r.add(first);
            while (afterMap.containsKey(first)) {
                r.add(afterMap.get(first));
                first = afterMap.get(first);
            }

            int j = 0;
            for (int i = 0; i < n; i++) {
                if (q[i] == 0) {
                    q[i] = r.get(j);
                    j++;
                }
            }
        }
        //
        for (int i = 0; i < n; i++) {
            System.out.print(q[i] + " ");
        }
        System.out.println();
    }

}
