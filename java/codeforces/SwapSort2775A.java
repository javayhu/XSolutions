import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * hujiawei - 14/11/5.
 */

//http://codeforces.com/contest/489/problem/A

//选择排序，最多只需要n次交换

public class SwapSort2775A {

    private static ArrayList<ASwap2> swaps;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = cin.nextInt();
        }
        swaps = new ArrayList<ASwap2>();
        int t;
        for (int i = 0; i < n; i++) {
            t = i;
            for (int k = i; k < n; k++) {
                if (a[k] < a[t]) t = k;//
            }
            if (t != i) {
                swaps.add(new ASwap2(t, i));
                int s = a[i];
                a[i] = a[t];
                a[t] = s;
            }
        }
        System.out.println(swaps.size());
        for (ASwap2 swap : swaps) {
            System.out.println(swap.x + " " + swap.y);
        }
    }

    static class ASwap2 {//

        int x, y;

        ASwap2(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}


