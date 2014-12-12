package CF2775;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * hujiawei - 14/11/5.
 */

//http://codeforces.com/contest/489/problem/D

//组合题，空间换时间

public class UnbearableControversyofBeing2775D {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int n = cin.nextInt();
        int[] s = new int[n];//s[i]=j表示节点i有j个邻居
        int[][] v = new int[n][n];//v[i][j]=1 表示节点i和节点j相连
        int[][] t = new int[n][n];//t[i][j]=k表示节点i第j个邻居是k

        int m = cin.nextInt();
        int a, b;
        for (int i = 0; i < m; i++) {
            a = cin.nextInt();
            b = cin.nextInt();
            v[a - 1][b - 1] = 1;
            t[a - 1][s[a - 1]] = b - 1;
            s[a - 1]++;
        }

        //
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {//not the same node
                    int r = 0, n1;
                    for (int k = 0; k < s[i]; k++) {
                        n1 = t[i][k];
                        if (n1 != i && n1 != j && v[n1][j] == 1) {//nodes.get(n1).contains(j)
                            r++;
                        }
                    }
                    count += r * (r - 1) / 2;//combination
                }
            }
        }
        System.out.println(count);
    }

}
