package CF2775;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * hujiawei - 14/11/5.
 */

//http://codeforces.com/contest/489/problem/B

//贪心，n个男孩m个女孩的舞蹈技能不同，匹配时要满足他们的技能差值不超过1，求最大匹配

public class BerSUBall2775B {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = cin.nextInt();
        }
        int m = cin.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = cin.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int count = 0;
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (Math.abs(a[i] - b[j]) <= 1) {
                i++;
                j++;
                count++;
            } else {
                if (a[i] < b[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        System.out.println(count);
    }

}
